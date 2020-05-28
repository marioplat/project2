package LAB1.mod;

public class Maze {

	//Instance variables
	private boolean[][] _maze;
	private Position _start;
	private Position _end;
	
	private static final int PLAYER_START_ROW = 4;
	private static final int PLAYER_START_COL = 6;
	private static final int PLAYER_END_ROW = 8;
	private static final int PLAYER_END_COL = 9;
	
	//getters
	public Position getStart() { return _start; }
	public Position getEnd() { return _end; }
	public boolean[][] getMaze() { return _maze; }
	
	/*
     * This method sets up the labyrinth, which is an array of boolean values. True values represent a
     * wall that the player cannot pass. It also contains variables that establishes the player's starting position
     */
	public Maze() {
		// true is a wall.
		boolean[][] maze = {
				{true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true}, 
				{true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
				{true, 	false, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
				{true, 	false, 	true, 	false, 	false, 	false, 	false, 	true, 	false, 	true},
				{true,	false, 	true, 	false, 	true, 	true, 	false, 	true, 	false, 	true},
				{true,  false, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	true},
				{true,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
				{true, 	false, 	true, 	true, 	true, 	true, 	true, 	true,    true, 	true},
				{true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
				{true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true},
				};
		_maze = maze;
		_start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
		_end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
	}
}
