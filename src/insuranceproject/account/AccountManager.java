package insuranceproject.account;

import java.util.TreeSet;

import insuranceproject.exception.InvalidAuthenticationException;

public class AccountManager {
	private TreeSet<Account> accountList;
	
	public AccountManager() {
		this.accountList = new TreeSet<Account>();
	}
	
	public Account login(String email, String password) throws InvalidAuthenticationException {
		
		for(Account item : accountList) {
			if(item.checkUser(email, password)) {
				System.out.println("Giriş Başarılı");
				return item;
			}
		}
		throw new InvalidAuthenticationException("Hatalı kullanıcı girişi");
	}
	
	
	public void saveAccount(Account account) {
		this.accountList.add(account);
	}
}
