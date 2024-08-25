
/**
 * A maze class. Randomly generates a maze with a certain dimensions. Can generate
 * a random start and goal square for path finding.
 * @author SharickE
 *
 */
public class Maze {
	final static int OPEN = 0;
	final static int VISITED = 1;
	final static int WALL = 2;
	final static int GOAL = 3;
	private int[][] grid;
	private int goalRow, goalCol;
	
	public int[][] getGrid() {
		return grid;
	}

	
	/**
	 * Generates a new random maze. This constructor does not set a goal or start square.
	 * After this constructor finishes, each square in the grid is either OPEN or WALL.
	 * @param numRows 
	 * @param numCols
	 * @param wallFactor - the probability a square is a wall
	 */
	public Maze(int numRows, int numCols, double wallFactor) {
		grid = new int[numRows][numCols];
		for(int r = 0; r < numRows; r++)
			for(int c = 0; c < numCols; c++)
			{
				boolean isWall = Math.random() < wallFactor;
				grid[r][c] = isWall ? WALL : OPEN;
			}
	}
	
	/**
	 * Change all visited nodes back to open. This method does not change the goal square.
	 */
	public void resetGrid() {
		for(int r = 0; r < grid.length; r++)
			for(int c = 0; c < grid[r].length; c++)
				if(grid[r][c] == VISITED)
					grid[r][c] = OPEN;
	}
	
	/**
	 * Sets a new random goal square. The goal square will not be a wall, but may be enclosed within 4 walls.
	 */
	public void setGoalSquare() {
		if(grid[goalRow][goalCol] == GOAL)
			grid[goalRow][goalCol] = OPEN;
		do {
			goalRow = (int)(Math.random()*grid.length);
			goalCol = (int)(Math.random()*grid[0].length);
		}while(grid[goalRow][goalCol] != OPEN);
		grid[goalRow][goalCol] = GOAL;
	}
	
	/**
	 * Gets a new random start square that is not a wall or the goal.
	 * @return - the Position of the square that is not a wall or the goal.
	 */
	public Position getStartSquare() {
		int startRow, startCol;
		do {
			startRow = (int)(Math.random()*grid.length);
			startCol = (int)(Math.random()*grid[0].length);
		}while(grid[startRow][startCol] != OPEN);
		return new Position(startRow, startCol);
	}
	
}
