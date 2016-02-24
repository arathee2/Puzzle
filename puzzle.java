import java.io.*;
import java.awt.event.*;
import java.awt.*;

class Game extends Frame implements MouseListener
{
	int n=1,k,x,y,i,j,moves=0;
	int[][] a=new int[3][3];
	
	Game()
	{
		addMouseListener(this);
	
		
		for(i=1;i<=8;)
		{
		
			j=(int)(Math.random()*3);
			k=(int)(Math.random()*3);
			if(a[j][k]==0)
			{
			a[j][k]=i;
			i++;
			}
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		Font f=new Font("Arial",Font.ITALIC,25);
		g.setFont(f);
		g.drawString("Moves: "+moves,500,200);
		f=new Font("Arial",Font.BOLD,30);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawRect(100,100,300,300);
		g.drawLine(200,100,200,400);
		g.drawLine(300,100,300,400);
		g.drawLine(100,200,400,200);
		g.drawLine(100,300,400,300);
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				if(a[i][j]!=0)
				{
					g.drawString(""+a[i][j],j*100+155,i*100+155);
				}
			}
		}
		if(a[0][0]==1 && a[0][1]==2 && a[0][2]==3 && a[1][0]==4 && a[1][1]==5 && a[1][2]==6 && a[2][0]==7 && a[2][1]==8)
		{
			Font f1=new Font("Arial",Font.BOLD,44);
			g.setColor(Color.blue);
			g.drawString("Winner!",600,300);
		}
	}
	Graphics g;	
	
	public void mouseClicked(MouseEvent me)
	{
		moves++;
		x=me.getX();
		y=me.getY();
		i=(y-100)/100;
		j=(x-100)/100;
		if(a[i][j]!=0)
		{
			if(i+1<=2 && a[i+1][j]==0)		
			{
				a[i+1][j]=a[i][j];
				a[i][j]=0;
			}
			if(j+1<=2 && a[i][j+1]==0)
			{
				a[i][j+1]=a[i][j];
				a[i][j]=0;
			}
			if(i-1>=0 && a[i-1][j]==0)
			{
				a[i-1][j]=a[i][j];
				a[i][j]=0;
			}
			if(j-1>=0 &&a[i][j-1]==0)
			{
				a[i][j-1]=a[i][j];
				a[i][j]=0;
			}
			
		}
			repaint();
	}
		
		
		
		
		
		
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
		
}

class puzzle
{
	public static void main(String args[])
	{
		Game play=new Game();
		play.setVisible(true);
		play.setSize(1000,700);
		play.setTitle("Puzzle");
		play.setBackground(Color.white);
	}
}		
