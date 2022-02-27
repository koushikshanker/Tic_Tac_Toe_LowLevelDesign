package com.tictactoe.board;

public class Board 
{
	String[][] board;
	int boardSize;
	
 	public Board(int boardSize) 
	{
 		this.boardSize = boardSize;
		board = new String[boardSize][boardSize];
		
		 for (int i=0;i<boardSize;i++) 
		 {
	            for (int j = 0; j < board.length; j++) 
	            {
	               board[i][j] = "-";
	            }
	     }
	}

	public String getposition(int x, int y) 
	{
		return board[x][y];
	}

	public String[][] getBoard() 
	{
        return board;
    }

	public String[][] markPosition(int x, int y, String piece) 
	{
		board[x][y] = piece;
		String[][] tempBoard = new String[boardSize][boardSize];
		
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				tempBoard[i][j] = board[i][j];
			}
		}
		
		return tempBoard;
	}
}
