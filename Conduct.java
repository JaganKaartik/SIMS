import java.util.*;
import java.io.*;

public class Conduct implements Serializable
{
	protected String ConductType;
	protected String SuspensionCause;
	protected int NoOfSuspensions;

	/* Constructors */

	Conduct()
	{
		this.ConductType = "VERY GOOD";
		this.SuspensionCause = null;
		this.NoOfSuspensions = 0;
	}

	Conduct(String ConductType,String SuspensionCause,int NoOfSuspensions)
	{
		this.ConductType = ConductType;
		this.SuspensionCause = SuspensionCause;
		this.NoOfSuspensions = NoOfSuspensions;
	}

	boolean IsSuspended(int NoOfSuspensions)
	{
		if(NoOfSuspensions >= 1)
			return true;
		else
			return false;
	}

	public void SetConduct(int NoOfSuspensions)
	{
		if(IsSuspended(NoOfSuspensions) == true)
		{
			ConductType = "AVERAGE";
		}
		else
		{
			ConductType = "VERY GOOD";
		}
	}

	/* Set Suspension */

	public void SetSuspension()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter SuspensionCause : ");
		SuspensionCause = sc.next();
		NoOfSuspensions = NoOfSuspensions + 1;
		SetConduct(NoOfSuspensions);
	}

	/* Conduct Deatails */

	public void ConductDetails()
	{
		System.out.println("General Conduct : "+ConductType);
		System.out.print("Suspension Details (if any) : ");
		if(NoOfSuspensions == 0)
		{
			System.out.println("No Suspensions given to this student!");
		}
		else
		{
			System.out.println(NoOfSuspensions+" Suspension(s) was given for Cause of "+SuspensionCause);
		}
	}
}