package nitc.nss.yellowpagesnitc.lib;
import java.io.File;
import java.lang.Exception;
import java.util.LinkedList;

class Facility
{
	private final int n = 5;
	String Name;
	PhoneNumber[] Numbers = new PhoneNumber[n];
	String Description;
	String OpeningTime;
	String ClosingTime;
	String LocationDescription;
	// CONSTRUCTOR FOR THE FOLLOWING CLASSES
	public Facility()
	{
		this.Name = "";
		for(int i=0;i<n;i++)
		{
			this.Numbers[i] = new PhoneNumber();
		}
		this.Description = "";
		this.OpeningTime = "";
		this.ClosingTime = "";
		this.LocationDescription = "";
	}
	public LinkedList<Facility> getFacilityList(String filename)
	{
		LinkedList<Facility> LinkedLObj = new LinkedList<Facility>();
		return LinkedLObj;
	}
}
