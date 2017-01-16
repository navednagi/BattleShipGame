package BattleShips;

import java.util.Scanner;

public class Control 
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
			
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                              BATTLE SHIPS");
		System.out.println("Welcome to Battle Ship! Rules are simple: I have a few ships scattered for you to destroy. Lets see how long you take!!");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		Board.setLenWid();
		System.out.println("Ok, you need a good imagination for this.");
		System.out.println("Imagine a "+Board.getLen()+" by "+Board.getWid()+" Board.");
		
		int n, i, winner = 0, x = 5; //x is number of ships
		System.out.print("How many players: ");
		n = read.nextInt();
		Player[] p = new Player[n];
		for(i = 0; i< n; i++)
		{
			p[i] = new Player(i+1);
			p[i].getReady();
		}
		System.out.println("\n\n$$$$$$ Players, you have to destroy "+x+" ships.$$$$$$\n");
		for(i = 0; i< n; i++)
		{
			if(p[i].hits != p[i].totHits)
				p[i].Play();
			
			if(p[i].hits == p[i].totHits)
			{
				winner = i+1;
				break;
			}
			
			if(i == n-1)
				i = -1;
		}
		System.out.println("Congratulations! Player "+winner+"wins by sinking my Ships in "+p[winner-1].turns+" turns!");
	}
}