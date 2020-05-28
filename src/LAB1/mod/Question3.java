package LAB1.mod;

public class Question3 {
	//instance variables
	private Position _curPos;
	private static final int QUESTION3_START_ROW = 1;
	private static final int QUESTION3_START_COL = 8;

	//getter
	public Position getQuestion3Position() { return _curPos;	}

	//setter
	public Question3(Maze z) {
		_curPos = new Position(QUESTION3_START_ROW, QUESTION3_START_COL);
	}
}
