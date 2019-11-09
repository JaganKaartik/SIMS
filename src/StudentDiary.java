/* 

					Student Diary Project 

					Creator's Name: Jagan Kaartik
					RollNo: AM.EN.U4CSE16029

*/


import java.util.*;
import java.io.*;


class StudentDiary
{
		

	public static void main(String[] args)
	{
		/* Objects Declared*/

		/* Scanner object */

		Scanner sc = new Scanner(System.in);
		StudentDiary clr = new StudentDiary();

		/*Association of other classes*/

		Student[] s = new Student[30]; 
		StudentHistory sh = new StudentHistory();
		Placements p = new Placements();
		Courses cor = new Courses();
		Results re = new Results();
		Student num = new Student();
		Conduct cndt = new Conduct();

		/* Event Objects */


		Culturals cul = new Culturals();
		OtherEvents othr = new OtherEvents();
		TechFest tf = new TechFest();

		Culturals cul_temp = new Culturals();
		OtherEvents othr_temp = new OtherEvents();
		TechFest tf_temp = new TechFest();


		/*Initilization of Objects*/


		for(int i=0;i<30;++i)
		{
			s[i] = new Student();
		}

		/* The File RollNumbers.txt for adding the RollNumbers */

		File frs = new File("RollNumbers.txt");

	
		/*Basic Menu*/

		
		System.out.println("------Main Menu------\n\n1.AddStudent(s)\n2.StudentDiaryOfStudent(Search)\n3.ToDisplayAllStudents");
		System.out.print("Enter your choice : ");
		int option = sc.nextInt();


		/* Fin is used to add " " to end of roll number so as for further iteration */


		String fin = " ";


		/* Main Menu Options */


		if(option == 1)
		{
				System.out.print("Enter no of Students : ");
				int n = sc.nextInt();


				/* Iterating for N number of students */


				for(int i=1;i<=n;++i)   //Begining of the for loop
				{
					
					System.out.println("Enter Basic Details for Student "+i+" : ");
					System.out.print("\nName : ");
					String nm = sc.next();
					System.out.print("RollNumber  : ");
					String r = sc.next();	
					System.out.print("Branch : ");
					String brch = sc.next();
					System.out.print("Address : ");
					String a = sc.next();
					System.out.print("Enrollment Year : ");
					String ytf = sc.next();
					System.out.print("StudentType : ");
					String st = sc.next();


					/*Student History */

					sh.setDetails();

					/*Adding RollNo to our File that stores RollNumbers */

					try
					{
						FileWriter fs = new FileWriter(frs,true);  //We are appending to our existing file
						fs.write(r);
						fs.write(fin);
						fs.close(); //Closing the File (After Adding all the RollNumbers to the text)
					}
					catch (FileNotFoundException fnfe)
					{
						System.out.println("File Not Found");
					}
					catch(IOException ioe)
					{
						System.out.println("Corrupt File");
					}


					/*Set Method for Adding Student Details */


					s[i].setMethod(r,nm,a,brch,st,ytf);


					/*Adding the other Necessary Details such as Placements and Results */

				
					p.Set_Placement_Details();
					re.setResults();
					cor.CourseAttended();
					

					/*Conduct Entry*/


					System.out.print("Do u want to add a suspension record ? (1 for yes) : ");
					int o = sc.nextInt();
					
						if(o==1)
						{
							cndt.SetSuspension(); //Setting Suspension Record (o(1))
						}


					/* Event Participation */


					System.out.print("Want to add Event Participation Record ? (1 for yes) : ");
					o = sc.nextInt();


					if(o==1)
					{
						/* Event Participation Sub Menu  */

						System.out.println("--------Event Participation Menu-------- \n1.TechFest\n2.Culturals\n3.OtherEvents");
						System.out.print("Enter Your Choice : ");
						int optSub = sc.nextInt();

						/*Variable optSub is the choice variable */

						/* Polymorphism is being implemented here */

						if(optSub==1)
						{
							s[i].flag = optSub;
							tf.Add_Details();
						}
						else if(optSub==2)
						{	
							s[i].flag = optSub;
							cul.Add_Details();
							
						}
						else if(optSub==3)
						{	
							s[i].flag = optSub;
							othr.Add_Details();
						}
						else
						{
							//NIL
						}

					}
					else
					{
						//NIL Wont add event participation 
					}




					try
					{
						/*Adding Objects to File */

						File f = new File(r);
						FileOutputStream fis = new FileOutputStream(f); 
						ObjectOutputStream oos = new ObjectOutputStream(fis); 

						/* Writing Objects to File */

						oos.writeObject(s[i]);    //Student

						oos.writeObject(sh);	  //Student History

						oos.writeObject(p);       //Placement

						oos.writeObject(re);      //Result

						oos.writeObject(cor);     //Course
						
						oos.writeObject(cndt);    //Conduct
						

						if(s[i].flag==1)
						{
							oos.writeObject(tf);    //If Option was Tech Fest then it writes to file
						}
						else if(s[i].flag==2)
						{
							oos.writeObject(cul);   //If Option was Cultural Fest then it writes to file
						}
						else if(s[i].flag==3)
						{
							oos.writeObject(othr);  //If Option was Other Fest then it writes to file
						}

							oos.close();
							fis.close();

			    	}
			    	catch(FileNotFoundException fnfe)
			    	{
			    			System.out.println(fnfe);
			    	}
			    	catch(IOException ioe)
			    	{
			    			System.out.println(ioe);
			   		}

				}// end of the for loop

				
		}//End of Option 1
		else if(option == 2)
		{		

			    
				/* Code to Clear the Screen in Java Equivalent to clrscr in C++ */

				System.out.print("\033[H\033[2J");
				System.out.flush();

			    char ans = 'y';  //DO loop variable

			    do{
					System.out.print("Enter the RollNumber to display details! : ");  //Rollno == FileName
					String ro = sc.next();
					File f = new File(ro);
					try
					{
						FileInputStream fis = new FileInputStream(f); 
						ObjectInputStream oos = new ObjectInputStream(fis);

						/* Reading Objects */

		      	 		num   = (Student) oos.readObject();

		      	 		sh    = (StudentHistory) oos.readObject();

		      	 		p     = (Placements) oos.readObject();

		      	 		re    = (Results) oos.readObject();

		      	 		cor   = (Courses) oos.readObject();

		      	 		cndt  = (Conduct) oos.readObject();



		      	 		/* Begining of Do Loop */

		      	 		do{
				      	 		
		      	 				
		      	 				/* Clearning Screen */

		      	 				System.out.print("\033[H\033[2J");
								System.out.flush();

				      	 		System.out.println("Student Diary of "+num.name);
				      	 		System.out.println("1.StudentInformation\n2.AttendanceInfo\n3.EventsParticipated\n4.Results");
				      	 		System.out.println("5.PlacementDetails\n6.ConductInfo");
				      	 		System.out.print("Enter your Choice : ");
				      	 		int opt = sc.nextInt();

				      	 		/* Selecting and Displaying Relevant Information based on Choice given */

				      	 		if(opt==1) //StudentInformation
				      	 		{
				      	 			char answer = 'y';
				      	 			do{
						      	 			
				      	 					System.out.print("\033[H\033[2J");
											System.out.flush();

						      	 			System.out.println("-----------Student Information of "+num.name+"-----------");
						      	 			System.out.println("1.Personal_Information\n2.Student History");
						      	 			System.out.print("Enter your Choice : ");
						      	 			int option_temp = sc.nextInt();

						      	 			System.out.print("\033[H\033[2J");
											System.out.flush();

						      	 			if(option_temp == 1)
						      	 			{
						      	 				num.Details();
						      	 			}
						      	 			else if(option_temp == 2)
						      	 			{
						      	 				sh.Details();
						      	 			}
						      	 			 System.out.print("Want to continue? (Student Information)  : ");
				      						 answer = sc.next().charAt(0);					      	 									   
						      	 		}while(answer == 'y');
				      	 		}
				      	 		else if(opt==2) //AttendanceInformation
				      	 		{
				      	 			
				      	 			System.out.print("\033[H\033[2J");
									System.out.flush();

				      	 			cor.CourseDetails();
				      	 		}
				      	 		else if(opt==3) //EventsParticipated
				      	 		{
								      	
				      	 				System.out.print("\033[H\033[2J");
										System.out.flush();



								      	if(num.flag==1)
										{
											tf_temp  = (TechFest) oos.readObject();
											tf_temp.Get_Details();
										}
										else if(num.flag==2)
										{		
											cul_temp   = (Culturals) oos.readObject();
											cul_temp.Get_Details();
										}
										else if(num.flag==3)
										{	
											othr_temp  = (OtherEvents) oos.readObject();
											othr_temp.Get_Details();
										}
				      	 		}
				      	 		else if(opt==4) //OutputResults
				      	 		{
				      	 			System.out.print("\033[H\033[2J");
									System.out.flush();

				      	 			re.getResults();
				      	 		}
				      	 		else if(opt==5) //Placement Details
				      	 		{
				      	 			System.out.print("\033[H\033[2J");
									System.out.flush();

				      	 			p.Get_Placement_Details();
				      	 		}
				      	 		else if(opt==6) //Conduct Info
				      	 		{
				      	 			System.out.print("\033[H\033[2J");
									System.out.flush();

				      	 			cndt.ConductDetails();
				      	 		}
				      	 		else
				      	 		{
				      	 			System.out.print("\033[H\033[2J");
									System.out.flush();

				      	 			System.out.print("Wrong Choice!");
				      	 		}

				      	 System.out.print("Want to continue? (Student Diary)  : ");
				      	 ans = sc.next().charAt(0);
				      	 }while(ans=='y');

						oos.close();
						fis.close();
			    	}
			    	catch(FileNotFoundException fnfe)
			    	{
			    			System.out.println(fnfe);
			    	}
			    	catch(IOException ioe)
			    	{
			    			System.out.println(ioe);
			   		}
			   		catch(ClassNotFoundException clse)
			    	{
			    			System.out.println(clse);
			    	}


			    	System.out.print("Do u want to continue (Searching Menu (Roll Numbers))? :  ");
			    	ans = sc.next().charAt(0);
				}while(ans == 'y');

		}//End of Option 2
		else if(option == 3)
		{	
			/* Read From File RollNumbers.txt */

			System.out.print("\033[H\033[2J");
			System.out.flush();

			String line;
			String[] roll =new String[100];

			try
			{
				BufferedReader br = new BufferedReader(new FileReader("RollNumbers.txt"));

				/* Storing Roll Numbers into RollNos Array */

	            while((line=br.readLine())!=null)
	            {
	                roll = line.split(" ");
	            }

			}
			catch(FileNotFoundException e)
			{
				System.out.println(e);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}

            /* To Iterate Among RollNos to display details of n students */

    		int i;

            for(i=0;i<roll.length;++i) 
            {
					
            		String resNew = roll[i];

					File f = new File(resNew);

					try
					{
						
						FileInputStream fis = new FileInputStream(f); 
						ObjectInputStream oos = new ObjectInputStream(fis);

						/* Reading Objects */

		      	 		num   = (Student) oos.readObject();

		      	 		/* Printing them */ 

		      	 		num.Details();

		      	 	}
		      	 	catch(FileNotFoundException fnfe)
			    	{
			    			System.out.println(fnfe);
			    	}
			    	catch(IOException ioe)
			    	{
			    			System.out.println(ioe);
			   		}
			   		catch(ClassNotFoundException clse)
			    	{
			    			System.out.println(clse);
			    	}

            } //End of Iteration 

			
		}//End of Option 3
		else
		{
			System.out.println("Wrong Option!");
		}

	}
}
