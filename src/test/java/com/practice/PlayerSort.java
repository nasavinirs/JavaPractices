package com.practice;

import java.util.Arrays;

public class PlayerSort {
	public static void main(String args[]){

		Player[] players = new Player[5];

		Player amy = new Player("amy", 100);
		Player david = new Player("david", 100);
		Player heraldo = new Player("heraldo", 50);
		Player aakansha = new Player("aakansha", 75);
		Player aleksa = new Player("aleksa", 150);

		players[0]=amy;
		players[1]=david;
		players[2]=heraldo;
		players[3]=aakansha;
		players[4] = aleksa;

		System.out.println("Sort based on Player Score");
		Arrays.sort(players);

		for(Player temp: players){
		   System.out.println(temp.getPlayerName() +" : " + temp.getScore());
		}

		System.out.println("\nSort based on Player Name");
		Arrays.sort(players, Player.PlayerNameComparator);

		for(Player temp: players){
		   System.out.println(temp.getPlayerName() +" : " + temp.getScore());
		}
		
	}
}
