import java.util.Scanner;
public class GradeBook {

	private String courseName;	//course name represented by mark
	private int[][] grades;		//2d array with students's marks
	
	//a constructor of 2 arguments initializes courseName & grades
	public GradeBook( String name, int[][] gradesArray )
	{
		courseName = name;		//initializing courseName
		grades=gradesArray;		//saving grades
	}
	
	
	//a method to set the course name
	public void setCourseName( String name )
	{
		courseName = name;	//saving course's name
	}
	
	
	//course name recall method
	public String getCourseName()
	{
		return courseName;
	}
	
	
	//displays a welcome message
	public void displayMessage()
	{
		System.out.printf( "Welcome to the grade book for\n%s\n", getCourseName() );
	}

	
	//making some processing to data
	public void processGrades()
	{
		outputGrades();
		
		System.out.printf("\n%s %d\n%s %d\n\n","Lowest grade in the grade" +
			"book is",getMinimum(),"Highest grade in the grade book is",getMaximum());
		
		outputBarChart();
	}
	
	
	//finding minimum grade
	public int getMinimum()
	{
		int lowGrade=grades[0][0];
		
		//iteration loop to array's rows
		for(int[] studentGrades : grades)
		{
			//iteration loop to current row's columns
			for(int grade : studentGrades)
			{
				if(grade<lowGrade)
				{
					lowGrade=grade;
				}
			}
		}
		
		return lowGrade;
	}

	
	//finding maximum grade
	public int getMaximum()
	{
		int highGrade=grades[0][0];
		
		//iteration loop to grades's rows
		for(int[] studentGrades : grades)
		{
			//iteration loop to current's row's columns
			for(int grade : studentGrades)
			{
				if(grade>highGrade)
				{
					highGrade=grade;
				}
			}
			
		}
		return highGrade;
	}
	
	//------------------------------------------------------------------------
	//------------------------------------------------------------------------
	public double getAverage(int[] setOfGrades)
	{
		int total=0;
		
		for(int grade:setOfGrades)
			total+=grade;
		
		return (double) total/setOfGrades.length;
	}

	
	//-------------------------------------------------------------------------
	public void outputBarChart()
	{
		System.out.println("Grade distribution:");
		
		int[] frequency=new int[11];
		
		//for each GradeBook's grade, increases the frequency
		for(int[] studentGrades:grades)
		{
			for(int grade:studentGrades)
			++frequency[grade/10];
		}
		
		for(int count=0;count<frequency.length;count++)
		{
			if(count==10)
			{
				System.out.printf("%5d: ", 100);
			}
			else
			{
				System.out.printf("%02d-%02d: ",count*10,count*10+9);
			}
			
			for(int stars=0;stars<frequency[count];stars++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	//----------------------------------------------------------------------------------	
	public void outputGrades()
		{
			System.out.println("The grades are:\n");
			System.out.print( "             " ); //stoixizei tiw epikefalides grammwn
			
			//creates a column header for each test
			for(int test=0;test<grades[0].length;test++)
			{
				System.out.printf("Test %d ",test+1);
			}
			System.out.println("Average");
			
			//creating rows/columns with text depending on grades array
			for(int student=0;student<grades.length;student++)
			{
				System.out.printf("Student %2d", student+1);
				for(int test : grades[student])
				{
					System.out.printf("%8d", test);	//printing student's grades
				}
				
				//calling method getAverage to determine the average grade
				//passes grades's row as an argument to getAverage method
				double average=getAverage(grades[student]);
				System.out.printf("%9.2f\n",average);
			}
		}
	
}




