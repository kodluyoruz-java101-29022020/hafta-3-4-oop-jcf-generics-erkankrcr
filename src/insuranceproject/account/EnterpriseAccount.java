package insuranceproject.account;

import java.util.List;

import insuranceproject.insurancetype.Insurance;
import insuranceproject.user.User;

public class EnterpriseAccount extends Account {

	public EnterpriseAccount(User user, List<Insurance> insuranceList) {
		super(user, insuranceList);
	}

	@Override
	public int compareTo(Object o) {
		if(this.hashCode() == o.hashCode()) {
			return 0;
		}else if(this.hashCode() < o.hashCode()) {
			return -1;
		}else if(this.hashCode() > o.hashCode()) {
			return 1;
		}else {
			return -2;
		}
	}

	@Override
	public void addPolicy(int profit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePolicy(int profit) {
		// TODO Auto-generated method stub
		
	}

}
