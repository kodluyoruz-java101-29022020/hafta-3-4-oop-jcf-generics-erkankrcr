package insuranceproject.insurancetype;

import java.util.Date;

public class HealthInsurance extends Insurance {

	public HealthInsurance(String insuranceName, double insurancePay, Date insuranceStart, Date insuranceEnd) {
		super(insuranceName, insurancePay, insuranceStart, insuranceEnd);
	}

	@Override
	public void calculate() {
		
	}

}
