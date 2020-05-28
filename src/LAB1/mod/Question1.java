package LAB1.mod;

public class Question1 {
	
	//instance variables
	private Position _curPos;

	private static final int QUESTION1_START_ROW = 6;
	private static final int QUESTION1_START_COL = 3;

	//getter
	public Position getQuestion1Position() { return _curPos;	}

	//setter
	public Question1(Maze z) {
		_curPos = new Position(QUESTION1_START_ROW, QUESTION1_START_COL);
	}
	
}
