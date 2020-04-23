package insuranceproject.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import insuranceproject.address.Address;

public class User{
	private String name;
	private String surname;
	private String email;
	private String password;
	private String job;
	private byte age;
	private List<Address> addressList;
	private Date lastLogin;
	
	
	public User(String name, String surname, String email, String password, String job, byte age) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.job = job;
		this.age = age;
		this.addressList = new ArrayList<Address>();
		this.lastLogin = null;
	}
	
	public User() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public boolean checkUserInfo(String email, String password) {
		if(email.equals(this.email) && password.equals(this.password)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password + ", job="
				+ job + ", age=" + age + ", addressList=" + addressList + ", lastLogin=" + lastLogin + "]";
	}
}
