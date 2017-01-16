package BattleShips;

public class Ship 
{
	private int size, len, wid;
	
	Ship(int len, int wid)
	{
		this.len = len;
		this.wid = wid;
	}
	
	public void setSize(int size)
	{
		//int less;
		//less = (this.len<this.wid)? len:wid;
		//while((this.size = (int)(Math.random() * (less/2+1))) == 0);
		//error
		this.size = size;
		System.out.println("size = "+this.size);
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	private int row, col;
	private char dir;

	public void setShip()
	{
		this.setDir();
		this.setRow();
		this.setCol();
	}
		public void setDir()
		{
			int x;
			do
			{
				x = (int)(Math.random() * 3);
			}while(x == 0);
			//error
			System.out.println("dir x = "+x);
			switch(x)
			{
				case 1: dir = 'h';
						break;
				case 2: dir = 'v';
			}
		}
		public void setRow() 
		{
			switch(dir)
			{
			case 'h':
					this.row = (int)(Math.random() * this.wid);
					//error
					System.out.println("row: "+this.row);
					break;
			case 'v':
					do
					{
						this.row = (int)(Math.random() * this.wid);
					}while(this.row + size >= this.len);
					//error
					System.out.println("row: "+this.row);
			}
		}
		public void setCol() 
		{
			switch(dir)
			{
			case 'h':
					do
					{
						this.col = (int)(Math.random() * this.len);
					}while(this.col + size >= this.wid);
					//error
					System.out.println("col: "+this.col);
					break;
					
			case 'v':
					this.col = (int)(Math.random() * this.len);
					//error
					System.out.println("col: "+this.col);
			}
		}
	public int getRow()
	{
		return this.row;
	}
	public int getCol()
	{
		return this.col;
	}
	
	public int[][] makeArray(int a[][][], int n, int sze[])
	{
		int i, j, r, c, x, y, z, flag;
		int[][] ship = new int[this.size][2];
		switch(dir)
		{
		case 'h':
				while(true)
				{
					flag = 0;
					System.out.print("Start of goto");
					c = this.col;
					for(i = 0; i < this.size; i++)
						{
							ship[i][0] = this.row;
							System.out.print("["+i+"][0] = "+ship[i][0]);
							for(j = 1; j < 2; j++, c++)
							{
								ship[i][j]= c;
								System.out.print("["+i+"]["+j+"] = "+ship[i][j]);
							}
							//System.out.println("N ="+n);
							//System.out.println("SIZE = "+sze[n]);
							if(n != 0)
							{
							/*System.out.println("**INFO OF A**");
								for(x = 0; x < n; x++)
								{
									for(y = 0; y < sze[x]; y++)
									{
										for(z = 0; z < 2; z++)
										{
											System.out.println("A["+x+"]["+y+"]["+z+"] = "+a[x][y][z]);
										}
									}
								}*/
								for(x = 0; x < n; x++)
								{
									for(y = 0; y < sze[x]; y++)
									{
										for(z = 0; z < 1; z++)
										{
											if((a[x][y][z] == ship[i][0]) && (a[x][y][z+1] == ship[i][j-1]))
											{
												System.out.println("++value++"+a[x][y][z]+" "+a[x][y][z+1]);
												System.out.println("Before goto");
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
							}
							if(flag == 1)
								break;
						}
						if(flag == 1)
						{
							this.setRow();
							this.setCol();
							continue;
						}
						else
							break;
					}
					break;
		case 'v':
			r = this.row;
			for(i = 0; i < this.size; i++)
			{
				for(j = 0; j < 1; j++, r++)
				{
					ship[i][j]= r;
					System.out.print("["+i+"]["+j+"] = "+ship[i][j]);
				}
				ship[i][1] = this.col;
				System.out.print("["+i+"][1] = "+ship[i][1]);
			}
				
		}
			
		return ship;
	}
}