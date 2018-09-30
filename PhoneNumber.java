class PhoneNumber
{
	private String number;
	private String countryCode = "+91";
	public PhoneNumber()
	{
		this.number = "!234567890";
		this.countryCode = "+91";
	}
	public PhoneNumber(String number)
	{
		if(number.length()==10)
		{
			this.number = number;
		}
		else if(number.length() == 12)
		{
			this.number = number.substring(0,10);
			this.countryCode = '+' + number.substring(10,12);
		}
		else if(number.length()==13)
		{
			this.number = number.substring(0,10);
			this.countryCode = number.substring(10,13);
		}
		else
		{
			System.out.println("WRONG SIZE");
		}

	}
	public boolean isNumValid()
	{
		if(this.number == new PhoneNumber().number)
			return false;
		return true;
	}
	public String ToString()
	{
		return this.countryCode + this.number;
	}
	public void NumPrint()
	{
		System.out.println(this.ToString());
	}
}
