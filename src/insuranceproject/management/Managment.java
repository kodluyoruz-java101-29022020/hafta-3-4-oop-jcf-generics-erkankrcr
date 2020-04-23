package insuranceproject.management;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import insuranceproject.account.Account;
import insuranceproject.account.AccountManager;
import insuranceproject.account.IndividualAccount;
import insuranceproject.exception.InvalidAuthenticationException;
import insuranceproject.insurancetype.HealthInsurance;
import insuranceproject.insurancetype.Insurance;
import insuranceproject.user.User;

public class Managment {
	
	public static void run() throws InvalidAuthenticationException {
		Scanner scanner = new Scanner(System.in);
		AccountManager accountManager = new AccountManager();
		CreateMockUser(accountManager);
		Account account = LoginUser(accountManager,scanner);
		UserInfo(account);
	}
	private static void UserInfo(Account account) {
		System.out.println("Kullanıcı Adı : "+account.getUser().getName());
		System.out.println("Kullanıcı Soyadı : "+account.getUser().getSurname());
		System.out.println("Kullanıcı  Yaşı : "+account.getUser().getAge());
		System.out.println("Kullanıcı E-Postası : "+account.getUser().getEmail());
		System.out.println("Kullanıcı İşi : "+account.getUser().getJob());
		for(Insurance insurance : account.getInsurance()) {
			System.out.println("Sigorta Adı : "+insurance.getInsuranceName());
			System.out.println("Sigorta  Başlangıç Tarihi : "+insurance.getInsuranceStart());
			System.out.println("Sigorta Bitiş Tarihi : "+insurance.getInsuranceEnd());
		}
	}
	public static Account LoginUser(AccountManager accountManager, Scanner scanner) throws InvalidAuthenticationException {
		System.out.print("E-Posta Giriniz : ");
		String email = scanner.next();
		System.out.print("Şifre Giriniz : ");
		String password = scanner.next();
		return accountManager.login(email, password);
	}
	
	public static void CreateMockUser(AccountManager accountManager) {
		
		User user = new User(
						"Erkan",
						"Karacar",
						"erkankrcr@outlook.com.tr",
						"123erkan",
						"Programmer",
						(byte)21);
		List<Insurance> insuranceList = new ArrayList();
		Date startDate = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(LocalDate.of(2022, 12, 12).atStartOfDay(ZoneId.systemDefault()).toInstant());
		insuranceList.add(new HealthInsurance("HealthInsurance", 15,startDate, endDate));
		IndividualAccount individualAccount = new IndividualAccount(user,insuranceList); 
		accountManager.saveAccount(individualAccount);
		
	}
}
