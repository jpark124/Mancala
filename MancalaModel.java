package mancala;

public class MancalaModel {
	int numStones;
	private int playerAScore;
	private int playerBScore;
	private int playerAUndo;
	private int playerBUndo;
	
	public int getplayerAUndoTime()
	{
		return playerAUndo;
	}
	
	public void setPlayerAUndoTime(int time)
	{
		playerAUndo = time;
	}
	
	public void setPlayerBUndoTime(int time)
	{
		playerBUndo = time;
	}
	
	public int getplayerBUndoTime()
	{
		return playerBUndo;
	}
	public void addplayerAUndoTime()
	{
		playerAUndo++;
	}
	public void addplayerBUndoTime()
	{
		playerBUndo++;
	}
	
	public void setPlayerAScore(int score) {
		playerAScore = score;
	}

	public int getPlayerAScore() {
		return playerAScore;
	}

	public void setPlayerBScore(int score) {
		playerBScore = score;
	}

	public int getPlayerBScore() {
		return playerBScore;
	}

	public void setStones(int numStones) {
		this.numStones = numStones;
	}

	public int getNumStones() {
		return numStones;
	}

}
