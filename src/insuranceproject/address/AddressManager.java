package insuranceproject.address;

import insuranceproject.exception.InvalidAddressException;
import insuranceproject.user.User;

public class AddressManager {
	
	public static void removeAddress(User user,Address address,AddressType type) throws InvalidAddressException {
		if(type == AddressType.Home) {
			for(Address item : user.getAddressList()) {
				if(item instanceof HomeAddress) {
					user.getAddressList().remove(item);
				}
			}
		}else if(type == AddressType.Businnes) {
			for(Address item : user.getAddressList()) {
				if(item instanceof BusinessAddress) {
					user.getAddressList().remove(item);
				}
			}
		}else {
			throw new InvalidAddressException("İlgili adres bulunamadı");
		}
	}
	
	public static void addAddress(User user,Address address) {
		user.getAddressList().add(address);
	}

}
