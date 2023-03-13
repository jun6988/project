package com.bit.project.article.dto.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bit.project.article.dto.AccountDto;

import lombok.Getter;

// user account에서 필요한 정보
// Eclipse 안에 user 라는 항목이 있어서 user를 쓰면 필요없는 항목까지 다 가져오게 된다
public record BoardPrincipal(String username, String password,
		// 권한 (자기 글만 수정 추가)
		Collection<? extends GrantedAuthority> authorities, String email, String nickname)
		implements UserDetails {

	public static BoardPrincipal of(String username, String password, String email, String nickname) {
		Set<RoleType> roleTypes = Set.of(RoleType.USER);
		return new BoardPrincipal(username, password, roleTypes.stream().map(RoleType::getName)
				.map(SimpleGrantedAuthority::new).collect(Collectors.toUnmodifiableSet()), email, nickname);
	}

	public static BoardPrincipal from(AccountDto dto) {
		return BoardPrincipal.of(dto.accountId(), dto.password(), dto.email(), dto.nickname());
	}

	public AccountDto toDto() {
		return AccountDto.of(username, password, email, nickname);
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	// 권한 (자기 글만 수정 추가)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public enum RoleType {
		USER("ROLE_USER");

		@Getter
		private final String name;

		RoleType(String name) {
			this.name = name;
		}
	}
}
