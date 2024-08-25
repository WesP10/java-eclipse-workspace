import java.util.ArrayList;

import processing.core.PApplet;

public class MazeRunner extends PApplet{

	public static void main(String[] args) {
		PApplet.main("MazeRunner");
	}
	
	public void settings() {
		size(600, 600);
	}
	
	int numRows = 8; //adjust for testing purposes
	int numCols = 8; //adjust for testing purposes
	double wallFactor = 0.25; //adjust for testing purposes
	int blockWidth, blockHeight;
	Position start;
	Maze maze;
	MazeSolver mazeSolver;
	public void setup() {
		blockWidth = width/numCols;
		blockHeight = height/numRows;
		maze = new Maze(numRows, numCols, wallFactor);
		mazeSolver = new MazeSolver(maze);
		resetMaze(1); //reset the maze and get a new goal and start square
	}
	
	/**
	 * Reset the maze.
	 * @param method - 0 - keep the same goal and start, 1 - change to a new goal and start
	 */
	public void resetMaze(int method) {
		maze.resetGrid();
		if(method == 1)
		{		
			maze.setGoalSquare();
			start = maze.getStartSquare();
		}
		drawMaze();
	}
	
	/**
	 * Solve the maze using the findPath algorithm.
	 * @param method - 0 for DFS, 1 for BFS
	 */
	public void solve(int method) {
		ArrayList<Position> solution;
		solution = mazeSolver.findPath(start, method);
		drawMaze();
		drawSolution(solution);
	}
	
	public void draw() {
		
	}
	
	int clickCount = 0;
	/**
	 * The first click solves DFS. The second click solves BFS. The third click resets the maze
	 * and gets a new goal and start.
	 */
	public void mousePressed() {
		if(clickCount % 3 == 0)
			solve(0);
		else if(clickCount % 3 == 1)
		{
			resetMaze(0);
			solve(1);
		}else 
			resetMaze(1);
		
		clickCount++;
	}
	
	/**
	 * Draw the path of the solution in yellow with numbers indicating the direction of the path.
	 * @param solution
	 */
	public void drawSolution(ArrayList<Position> solution) {
		int i = 0;
		for(Position p : solution) {
			if(i==0)
				fill(255, 0, 0);
			else if (i == solution.size()-1)
				fill(0, 255, 0);
			else
				fill(220, 180, 20);
			rect(p.getCol()*blockWidth, p.getRow()*blockHeight, blockWidth, blockHeight);
			fill(0);
			text("" + i, p.getCol()*blockWidth, (p.getRow()+1)*blockHeight);
			i++;
		}
	}

	/**
	 * Draw the maze. Start is red, Goal is green, Wall is black, Open is white, Visited is blue.
	 */
	public void drawMaze() {
		int[][] grid = maze.getGrid();
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[r].length; c++)
			{
				if(r == start.getRow() && c == start.getCol())
					fill(255, 0, 0);
				else if (grid[r][c] == Maze.GOAL)
					fill(0, 255, 0);
				else if(grid[r][c] == Maze.WALL)
					fill(0);
				else if(grid[r][c] == Maze.VISITED)
					fill(0, 0, 255);
				else
					fill(255);
				rect(c*blockWidth, r*blockHeight, blockWidth, blockHeight);
			}
		}
	}
	
	
}
