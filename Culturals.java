import java.util.*;
import java.io.*;

public class Culturals extends Event_Participation implements Serializable 
{
	public String Gift;
	public String CulEvent_Name;
	public String Cul_Type;

	Culturals()
	{
		Gift = null;
		Cul_Type = null;
		CulEvent_Name = null;
	}
	Culturals(String Gift,String CulEvent_Name,String Cul_Type)
	{
		this.Gift = Gift;
		this.Cul_Type = Cul_Type;
		this.CulEvent_Name = CulEvent_Name;
	}
	public void Add_Details()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Cultural Event Name : ");
		CulEvent_Name = sc.next();
		System.out.println("Enter The Cultural Event Type: ");
		Cul_Type = sc.next();
		System.out.println("Enter The Gift Received : ");
		Gift = sc.next();
	}
	public void Get_Details()
	{
		System.out.println("Cultural Event Name : "+CulEvent_Name);
		System.out.println("Cultural Event Type : "+Cul_Type);
		System.out.println("Gift Received       : "+Gift);
	}
}