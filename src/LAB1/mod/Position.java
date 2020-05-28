package LAB1.mod;

public class Position {

	//instance variables
	private int _row;
	private int _col;
	
	//Getters and a setter for player position
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public Position(int r, int c) {
		_row = r;
		_col = c;
	}
}
