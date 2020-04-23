package insuranceproject.account;

import java.util.ArrayList;
import java.util.List;

import insuranceproject.address.Address;
import insuranceproject.address.AddressManager;
import insuranceproject.address.AddressType;
import insuranceproject.exception.InvalidAddressException;
import insuranceproject.insurancetype.Insurance;
import insuranceproject.user.User;

public abstract class Account implements Comparable {
	private User user;
	private List<Insurance> insuranceList;
	private AuthenticationStatus authenticationStatus;
	
	public Account(User user,List<Insurance> insuranceList) {
		this.user = user;
		this.insuranceList = insuranceList;
		this.authenticationStatus = AuthenticationStatus.FAIL;
	}
	
	
	protected final void showUserInfo() {
		System.out.println(this.user);
	}
	
	public User getUser() {
		return this.user;
	}
	
	public List<Insurance> getInsurance(){
		return this.insuranceList;
	}
	
	public boolean checkUser(String email,String password) {
		if(user.checkUserInfo(email, password)) {
			this.authenticationStatus = AuthenticationStatus.SUCCESS;
			return true;
		}else {
			this.authenticationStatus = AuthenticationStatus.FAIL;
			return false;
		}
	}
	
	public boolean checkLogin() {
		if(this.authenticationStatus == AuthenticationStatus.SUCCESS) {
			return true;
		}else {
			return false;
		}
	}
	
	public void removeAddress(Address address,AddressType type) throws InvalidAddressException {
		AddressManager.removeAddress(user, address,type);
	}
	
	public void addAddress(Address address) {
		AddressManager.addAddress(user, address);
	}
	
	public abstract void addPolicy(int profit);
	
	public abstract void removePolicy(int profit);


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authenticationStatus == null) ? 0 : authenticationStatus.hashCode());
		result = prime * result + ((insuranceList == null) ? 0 : insuranceList.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (authenticationStatus != other.authenticationStatus)
			return false;
		if (insuranceList == null) {
			if (other.insuranceList != null)
				return false;
		} else if (!insuranceList.equals(other.insuranceList))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}
