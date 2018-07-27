import java.util.*;
import java.io.*;

public class TechFest extends Event_Participation implements Serializable 
{
	public String Participation;
	public String Event;

	TechFest()
	{
		Participation = null;
		Event = null;
	}
	TechFest(String Participation,String Event)
	{
		this.Participation = Participation;
		this.Event = Event;
	}
	public void Add_Details()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Event : ");
		Event = sc.next();
		System.out.println("If Participated (Y/N) : ");
		Participation = sc.next();
	}
	public void Get_Details()
	{
		System.out.println("Event         : "+Event);
		System.out.println("Participation : "+Participation);
	}
}