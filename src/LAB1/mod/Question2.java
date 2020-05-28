package LAB1.mod;

public class Question2 {
	//instance variables
	private Position _curPos;
	private static final int QUESTION2_START_ROW = 6;
	private static final int QUESTION2_START_COL = 8;

	//getter
	public Position getQuestion2Position() { return _curPos;	}

	//setter
	public Question2(Maze z) {
		_curPos = new Position(QUESTION2_START_ROW, QUESTION2_START_COL);
	}

}
