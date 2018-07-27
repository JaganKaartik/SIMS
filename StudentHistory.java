import java.util.*;
import java.io.*;

class StudentHistory extends Information implements Serializable
{
	public String Standard10thPerc;
	public String Standard12thPerc;
	public String SyllabusFollowed;
	public String Entrance_Rank;

	StudentHistory()
	{	
		this.Standard10thPerc = null;
		this.Standard12thPerc =null;
		this.SyllabusFollowed = null;
		this.Entrance_Rank = null;
	}

	public void setDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("-------Result History------");
		System.out.print("\nEnter Matriculation Percentage : ");
		Standard10thPerc = sc.next();
		System.out.print("Enter 12th STD Percentage : ");
		Standard12thPerc = sc.next();
		System.out.print("Enter SyllabusFollowed : ");
		SyllabusFollowed = sc.next();
		System.out.print("Enter Entrance_Rank : ");
		Entrance_Rank = sc.next();
	}

	public void Details()
	{
		System.out.println("----------STUDENT HISTORY----------");
		System.out.println("\nMatriculation Percentage : "+Standard10thPerc);
		System.out.println("12th STD Percentage      : "+Standard12thPerc);
		System.out.println("SyllabusFollowed         : "+SyllabusFollowed);
		System.out.println("Entrance_Rank Obtained   : "+Entrance_Rank);
	}

}