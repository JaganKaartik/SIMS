import java.util.*;
import java.io.*;

public class OtherEvents extends Event_Participation implements Serializable
{
	public String Price;
	public String Event_Name;
	public String Type;

	OtherEvents()
	{
		Price = null;
		Type = null;
		Event_Name = null;
	}
	OtherEvents(String Price,String Event_Name,String Type)
	{
		this.Price = Price;
		this.Type = Type;
		this.Event_Name = Event_Name;
	}
	public void Add_Details()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Event Name : ");
		Event_Name = sc.next();
		System.out.println("Enter The Event Type: ");
		Type = sc.next();
		System.out.println("Enter The Price Received : ");
		Price = sc.next();
	}
	public void Get_Details()
	{
		System.out.println("Event Name    : "+Event_Name);
		System.out.println("Event Type    : "+Type);
		System.out.println("Gift Received : "+Price);
	}
}
