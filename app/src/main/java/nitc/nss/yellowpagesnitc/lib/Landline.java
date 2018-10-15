package nitc.nss.yellowpagesnitc.lib;
class Landline {
	String AreaCode = "0495";
	String number = "1234567";
	public Landline(String phoneno)
	{
		if(phoneno.length() == 10)
		{
			this.AreaCode = "0" +  phoneno.substring(0,4);
			this.number = phoneno.substring(4,10);
		}
		else if(phoneno.length() == 11)
		{
			this.AreaCode = phoneno.substring(0,5);
			this.number = phoneno.substring(5,11);
		}
		else if(phoneno.length() == 7)
		{
			this.AreaCode = "0495";
			this.number = phoneno;
		}
		else
		{
			System.out.println("ERROR ADDING THE PHONE NO");
			//throw new Exception("WRONG LENGTH FOR PARAMETER 0 (LANDLINE CTOR)");
		}
	}
	public Landline(String AreaCode, String phoneno)
	{
		if(phoneno.length() == 7 && (AreaCode.length() == 3 || AreaCode.length() == 4))
		{
			this.number = phoneno;
			if(AreaCode.length() == 3)
				this.AreaCode = "0" + AreaCode;
			else
				this.AreaCode = AreaCode;
		}
	}
}
