package insuranceproject.address;

public class HomeAddress implements Address {
	private String address;
	
	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public void printAddress() {
		System.out.println("Home Address : "+this.address);
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

}
