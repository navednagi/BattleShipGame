package BattleShips;

public class Board 
{
	private static int len, wid;

	public static void setLenWid() 
	{
		do
		{
			len = 10; //(int)(Math.random() * 11);
			wid = 10; //(int)(Math.random() * 11);
		}while(len == 0 || wid == 0);
	}

	public static int getLen() 
	{
		return len;
	}	
	
	public static int getWid() 
	{
		return wid;
	}
}