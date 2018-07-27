import java.util.*;
import java.io.*;


class Results implements Serializable
{
	
	/* Data types for Results Class */

	public float[] cgpa = new float[10];
	public String[] arrears = new String[10];
	public int noOfArrears = 0;
	public float avg = 0;
	public float max = 0;
	public float min = 0;
	public int SemesterHighest = 0;
	public int SemesterLowest = 0;

	/*Function for Setting Details */

	public void setResults()  
	{
		float total = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("-----Results and Arrears-----");

		for(int i=1;i<=8;++i)
		{
			System.out.print("Enter CGPA of Semester "+i+" : ");
			cgpa[i] = sc.nextFloat();
			total = total + cgpa[i];
		}

		avg = (total/8);  //Calculating the average CGPA

		max = cgpa[0];

		for(int i=1;i<=8;++i)
		{
			if(cgpa[i]>max)
			{
				max = cgpa[i];
				SemesterHighest = i;
			}
		}


		min = cgpa[8]; //Setting the minimum value as maximum then in the later traversal we'll get the answer


		for(int i=1;i<=8;++i)
		{
			if(cgpa[i] < min)
			{
				min = cgpa[i];
				SemesterLowest = i;
			}
		}


		System.out.print("Enter no of Arrears (if any) : ");
		noOfArrears = sc.nextInt();


		if(noOfArrears >= 1) //Enter into Arrear String Array if Arrears Present
		{
			for(int i=0;i<noOfArrears;++i)
			{
				arrears[i] = sc.next();
			}
		}
		else
		{
			//nil no arrears
		}

	}


	/* Function for Getting Results */


	public void getResults()
	{
			
		/* Get CGPA Resuts */

		System.out.println("---------RESULTS---------\n");

		System.out.println("------CGPA Details------ ");

		for(int i=1;i<=8;++i)
		{
			System.out.println("CGPA for Semester : "+i+" is "+cgpa[i]);
		}

		System.out.println("\n------Arrear Details-----");

		/* Display Arrear Details if any */

		if(noOfArrears >= 1)
		{
			for(int i=0;i<noOfArrears;++i)
			{
				System.out.println(arrears[i]);
			}
		}
		else
		{
			System.out.println("NIL, This student has no Arrears!");
		}

		System.out.println("\n-----RESULT STATICTICS------");
		System.out.println("Highest CGPA achieved is : "+max+" during Semester "+SemesterHighest);
		System.out.println("Lowest CGPA achieved is : "+min+" during Semester "+SemesterLowest);
		System.out.println("Average CGPA is : "+avg);
	}
}