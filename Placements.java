import java.util.*;
import java.io.*;

class Placements implements Serializable
{
	protected String Company_Name;
	protected String Company_Type;
	protected String Job_Desp;
	protected double salary;

	Placements()
	{
		this.Company_Type = null;
		this.Company_Name = null;
		this.Job_Desp = null;
		this.salary = 0;	
	}

	Placements(String Company_Name,String Company_Type,String Job_Desp,float salary)
	{
		this.Company_Type = Company_Type;
		this.Company_Name = Company_Name;
		this.Job_Desp = Job_Desp;
		this.salary = salary;	
	}

	void Set_Placement_Details()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Placements Details-----\n");
		System.out.print("Enter the Company_Name : ");
		Company_Name = sc.next();
		System.out.print("Enter the Company_Type : ");
		Company_Type = sc.next();
		System.out.print("Enter the Job_Description : ");
		Job_Desp = sc.next();
		System.out.print("Enter the Salary : ");
		salary = sc.nextFloat();
	}

	void Get_Placement_Details()
	{
		System.out.println("-----Placement Details----");
		System.out.println("Company_Name : "+Company_Name);
		System.out.println("Company_Type : "+Company_Type);
		System.out.println("Job_Description : "+Job_Desp);
		System.out.println("Salary : "+salary);
	}
}