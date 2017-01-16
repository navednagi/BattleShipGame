package BattleShips;

import java.util.Scanner;

public class Player 
{
	private static int[] gss = new int[2];
	int hits = 0, totHits = 0, turns = 0, i, n = 2, shipSize[] = {2,3}, index; //{2,3,4,5,5};
	
	
	
	int a[][][] = new int[n][][];
	int[] sze = new int[n];
	
	Player(int index)
	{
		System.out.println("In constructor");
		this.index = index;
	}
	public void getReady()
	{
		Board.setLenWid();
		Ship[] s = new Ship[n];
		System.out.println("***********************************************************************************************");
		for(i = 0; i < n; i++)
		{
			s[i] = new Ship(Board.getLen(), Board.getWid());
			s[i].setSize(shipSize[i]);
			s[i].setShip();
			sze[i] = s[i].getSize();
			a[i] = s[i].makeArray(a, i, sze);
			totHits += s[i].getSize();
		}
	}
	
	public void Play()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("Player "+index+", Lets Begin!!");
		System.out.println("Give me a guess...");
		System.out.print("Row and column = ");
		gss[0] = read.nextInt();
		gss[1] = read.nextInt();
		turns++;
		hits += guess(a, sze, n);
	}
	
	public static int guess(int a[][][], int size[], int n)
	{
		
		int i, j, k, flag = 0;
		for(k = 0, i = 0; k < n; k++, i++)
		{
			for(i = 0; i < size[k]; i++)
			{
				for(j = 0; j < (2-1); j++) //(2-1) to alter later if needed
				{
					if(a[k][i][j] == gss[j] && a[k][i][j+1] == gss[j+1])
					{
						a[k][i][j] = -1;
						a[k][i][j+1] = -1;
						flag = 1;
						break;
					}
				}
				if(flag == 1)
					break;
			}
			if(flag == 1)
				break;
		}
		if(flag == 1)
		{
			System.out.println("***We have a hit!!***");
			int flag2 = 0;
			for(i = 0; i < size[k]; i++)
			{
				for(j = 0; j < 2; j++)
				{
					if(a[k][i][j] == -1)
						flag2++;
				}
			}
			if(flag2 == size[k]*2)
				System.out.println("~~~~Good job, destroyed a ship!!~~~~\n");
			else
				System.out.println();

			return flag;
		}
		else
		{
			System.out.println("<How about another shot,eh??>\n");
			return flag;
		}
	}
}
