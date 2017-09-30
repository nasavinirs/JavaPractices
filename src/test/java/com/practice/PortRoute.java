package com.practice;

import java.util.Scanner;

public class PortRoute {

	public static void main(String[] args) {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int port[][] = new int[n][n];
		for (int i = 0; i < port.length; i++) {
			for (int j = 0; j < port.length; j++) {
				port[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter two port numbers A and B :");
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		if(port[p1-1][p2-1] == 1)
			System.out.println("There is a route");
		else
			System.out.println("There is no route");
		sc.close();
	}

}
