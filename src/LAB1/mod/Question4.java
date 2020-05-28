package LAB1.mod;

public class Question4 {
	//instance variables
	private Position _curPos;
	private static final int QUESTION4_START_ROW = 1;
	private static final int QUESTION4_START_COL = 1;

	//getter
	public Position getQuestion4Position() { return _curPos;	}

	//setter
	public Question4(Maze z) {
		_curPos = new Position(QUESTION4_START_ROW, QUESTION4_START_COL);
	}
}
