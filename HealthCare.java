class HealthCare
{
	private String Name;
	private PhoneNumber Number;
	private String Timing;
	// THE TIMING METHOD AND THE TIMINGS SHOULD KEEP A CONSISTENT SYNTAX ACROSS EVERYTHING.
	public String getName()
	{
		return this.Name;
	}
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public PhoneNumber getNumber()
	{
		return this.Number;
	}
	public void SetNumber(PhoneNumber Number)
	{
		this.Number = Number;
	}
	public void SetNumber()
	{
		this.Number.InputPhoneNumber();
	}
	public String GetTiming()
	{
		return this.Timing;
	}
	public void SetTiming(String Timing)
	{
		this.Timing  = Timing;
	}
	public HealthCare() {
		//	super();
		Scanner userInput = new Scanner(System.in);
		System.out.Print("<HEALTHCARE> Enter the Name : ");
		if(userInput.hasNextLine())
			this.setName(userInput.NextLine());
		else
			throw new InputMismatchException("<HealthCare, Name>");
		this.SetNumber();
		System.out.print("<HEALTHCARE> Enter the timings (For newlines, use \\n escape sequence):");
		if(userInput.hasNextLine())
			this.SetTiming(userInput.NextLine());
		else
			throw new InputMismatchException("<HealthCare, Timing>");
	}
}
