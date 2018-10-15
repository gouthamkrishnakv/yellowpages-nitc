package nitc.nss.yellowpagesnitc.lib;
public class Faculty
{
	String name = "NONAME";
	String emailid = "noname@example.com";
	String title = "NOTITLE";
	Landline officeph;
	String roomno;
//	String adddress = "NOADDRESS";
//	String personalph = "";
//	GETTERS AND SETTERS
//	GETTERS
	public String getName() {
		return name;
	}

	public String getEmailid() {
		return emailid;
	}

	public String getTitle() {
		return title;
	}

	public Landline getOfficeph() {
		return officeph;
	}

	public String getRoomno() {
		return roomno;
	}
//	SETTERS
	public void setName(String Name)
	{
		this.name = name;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOfficeph(Landline officeph) {
		this.officeph = officeph;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
//	CONSTRUCTORS
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
