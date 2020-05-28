package LAB1.view;

import LAB1.mod.Maze;
import LAB1.mod.Player;
import LAB1.mod.Question1;
import LAB1.mod.Question2;
import LAB1.mod.Question3;
import LAB1.mod.Question4;
import LAB1.mod.Question5;

public class StringMap {

	private String _map;
	
	public StringMap() {
		_map = "";
	}
	
	public String updateMap(Player p, Question1 q1, Question2 q2, Question3 q3, Question4 q4, Question5 q5, Maze z) {
		_map = "";
		for(int r = 0; r < z.getMaze().length; r++) {
			for(int c = 0; c < z.getMaze()[r].length; c++) {
				if(z.getMaze()[r][c]) {
					_map += "W";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else if(r == p.getPosition().getRow() &&
						c == p.getPosition().getCol()) {
					_map += "M";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else if(r == z.getEnd().getRow() &&
						c == z.getEnd().getCol()) {
					_map += "E";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else if(r == q1.getQuestion1Position().getRow() &&
						c == q1.getQuestion1Position().getCol()) {
					_map += "Q";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else if(r == q2.getQuestion2Position().getRow() &&
						c == q2.getQuestion2Position().getCol()) {
					_map += "Q";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else if(r == q3.getQuestion3Position().getRow() &&
						c == q3.getQuestion3Position().getCol()) {
					_map += "Q";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else if(r == q4.getQuestion4Position().getRow() &&
						c == q4.getQuestion4Position().getCol()) {
					_map += "Q";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else if(r == q5.getQuestion5Position().getRow() &&
						c == q5.getQuestion5Position().getCol()) {
					_map += "Q";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
				else {
					_map += "O ";
					if(c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
			}
			_map += "\n";
		}
		
		return _map;
	}
}
