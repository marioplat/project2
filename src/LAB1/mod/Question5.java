package LAB1.mod;

public class Question5 {
	//instance variables
	private Position _curPos;
	private static final int QUESTION5_START_ROW = 8;
	private static final int QUESTION5_START_COL = 1;

	//getter
	public Position getQuestion5Position() { return _curPos;	}

	//setter
	public Question5(Maze z) {
		_curPos = new Position(QUESTION5_START_ROW, QUESTION5_START_COL);
	}
}
