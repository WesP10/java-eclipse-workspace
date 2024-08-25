
public class GradeTest extends Array1DExercises{

	public static void main(String[] args) {
	//constructor for grade class
		Grade G = new Grade("src/scores.txt");
	//shows all grades
		printArray(G.getGrades());
	//prints out mean
		System.out.println("The mean of the grades is " + G.mean());
	//prints ot median
		System.out.println("The meadian of the grades is " + G.median());
	//prints mode sentence and then mode array on the same line
		System.out.print("the mode is "); printArray(G.mode());
	//prints out the variance
		System.out.println("The variance of the grades is " + G.variance());
	//prints our the standard deviation
		System.out.println("The standard deviation of the grades is " +G.standardDeviation());
	//prints histogram sentence and the the histogram array
		System.out.print("the histogram array is "); 
		printArray(G.histogram(10, 1, 100));
	}

}
