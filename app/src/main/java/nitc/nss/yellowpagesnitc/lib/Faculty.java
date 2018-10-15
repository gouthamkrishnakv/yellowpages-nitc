public class Faculty
{
	String name = "NONAME";
	String emailid = "noname@example.com";
	String title = "NOTITLE";
	Landline officeph;
	String roomno;
//	String adddress = "NOADDRESS";
//	String personalph = "";
	public Faculty(Faculty newfaculty)
	{
		this.name = newfaculty.name;
		this.emailid = newfaculty.emailid;
		this.title = newfaculty.title;
		this.officeph = newfaculty.officeph;
		this.roomno = newfaculty.roomno;
	}
	public Faculty(String newname, String newemailid, String newtitle, Landline officeph, String newroomno)
	{
		this.name = newname;
		this.emailid = newemailid;
		this.title = newtitle;
		this.officeph = officeph;
		this.roomno = newroomno;
	}
	public Faculty(String newname, String newemailid, String newtitle, String officeph, String newroomno)
	{
		this.name = newname;
		this.emailid = newemailid;
		this.title = newtitle;
		this.officeph = new Landline(officeph);
		this.roomno = newroomno;
	}

	public static void main(String args[])
	{
		System.out.println("SUCCESFUL COMPILATION");
	}
}
