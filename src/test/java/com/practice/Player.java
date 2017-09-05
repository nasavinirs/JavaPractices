package com.practice;

import java.util.Comparator;

public class Player implements Comparable<Player> {

	private String playerName;
	private int score;

	public Player(String playerName, int score) {
		super();
		this.playerName = playerName;
		this.score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String name) {
		this.playerName = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int compareTo(Player comparePlayer) {
		int compareScore = ((Player) comparePlayer).getScore();

		// ascending order
		// return this.score - compareScore 	;

		// descending order
		return compareScore - this.score;
	}

	public static Comparator<Player> PlayerNameComparator = new Comparator<Player>() {

		public int compare(Player player1, Player player2) {
			String playerName1 = player1.getPlayerName();
			String playerName2 = player2.getPlayerName();

			// ascending order
			return playerName1.compareTo(playerName2);

			// descending order
			// return playerName2.compareTo(playerName1);
		}
	};

}
