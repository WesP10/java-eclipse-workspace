import java.util.ArrayList;

/**
 * A maze solver class. Given a Maze, determine a path from start to goal via a
 * DFS or a BFS.
 * 
 * @author Weston
 *
 */
public class MazeSolver {

	private int[][] grid;
	final static int DFS_MODE = 0;
	final static int BFS_MODE = 1;

	/**
	 * Takes a maze and sets the grid field to the maze of the grid.
	 * 
	 * @param m
	 */
	public MazeSolver(Maze m) {
		this.grid = m.getGrid();
	}

	/**
	 * Check if the coordinates (r, c) are in the bounds of the grid.
	 * 
	 * @param r
	 * @param c
	 * @return true if it is in bounds; false otherwise
	 */
	public boolean inBounds(int r, int c) {
		if(r >=0 && c >=0 && r < grid.length && c < grid[0].length)
			return true;
		return false;
	}

	/**
	 * Check if the given position is the goal square of the maze (Maze.GOAL).
	 * 
	 * @param pos
	 * @return true if position is the goal; false otherwise.
	 */
	public boolean isGoal(Position pos) {
		if(grid[pos.getRow()][pos.getRow()] == 3)
			return true;
		return false;
	}

	/**
	 * Check if the given position is an open square of the maze (Maze.OPEN).
	 * 
	 * @param pos
	 * @return true if position is open; false otherwise.
	 */
	public boolean isOpen(Position pos) {
		if(grid[pos.getRow()][pos.getRow()] == 0)
			return true;
		return false;
	}

	/**
	 * Sets the given position in the maze to visited (Maze.VISITED).
	 * 
	 * @param pos
	 */
	public void setVisited(Position pos) {
		grid[pos.getRow()][pos.getCol()] = 1;
	}

	public boolean visit(Position p) 
	{
		return grid[p.getRow()][p.getCol()] == 1;
	}
	/**
	 * Get the next positions that are 1 valid move from the current position. A
	 * move is valid if it is one square right, left, up or down, and that square is
	 * in bounds, is open or the goal square. It is invalid if it is out of bounds,
	 * is a wall square or a visited square.
	 * 
	 * Remember to set the 'previous' field of the position to the field 'current' so
	 * the positions remember a path back to the start.
	 * @param current
	 * @return an ArrayList of valid next positions
	 */
	public ArrayList<Position> getNextPositions(Position p) {
		Position left = new Position(p.getRow(), p.getCol()-1, p);
		Position right = new Position(p.getRow(), p.getCol()+1, p);
		Position up = new Position(p.getRow()-1, p.getCol(), p);
		Position down = new Position(p.getRow()+1, p.getCol(), p);
		ArrayList<Position> points = new ArrayList<Position>();
		if(inBounds(right.getRow(), right.getCol()))
			if((isOpen(right) || isGoal(right)))
				points.add(right);
		if(inBounds(left.getRow(), left.getCol()))
			if((isOpen(left) || isGoal(left)))
				points.add(left);
		if(inBounds(up.getRow(), up.getCol()))
			if((isOpen(up) || isGoal(up)))
				points.add(up);
		if(inBounds(down.getRow(), down.getCol()))
			if((isOpen(down) || isGoal(down)))
				points.add(down);
		return points;
	}

	/**
	 * Finds a valid path from the starting positions 'start' to the goal. Calls
	 * either the DFS or BFS depending on the parameter 'method'. Then uses the
	 * backtracking mechanism of position to retrace its steps back to the start.
	 * 
	 * @param start  - the starting node
	 * @param method - 0 for DFS, 1 for BFS
	 * @return the path from the start to the end.
	 */
	public ArrayList<Position> findPath(Position start, int method) {
		ArrayList<Position> nodesToVisit = new ArrayList<Position>();
		nodesToVisit.add(start);
		
		Position end = null;
		if (method == DFS_MODE)
			end = DFSForGoal(nodesToVisit);
		else if (method == BFS_MODE)
			end = BFSForGoal(nodesToVisit);
		
		ArrayList<Position> path = new ArrayList<Position>();
		while (end != null) {
			path.add(0, end); //Backtrack from end back to start to create a path
			end = end.getPrevious();
		}
		return path;
	}

	/**
	 * Uses a depth-first search to perform an exhaustive search for the goal
	 * square.
	 * 
	 * @param nodesToVisit - an ArrayList of positions to visit. They should be
	 *                     visited in a LIFO (last-in, first-out) manner (i.e.
	 *                     Stack).
	 * @return the final position of the goal; or null if there is no solution found
	 */
	private Position DFSForGoal(ArrayList<Position> nodesToVisit) {
		//Base case 1 - If there are no more nodes to visit, the path is exhausted; return null
			if(nodesToVisit.size() <= 0)
				return null;
			Position top = nodesToVisit.remove(nodesToVisit.size()-1);
			//Base case 2 - If that position (top of the stack) is the goal, the goal is found; return that position.
			if(isGoal(top))
				return top;
			//1 - If the position is open (not the goal), set the current position to visited 
			if(isOpen(top))
				setVisited(top);
			//2 - Get the next positions from the current positions (1 valid move away in each direction)
			ArrayList<Position> next = getNextPositions(top);
			//3 - If these positions are not already in the list, add them to the end of the 'nodesToVisit' 
			//ArrayList. This is considered top of the stack. 
			boolean in = false;
			for(int i = 0; i < next.size(); i++) 
			{
				for(int j = 0; j < nodesToVisit.size(); j++) 
				{
					if(next.get(i).equals(nodesToVisit.get(j)))
						in = true;
				}
				if(in == false)
					nodesToVisit.add(next.get(i));
				in = false;
			}
			
			for(int i = 0; i < nodesToVisit.size(); i++) 
				if(visit(nodesToVisit.get(i)))
					nodesToVisit.remove(i);
			//4 - Recursively call the DFSForGoal method. Save the resulting position from the recursive call
			//in a variable.
			Position pGoal = DFSForGoal(nodesToVisit);
			//5 - If the resulting Position from the recursive call is not null and it is the goal position, 
			// return the resulting Position. Otherwise, return null; there is not a solution.
			
			if(pGoal != null && isGoal(pGoal))
				return pGoal;
			else
				return null;
	}

	/**
	 * Uses a breadth-first search to perform an exhaustive search for the goal
	 * square.
	 * 
	 * @param nodesToVisit - an ArrayList of positions to visit. They should be
	 *                     visited in a FIFO (first-in, first-out) manner (i.e.
	 *                     Queue).
	 * @return the final position of the goal; or null if there is no solution found
	 */
	private Position BFSForGoal(ArrayList<Position> nodesToVisit) {
		//Base case 1 - If there are no more nodes to visit, the path is exhausted; return null
		if(nodesToVisit.size() <= 0)
			return null;
		// BFS follows the rule: First-in, first-out (FIFO) -> Queue data structure.
		// The next Position to explore is the first one in the ArrayList. This is considered
		Position next = nodesToVisit.remove(0);
		// to be the front of the queue. Start by getting that position and removing it from the 
		// ArrayList.

		//Base case 2 - If that position (front of the queue) is the goal, the goal is found; return that position.
		if(isGoal(next))
			return next;
		//Recursion:
		//1 - If the position is open (not the goal), set the current position to visited 
		if(isOpen(next))
			setVisited(next);
		//2 - Get the next positions from the current positions (1 valid move away in each direction)
		ArrayList<Position> nextPs = getNextPositions(next);
		//3 - If these positions are not already in the list, add them to the end of the 'nodesToVisit' 
		//ArrayList. This is considered end of the queue.
		for(int i = 0; i < nodesToVisit.size(); i++) 
			if(visit(nodesToVisit.get(i)))
				nodesToVisit.remove(i);
		for(int i = 0; i < nextPs.size(); i++) 
		{
			boolean in = false;
			for(int j = 0; j < nodesToVisit.size(); j++) 
			{
				if(nextPs.get(i).equals(nodesToVisit.get(j)))
					in = true;
			}
			if(in != true)
				nodesToVisit.add(nextPs.get(i));
		}
		//4 - Recursively call the BFSForGoal method. Save the resulting position from the recursive call
		//in a variable.
		Position pGoal = BFSForGoal(nodesToVisit);
		//5 - If the resulting Position from the recursive call is not null and it is the goal position, 
		// return the resulting Position. Otherwise, return null; there is not a solution.
		if(pGoal != null && isGoal(pGoal))
			return pGoal;
		else
			return null;
	}
}
