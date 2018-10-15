package nitc.nss.yellowpagesnitc.lib;

class PhoneNumber
{
	private String number;
	private String countryCode;

	public static PhoneNumber try_construct(String number) {
		if(number.length()==10)
		{
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.number = number;
			phoneNumber.countryCode = "+91";
			return phoneNumber;
		}
		else if(number.length() == 12)
		{
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.number = number.substring(0,10);
			phoneNumber.countryCode = '+' + number.substring(10,12);
			return phoneNumber;
		}
		else if(number.length()==13)
		{
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.number = number.substring(0,10);
			phoneNumber.countryCode = number.substring(10,13);
			return phoneNumber;
		} else {
			return null;
		}
	}
}
