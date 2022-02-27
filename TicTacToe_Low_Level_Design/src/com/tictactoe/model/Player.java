package com.tictactoe.model;

public class Player 
{
	private String playerName;
	private String piece;
	private boolean Win = false;
	
	public Player(String playerName, String piece) 
	{
		this.playerName = playerName;
		this.piece = piece;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public boolean isWin() {
		return Win;
	}

	public void setWin(boolean win) {
		Win = win;
	}
}
