class Landline {
	String areaCode = "0495";
	String number = "1234567";
	public Landline(String phoneno)
	{
		if(phoneno.length() == 10)
		{
			this.areaCode = "0" +  phoneno.substring(0,4);
			this.number = phoneno.substring(4,10);
		}
		else if(phoneno.length() == 11)
		{
			this.areaCode = phoneno.substring(0,5);
			this.number = phoneno.substring(5,11);
		}
		else if(phoneno.length() == 7)
		{
			this.areaCode = "0495";
			this.number = phoneno;
		}
		else
		{
			System.out.println("ERROR ADDING THE PHONE NO");
		}
	}
	public Landline(String areaCode, String phoneno)
	{
		if(phoneno.length() == 7 && (areaCode.length() == 3 || areaCode.length() == 4))
		{
			this.number = phoneno;
			if(areaCode.length() == 3)
				this.areaCode = "0" + areaCode;
			else
				this.areaCode = areaCode;
		}
	}
}
