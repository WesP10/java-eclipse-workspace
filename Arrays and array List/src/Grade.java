import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Weston
 */

public class Grade{
	//instance variable
	private double[] grades;
	//constructor we did in class
	public Grade(String filename) 
	{
		File f = new File(filename);
		try 
		{
			Scanner sc = new Scanner(f);
			int count = 0;
			while(sc.hasNextDouble()) 
			{
				count++;
				sc.nextDouble();
			}
			if(count == 0)
				throw new IllegalArgumentException("File doesn't have a double");
			grades = new double[count];
			sc = new Scanner(f);
			int i = 0;
			while(sc.hasNextDouble()) 
			{
				grades[i] = sc.nextDouble();
				i++;
			}
			Arrays.sort(grades); //min to max
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//returns the grades stored in your instance variable
	public double[] getGrades() 
	{
		double[] num = new double[grades.length];
		num = grades;
		return num;
	}
	//returns the average of all the grades
	public double mean() 
	{
		double sum = 0;
		//for loop finds sum of all grades
		for(int i = 0; i <= grades.length-1; i++) 
		{
			sum += grades[i];
		}
		//divides total by number of grades
		return sum/grades.length;
	}
	//returns the middle value
	public double median() 
	{
		//checks if there are an even number of grades
		if(grades.length%2 == 0) 
		{
			double avg = (grades[(grades.length/2)]+grades[grades.length/2-1])/2;
			return avg;
		}
		else
			return grades[grades.length/2];
	}
	//returns the most common grade
	public double[] mode() 
	{
		int numberOfModes = 0;
		double[] b = new double[grades.length];
		/*
		 * creates array full of grade frequency
		 * ex: [0, 0, 1, 2, 2] -> [2, 2, 1, 2, 2]
		 */
		for(int j = 0; j <= grades.length-1; j++)
		{
			for(int i = 0; i<= grades.length-1; i++) 
			{
				if(grades[j] == grades[i]) 
					{
						b[j]++;
					}
			}
		}

		/*
		 * returns highest frequency 
		 * ex: [[0, 0, 1, 2, 2] -> maxCount = 2
		 */
		double maxCount = 0; 

	      for (int i = 0; i <= grades.length-1; ++i) 
	      {
	         int count = 0;
	         for (int j = 0; j <= grades.length-1; ++j) {
	            if (grades[j] == grades[i])
	            ++count;
	         }

	         if (count > maxCount) {
	            maxCount = count;
	         }
	      }
	      
	      //for loop determines how many modes there are
	      for(int i = 0; i <= b.length-1; i++) 
	      {
	    	  if(i == 0 && b[i] == maxCount)
	    		  numberOfModes++;
	    	  if(b[i] == maxCount && grades[i] != grades[i-1])
	    		  numberOfModes++;
	      }
	      /*
	       * checks if frequency array(array b) values are equal to highest frequency value
	       * if the values are equal then the value is added to the array of modes
	       */
	     double[] mode = new double[numberOfModes];
	     int x = 0;
	      for(int i = 0; i <= b.length-1; i++) 
	      {
	    	  if(b[i] == maxCount && x == 0) 
	    	  {
	    		  mode[x] = grades[i];
	    		  x++;
	    	  }
	    	  if(b[i] == maxCount && grades[i] != mode[x-1]) 
	    	  {
	    		  mode[x] = grades[i];
	    		  x++;
	    	  }
	    	  		
	      }
	      
		return mode;
	}
	//returns variance
	public double variance() 
	{
		double[] var = new double[grades.length];
		double sum = 0;
		for(int i = 0; i <= grades.length-1; i++) 
		{
			var[i] = (grades[i] - this.mean())*(grades[i] - this.mean());
		}
		for(int i = 0; i <= var.length-1; i++) 
		{
			sum += var[i];
		}
		return sum/var.length;
	}
	//return square root of variance aka the standard deviation
	public double standardDeviation() 
	{
		return Math.sqrt(this.variance());
	}
	//returns how many grades are between the sizes you specify
	public int[] histogram(int sizeOfBucket, int minValue, int maxValue) 
	{
		int count = 0;
		int beenCounted = 0;
		int[] hg = new int[(maxValue+1-minValue)/sizeOfBucket];
		for(int i = 0; i <= grades.length-1; i++) 
		{
			
			do
			{
				if(grades[i] >= (count*sizeOfBucket)+minValue && grades[i] < minValue+(sizeOfBucket*(count+1))) 
				{
					hg[count]++;
					beenCounted = 1;
				}
				
				else
					count++;
			}
			while(beenCounted == 0);
			
			if(count != 0 && beenCounted != 0)
			{
			count = 0;
			beenCounted = 0;
			}
		}

		return hg;
	}
	
}
