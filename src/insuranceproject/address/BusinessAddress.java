package insuranceproject.address;

public class BusinessAddress implements Address {
	private String address;

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public void printAddress() {
		System.out.println("Job Address "+this.address);
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
		
	}

}
