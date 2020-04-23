package insuranceproject.insurancetype;

import java.util.Date;

public abstract class Insurance {
	
	private String insuranceName;
	private double insurancePay;
	private Date insuranceStart;
	private Date insuranceEnd;
	
	public Insurance(String insuranceName, double insurancePay, Date insuranceStart, Date insuranceEnd) {
		super();
		this.insuranceName = insuranceName;
		this.insurancePay = insurancePay;
		this.insuranceStart = insuranceStart;
		this.insuranceEnd = insuranceEnd;
	}

	public abstract void calculate();

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public double getInsurancePay() {
		return insurancePay;
	}

	public void setInsurancePay(double insurancePay) {
		this.insurancePay = insurancePay;
	}

	public Date getInsuranceStart() {
		return insuranceStart;
	}

	public void setInsuranceStart(Date insuranceStart) {
		this.insuranceStart = insuranceStart;
	}

	public Date getInsuranceEnd() {
		return insuranceEnd;
	}

	public void setInsuranceEnd(Date insuranceEnd) {
		this.insuranceEnd = insuranceEnd;
	}
	
	
}
