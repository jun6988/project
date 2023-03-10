package com.bit.project.article.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.project.readingnote.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	
	Integer countByGender(String gender);

	Optional<Account> findById(Integer id);

	void deleteById(Integer id);
}
