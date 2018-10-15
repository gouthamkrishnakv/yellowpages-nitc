import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
class PhoneNumber
{
	private String number;
	private String countryCode = "+91";
	public PhoneNumber()
	{
		this.number = "1234567890";
		this.countryCode = "+91";
	}
	public PhoneNumber(String number)
	{
		this.number = "1234567890";
		this.countryCode = "+91"; 
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
			// throw new Exception("WRONG SIZE");
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
	public void InputPhoneNumber()
	{
		Scanner userInput = new Scanner(System.in);
		System.out.print("<PhoneNumber> ENTER THE PHONE NUMBER:");
		PhoneNumber testNumber;
		String testString;
		if(userInput.hasNextLine())
		{
			testString = userInput.nextLine();
			testNumber = new PhoneNumber(testString);
			while(testNumber.isNumValid() == false)
			{
				System.out.print("<PhoneNumber> Wrong Number Format. Try Again:");
				if(userInput.hasNextLine())
				{
					testString = userInput.nextLine();
					testNumber = new PhoneNumber(testString);
				}
			}
		}
		else
		{
			throw new InputMismatchException("<PhoneNumber, InputPhoneNumber> PHONE NUMBER EXCEPTION");
		}
	}
}
