import java.util.*;
import java.io.*;

/* Student Details Class */

class Student extends Information implements Serializable
{
	
	String rollNumber;  //Roll Number of Student
	String name;        //Name of Student
	String Address;     //Address of type String
	String Branch;      //Branch
	String YearToFrom;  //Year from To-From
	String studentType; //Hostler or DayScholar  (H) OR (D)
	int flag = 0;  //Flag 

	Student(String r,String n,String a,String brch,String st,String ytf)
	{
		this.rollNumber = r;
		this.name = n;
		this.Address = a;
		this.Branch = brch;
		this.YearToFrom = ytf;
		this.studentType = st;
	}

	Student()
	{
		rollNumber = null;
		name = null;
		Address = null;
		YearToFrom = null;
		Branch = null;
		studentType = null;
	}

	public void setMethod(String r,String n,String a,String brch,String st,String ytf)
	{
		rollNumber = r;
		name = n;
		Address =a;
		Branch = brch;
		YearToFrom = ytf;
		studentType = st;
	}

	public String getRoll()
	{
		return rollNumber;
	}

	public void Details()  //Abstract Method Invoked from Abstract Base Class Information
	{
		System.out.println("------Student Details------");
		System.out.println("\nName            : "+name);
		System.out.println("RollNumber      : "+rollNumber);
		System.out.println("Branch          : "+Branch);
		System.out.println("Enrollment Year : "+YearToFrom);
		System.out.println("Address         : "+Address);
		System.out.println("Student Type    : "+studentType);
	}

}
