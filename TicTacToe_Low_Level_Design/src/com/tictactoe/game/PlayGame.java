package com.tictactoe.game;

import java.util.ArrayList;
import com.tictactoe.board.Board;
import com.tictactoe.model.Player;

public class PlayGame 
{
	ArrayList<Player> players;
	ArrayList<String> moves;
	ArrayList<String[][]> answer = new ArrayList<String[][]>();
	Board board;
	
	public PlayGame(ArrayList<Player> players, ArrayList<String> moves, int boardSize) 
	{
		this.players = players;
		this.moves = moves;
		board = new Board(boardSize);
	}

	public ArrayList<String[][]>  start() 
	{
		int playerTurn = 0;
		answer.add(board.markPosition(1,1,"-"));
		
		for(int i=0;i<moves.size();i++)
		{
			String coord = moves.get(i);
			int x = (coord.charAt(0)-'0')-1;
			int y = (coord.charAt(2)-'0')-1;
			
			if(validMove(x,y) && isEmpty(x,y))
			{
				this.answer.add(makeMove(x,y,playerTurn));
				
				if(checkWinner(x,y,players.get(playerTurn).getPiece()))
				{
					String[][] winner = {{"Winner is "+players.get(playerTurn).getPlayerName()}};
					answer.add(winner);
					break;
				}
				
				if(isBoardFull(board.getBoard()))
				{
					String[][] gameOver ={{"Game Over","","" }};
					answer.add(gameOver);
					break;
				}
				
				if(playerTurn==0)
				{
					playerTurn = 1;
				}
				else
				{
					playerTurn = 0;
				}
				
			}
			else
			{
				String[][] invalidMove ={{"Invalid Move","","" }};
				answer.add(invalidMove);
			}	
		}
		
		return answer;
	}

	private boolean isBoardFull(String[][] board) 
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				if(board[i][j].equals("-"))
					return false;
			}
		}
		
		return true;
	}

	private boolean checkWinner(int row, int col, String piece) 
	{
		boolean winRow = true, winCol = true, winLeft = true, winRight = true;
	        
	        for(int i=0;i<board.getBoard().length;i++)
	        {
	            if(!board.getposition(row,i).equals(piece))
	            {
	                winRow = false;
	            }
	            
	            if(!board.getposition(i,col).equals(piece))
	            {
	                winCol = false;
	            }
	            
	            if(!board.getposition(i,i).equals(piece))
	            {
	                winLeft = false;
	            }
	            
	            if(!board.getposition(i,board.getBoard().length-i-1).equals(piece))
	            {
	                winRight =false;
	            }
	        }
	        
	        return winRow || winCol || winLeft || winRight;
    }
	
	private String[][] makeMove(int x, int y, int i) 
	{
		return board.markPosition(x,y,players.get(i).getPiece());
	}

	private boolean isEmpty(int x, int y) 
	{
        return board.getposition(x,y).equals("-");
	}

	private boolean validMove(int x, int y) 
	{
        return x < board.getBoard().length && y < board.getBoard().length;
	}
}
