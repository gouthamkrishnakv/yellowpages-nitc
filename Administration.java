import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import com.sun.java_cup.internal.runtime.Scanner;

class Administration
{
	private final int n = 10;
	private String Name;
	private PhoneNumber[] Numbers  = new PhoneNumber[n];
//	String Notes;
	public Administration()
	{
		this.Name = "";
		for(int i=0;i<n;i++)
		{
			this.Numbers[i] = new PhoneNumber();
		}
	}
	void InputToArrayList()
	{
		
	}
	public String getName()
	{
		return this.Name;
	}
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public void getPhoneNumber()
	{
		int n = 10;
		for(int i=0;i<n;i++)
		{
			System.out.print("<Administration, Numbers> NUMBER" + i + " : ");
			this.Numbers[i].InputPhoneNumber();
		}
	}
	public ArrayList<Administration> GetAdministrationList()
	{
		ArrayList<Administration> retnArrayList = new ArrayList<Administration>();
		String filename = "Administration.txt";
		File myFile = new File(filename);
		try
		{
			Scanner fileScanner = new Scanner(myFile);
			while(fileScanner.hasNextLine())
			{
				retnArrayList.addToList(fileScanner.nextLine());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public ArrayList<Administration> addToList(ArrayList<Administration> arrayListObject, String inputString)
	{
		
	}
	
}
