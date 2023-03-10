package com.bit.project.readingnote.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.project.article.repository.AccountRepository;
import com.bit.project.readingnote.entity.Account;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	    // 리스트 처리
		public List<Account> getAccountList() {
			
			return accountRepository.findAll();
		}
		
		public Optional<Account> getAccountListById(Integer id) {
			
			return accountRepository.findById(id);
		}
		
		// 작성 처리
		public Account registAccount(Account account) {
			
			// 작성일자 문자열 변경
			LocalDateTime nowDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			
			account.setJoined_at(nowDateTime.format(formatter));
			
			// 현재일자와 생년월일을 이용한 만나이 계산
			LocalDate birthday = account.getBirthday();
			LocalDate nowDate = LocalDate.now();
			
			account.setAge(nowDate.getYear() - birthday.getYear());
			
//			account.setReading_note_count(readingNoteRepository.count()); // 독서노트 count
			
			return accountRepository.save(account);
			
//			// 연령대 그래프
//			int age = account.getAge();
//			
//	        if (age >= 20 && age < 30) {
//	            account.setTwentys_count(+1);
//	        } else if (age >= 30 && age < 40) {
//	            account.setThirtys_count(+1);
//	        } else if (age >= 40 && age < 50) {
//	            account.setFortys_count(+1);
//	        } else if (age >= 50 && age < 60) {
//	            account.setFifties_count(+1);
//	        }
			
		}
		
//		// 작성 처리
//		public User registGenderGraphByAccount(Account account) {
//			
//			// 성별 그래프
//			account.setMale_persent(accountRepository.countByGender("female") * 100 / accountRepository.count());
//			
//			return accountRepository.save(account);
//		}
		
//		public void registCount(Account account) {
//			
//			account.setReading_note_count(readingNoteRepository.countByReadingNote(null));
//		}
		
		// 수정 처리
		public Account updateAccount(Account account) {
			
//			 작성일자 문자열 변경
			LocalDateTime nowDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			
			account.setJoined_at(nowDateTime.format(formatter));
			
			// 현재일자와 생년월일을 이용한 만나이 계산
			LocalDate birthday = account.getBirthday();
			LocalDate nowDate = LocalDate.now();
			
			account.setAge(nowDate.getYear() - birthday.getYear());
			
			return accountRepository.saveAndFlush(account);
		}
		
//		// 독서노트 count 테스트
//		public Account updateReadingNoteCount(Account account) {
//			
//			account.setReading_note_count(readingNoteRepository.count());
//			
//			return accountRepository.save(account);
//		}
		
		// 삭제 처리
		public void removeAccount(Integer id) {
			
			accountRepository.deleteById(id);
		}
		
//		// 연령대 그래프
//		public void ageGraph(List<Account> accountList) {
//			
//			int[] ageGroupCount = new int[5]; // 10~19, 20~29, 30~39, 40~49, 50~59
//			int totalAccount = accountList.size();
//			
//		    for (Account account : accountList) {
//		        int age = account.getAge();
//		        if (age >= 10 && age < 20) {
//		            ageGroupCount[0]++;
//		        } else if (age >= 20 && age < 30) {
//		            ageGroupCount[1]++;
//		        } else if (age >= 30 && age < 40) {
//		            ageGroupCount[2]++;
//		        } else if (age >= 40 && age < 50) {
//		            ageGroupCount[3]++;
//		        } else if (age >= 50 && age < 60) {
//		            ageGroupCount[4]++;
//		        }
//		    }
//		    
//		    for (int i = 0; i < ageGroupCount.length; i++) {
//		        double percentage = (double) ageGroupCount[i] / totalAccount * 100;
//		        System.out.printf("%d대: %.2f%%\n", (i + 1) * 10, percentage);
//		    }
//		}
		
//		// 연령대 그래프
//		public Account ageGraph(Account account) {
//			
//			int twentys_count = 0;
//			int thirtys_count = 0;
//			int fortys_count = 0;
//			int fifties_count = 0;
//			
//			int age = account.getAge();
//			
//	        if (age >= 20 && age < 30) {
//	        	twentys_count++;
//	        } else if (age >= 30 && age < 40) {
//	        	thirtys_count++;
//	        } else if (age >= 40 && age < 50) {
//	        	fortys_count++;
//	        } else if (age >= 50 && age < 60) {
//	        	fifties_count++;
//	        }
	        
//			// 현재일자와 생년월일을 이용한 만나이 계산
//			LocalDate birthday = account.getBirthday();
//			LocalDate nowDate = LocalDate.now();
//			
//			account.setAge(nowDate.getYear() - birthday.getYear());
//			
//			return accountRepository.saveAndFlush(account);
//		}
		
}
