package LAB1.cont;

import javax.swing.JOptionPane;

import LAB1.mod.*;
import LAB1.view.*;

public class Overseer {

	//Instance variables
	private Player _p;
	private Maze _z;
	private Question1 _q1;
	private Question2 _q2;
	private Question3 _q3;
	private Question4 _q4;
	private Question5 _q5;
	private StringMap _s;
	private Window _w;
	private static final String[] BUTTONS = { "Northward", "Southward", "Eastward", "Westward", "Help", "Give Up..." };
	private static final String[] WINNERBUTTONS = { "On to the next interrogation", "Freedom" };
	private static final String[] QUESTION1BUTTONS = { "-2", "-7", "4", "fish" };
	private static final String[] QUESTION2BUTTONS = { "True", "False" };
	private static final String[] QUESTION3BUTTONS = { "E", "R", "S", "L" };
	
	//constructor
	public Overseer() {
		_w = new Window();
		_w.msg(" Honored five, we have gathered here today to carry out the sentencing of the heretic, Margulis...\r\n However, each of you five may ask a question to the heretic. \r\n Should Margulis get any wrong, we will grant her a merciful death. \r\n Honored five, You may begin the interrogation...");
		_z = new Maze();
		_s = new StringMap();
		_p = new Player(_z);
		_q1 = new Question1(_z);
		_q2 = new Question2(_z);
		_q3 = new Question3(_z);
		_q4 = new Question4(_z);
		_q5 = new Question5(_z);
		getPlayerMovement();
	}

	/*
     * This method is a getter for the players position. It also checks what happens to the player by utilizing the method, gamecheck.
     */
	public void getPlayerMovement() {
		while (true) {
			while (_p.isAlive()) {
				int x = _w.option(BUTTONS, _s.updateMap(_p, _q1, _q2, _q3, _q4, _q5,  _z));
				move(x);
				gamecheck();
			}
			_z = new Maze();
			_s = new StringMap();
			_p = new Player(_z);
			_q1 = new Question1(_z);
			_q2 = new Question2(_z);
			_q3 = new Question3(_z);
			_q4 = new Question4(_z);
			_q5 = new Question5(_z);
		}

	}
	
	/*
     * This method runs every time the player moves. If the player moves, the minotaur and rats have their positions updated. 
     * If the player runs into the same position as a wall, it will put them back at their previous position.
     */
	public void move(int x) {
		if (!_p.move(getPlayerDirection(x), _z)) {
			_w.msg("YOU SHALL NOT LEAVE THE PREMISE, HERETIC! ");
		}
	}

	/*
     * This method checks every thing the player can possibly do. If they reach certain positions of the map, they will be asked a question.
     */
	public void gamecheck() {
		if (_p.getPosition().getRow() == _q1.getQuestion1Position().getRow()
				&& _p.getPosition().getCol() == _q1.getQuestion1Position().getCol()) {
			askQ1();
		}
		if (_p.getPosition().getRow() == _q2.getQuestion2Position().getRow()
				&& _p.getPosition().getCol() == _q2.getQuestion2Position().getCol()) {
			askQ2();
		}
		if (_p.getPosition().getRow() == _q3.getQuestion3Position().getRow()
				&& _p.getPosition().getCol() == _q3.getQuestion3Position().getCol()) {
			askQ3();
		}
		if (_p.getPosition().getRow() == _q4.getQuestion4Position().getRow()
				&& _p.getPosition().getCol() == _q4.getQuestion4Position().getCol()) {
			askQ4();
		}
		if (_p.getPosition().getRow() == _q5.getQuestion5Position().getRow()
				&& _p.getPosition().getCol() == _q5.getQuestion5Position().getCol()) {
			askQ5();
		}
		if (_p.getPosition().getRow() == _z.getEnd().getRow() && _p.getPosition().getCol() == _z.getEnd().getCol()) {
			int o = _w.option(WINNERBUTTONS, "The Honored five have decided your fate... \r\n NO HANDS RAISED \r\n You may live.");
			if (o == 0) {
				_p.killPlayer();
			}
			else {
				_w.msg(" My dear, you are free! \r\n Indeed, I am free, but I cannot love you anymore... \r\n Margulis... Please... Forgive me. \r\n I won't, like how you wouldn't let me out. You betrayed me. We are nothing. ");
				System.exit(0);
			}
		}
	}
	
	//A getter for the player's movement
	public Direction getPlayerDirection(int x) {
		if (x == 4) {
			// HELP
			_w.msg(" Do something. Get me out of here! \r\n You know I can't, my dear... \r\n Can't or won't? \r\n I told you not to speak out. If you recant, maybe- \r\n We don't have enough time for recantation! Just tell me what to do. \r\n M is you, Margulis. \r\n The Qs represent each of the Honored, they will ask you a question. \r\n Answer them wrong, and you will face the consequences...");
		} else if (x == 0) {
			// NORTH
			return Direction.North;
		} else if (x == 1) {
			// SOUTH
			return Direction.South;
		} else if (x == 2) {
			// EAST
			return Direction.East;
		} else if (x == 3) {
			// WEST
			return Direction.West;
		} else {
			// EXIT
			_w.in(" The heretic has given up. \r\n The Honored have decided your fate... \r\n FIVE HANDS RAISED. \r\n Any last words?");
			_w.msg(" Hm. \r\n That is quite interesting, heretic! \r\n Your death approaches and your final words will be sent to the Gods...");
			System.exit(0);
			return null;
		}
		return null;
	}

	/*
	 * The rest of these methods open up a window and asks the player a question. If they get it right, they move on in the maze.
	 * If they don't get it right, the game is restarted.
	 */
	public void askQ1() {
		int o = _w.option(QUESTION1BUTTONS, "THE FIRST HONORED ASKS: \r\n What is two plus two?");
		if(o == 2) {
			_w.msg("Correct");
		}
		else {
			_w.msg("You are wrong! \r\n A HAND RAISES \r\n Guards! Send this heretic to the executioner AT ONCE! \r\n You were sent back to the center...");
			_p.killPlayer();
		}
	}
	
	
	
	
	public void askQ2() {
		int o = _w.option(QUESTION2BUTTONS, "THE SECOND HONORED ASKS: \r\n TRUE OR FALSE \r\n If you cut an earthworm in half, both halves can regrow their body.");
		if(o == 1) {
			_w.msg("Correct");
		}
		else {
			_w.msg("You are wrong! \r\n A HAND RAISES \r\n Guards! Send this heretic to the executioner AT ONCE! \r\n You were sent back to the center...");
			_p.killPlayer();
		}
	}
	
	
	
	
	public void askQ3() {
		int o = _w.option(QUESTION3BUTTONS, "THE THIRD HONORED ASKS: \r\n What is the twelfth letter of the alphabet?");
		if(o == 3) {
			_w.msg("Correct");
		}
		else {
			_w.msg("You are wrong! \r\n A HAND RAISES \r\n Guards! Send this heretic to the executioner AT ONCE! \r\n You were sent back to the center...");
			_p.killPlayer();
		}
	}
	
	
	
	
	public void askQ4() {
		String strInput = "peppers";
		String o = _w.in("THE FOURTH HONORED ASKS: \r\n FILL IN THE BLANK \r\n Peter Piper picked a peck of pickled _______");
		if(o.equalsIgnoreCase(strInput)) {
			_w.msg("correct");
		}
		else {
			_w.msg("You are wrong! \r\n A HAND RAISES \r\n Guards! Send this heretic to the executioner AT ONCE! \r\n You were sent back to the center...");
			_p.killPlayer();
		}
	}
	
	
	
	
	public void askQ5() {
		String strInput5 = "8";
		String o = _w.in("THE FIFTH HONORED ASKS: \r\n FILL IN THE BLANK \r\n The _th Amendment of the US Constitution states: \r\n Excessive bail shall not be required, nor excessive fines imposed, nor cruel and unusual punishments inflicted.");
		if(o.equals(strInput5)) {
			_w.msg("correct");
		}
		else {
			_w.msg("You are wrong! \r\n A HAND RAISES \r\n Guards! Send this heretic to the executioner AT ONCE! \r\n You were sent back to the center...");
			_p.killPlayer();
		}
	}

}
