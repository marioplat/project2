package LAB1.mod;

public class Player {
	//Instance variables
	private Position _curPos;
	
	private boolean _isAlive = true;

	//Getters and setters
	public Position getPosition() {
		return _curPos;
	}

	public boolean isAlive() {
		return _isAlive;
	}

	public void setPosition(Position p) {
		_curPos = p;
	}

	public void killPlayer() {
		_isAlive = false;
	}

	public Player(Maze z) {
		_curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
	}
	
	/*
	 * This method will make the player move to their desired direction with the use of the JOptionButtons.
	 */
	public boolean move(Direction d, Maze z) {
		if (d == Direction.North) {
			if (_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.South) {
			if (_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.East) {
			if (_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length
					&& !z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
				return true;
			}
		} else {
			if (_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
				return true;
			}
		}

		return false;
	}
}
