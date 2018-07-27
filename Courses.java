import java.util.*;
import java.io.*;

class Courses implements Serializable,interfaceCourse
{
	public float NoOfDaysPresent = 0;
	public float TotalDays = 50;
	public float[] AttendancePerc = new float[10]; 
	public float ap = 0;
	public String[] courses  = new String[10];
	public int n = 0;

	public void CourseAttended()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Courses! ");
		n = sc.nextInt();
		for(int i=1;i<=n;++i)
		{
			System.out.print("Enter Course Name "+i+" : ");
			courses[i] = sc.next();
			System.out.println("Enter the number of Days Present during "+courses[i]+" : ");
				NoOfDaysPresent = sc.nextInt();
				ap = (NoOfDaysPresent/TotalDays)*100;
			AttendancePerc[i] = ap;
		}
	}

	public void CourseDetails()
	{
		for(int i=1;i<=n;++i)
		{
			System.out.println(courses[i]+" course.\n Attendance in Percentage is "+AttendancePerc[i]+" percent");
		}
	}
}