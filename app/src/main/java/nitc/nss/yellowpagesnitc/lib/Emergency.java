package nitc.nss.yellowpagesnitc.lib;
class Emergency
{
	int n = 10;
	String Name;
	PhoneNumber[] Numbers = new PhoneNumber[n];
	public Emergency()
	{
		this.Name = "";
		for(int i=0;i<n;i++)
			this.Numbers[i] = new PhoneNumber();
	}
	public Emergency(String Name)
	{
		this.Name = Name;
		for(int i=0;i<10;i++)
			this.Numbers[i] = new PhoneNumber();
	}
	public boolean AddANumber(PhoneNumber newnum)
	{
		int i=0;
		while(!this.Numbers[i].isNumValid()&&i<10)
		{
			i++;
		}
		if(i<10)
		{
			this.Numbers[i] = newnum;
			return true;
		}
		else
			return false;
	}
}
