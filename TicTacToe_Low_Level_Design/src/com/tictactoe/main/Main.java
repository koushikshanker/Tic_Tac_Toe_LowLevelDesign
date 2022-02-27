package com.tictactoe.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.tictactoe.game.PlayGame;
import com.tictactoe.model.Player;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String player1 = scan.nextLine();
		String player2 = scan.nextLine();
		String[] player1Info = player1.split(" ", 2);
		String[] player2Info = player2.split(" ", 2);
		
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<String> moves = new ArrayList<>();
		
		players.add(new Player(player1Info[1],player1Info[0]));
		players.add(new Player(player2Info[1],player2Info[0]));
		
		while(true)
		{
			String move = scan.nextLine();
			if(move.equals("exit"))
			{
				break;
			}
			moves.add(move);
		}
		
		PlayGame game = new PlayGame(players, moves,3);
		ArrayList<String[][]> answer = game.start();
		String[][] string2DArray = new String[4][4];
		
		for(int i=0;i<answer.size();i++)
		{
			string2DArray = answer.get(i);
			try
			{
				for(int j=0;j<string2DArray.length;j++)
				{
					for(int k=0;k<string2DArray.length;k++)
					{
						System.out.print(string2DArray[j][k]+" ");
					}
					System.out.println();
				}
				System.out.println();
			}
			catch(Exception e)
			{
				
			}
			
		}
		
		System.out.println();
	}
}
