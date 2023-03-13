package com.bit.project.readingnote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.project.article.repository.AccountRepository;
import com.bit.project.readingnote.entity.Account;
import com.bit.project.readingnote.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	// 추가
    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
	
	@GetMapping("/list")
	public List<Account> getAll(Account account) {
		
		System.out.println("user_count=" + accountRepository.count());
		//System.out.println("male_count=" + accountRepository.countByGender("male"));
		
//		accountService.updateReadingNoteCount(account);
		
		return accountService.getAccountList();
	}
	
//	@GetMapping("/test")
//    public ResponseEntity<List<Account>> getAllUsers() {
//        List<Account> getAccount = accountRepository.findAll();
//        List<Account> updatedAccounts = new ArrayList<>();
//        
//        for (Account account : getAccount) {
//            // 일부 컬럼만 선택하여 엔티티를 생성
//        	Account updatedAccount = new Account();
//            updatedAccount.setReading_note_count(account.getReading_note_count());
//        }
//        // 일부 컬럼만 갱신하고 반환
//        accountRepository.saveAll(updatedAccounts);
//        return ResponseEntity.ok(updatedAccounts);
//    }
	
	@GetMapping("/list/{id}")
	public Optional<Account> getAccountById(@PathVariable("id") String id) {
		
		return accountService.getAccountListById(id);
	}
	
	@PostMapping("/regist")
	public Account registAccount(@RequestBody Account account) {
		
		return accountService.registAccount(account);
	}
	
	@PutMapping("/update/{id}")
	public void updateAccount(
			@PathVariable("id") Integer id,
			@RequestBody Account account) {
		
		accountService.updateAccount(account);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeAccount(@PathVariable String id) {
		
		accountService.removeAccount(id);
	}
	
//	@GetMapping("/test")
//	public void getAgeGraph(Account account) {
//		
//		accountService.ageGraph(null);
//	}
	
}
