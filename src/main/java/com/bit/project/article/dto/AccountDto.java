package com.bit.project.article.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bit.project.readingnote.entity.Account;

public record AccountDto(
		String accountId, 
		String password,
		String nickname,
		String name,
		String email,
		String gender,
		LocalDate birthday,
		LocalDateTime createdAt, 
		String createdBy
) {
	public static AccountDto of(String accountId, String password, String nickname, String email) {
		return new AccountDto(accountId, password, nickname, null, null, null, null, null, null);
	}

	public static AccountDto of(
			String accountId, 
			String password,
			String nickname,
			String name,
			String email,
			String gender,
			LocalDate birthday,
			LocalDateTime createdAt, 
			String createdBy) {
		return new AccountDto(accountId, password, nickname, name, email, gender, birthday, createdAt, createdBy);
	}

	public static AccountDto from(Account entity) {
		return new AccountDto(
				entity.getAccountId(), 
				entity.getPassword(),
				entity.getName(),
				entity.getEmail(), 
				entity.getNickname(),
				entity.getGender(),
				entity.getBirthday(),
				entity.getCreatedAt(), 
				entity.getCreatedBy()
			);
	}

	public Account toEntity() {
		return Account.of(
				accountId, 
				password,
				nickname,
				email
			);
	}
}
