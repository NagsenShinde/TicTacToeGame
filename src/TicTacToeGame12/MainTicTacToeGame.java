package TicTacToeGame12;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class MainTicTacToeGame extends Thread {
	public void run()
	{
		 synchronized(this)
		 {
			//System.out.println(Thread.currentThread().getName()); 
				if(Thread.currentThread().getName()!=null)
				{
					  Thread.currentThread().getName();
				}
				else
				{
					Thread.currentThread().getName();
				}
				notify();
		 }
	}
	public static void main(String[] args) throws Exception{
		
		String player1="";
		String player2="";
		 try {
			  Properties prop=new Properties();
			  FileInputStream ip= new FileInputStream("C:\\Users\\nagsen.shinde\\eclipse-workspace\\TicTacToeGame1\\src\\ResourceFile\\config.property");
			  prop.load(ip);
			  player1=prop.getProperty("Player1");
			  player2=prop.getProperty("Player2");
			  System.out.println(player1);
			  System.out.println(player2);
		} catch (IOException e) {	 
			e.printStackTrace();
		}
		 
		 MainTicTacToeGame main=new MainTicTacToeGame();
		 MainTicTacToeGame main2=new MainTicTacToeGame();
		 main.start();
		 main.setName(player1);
		 main2.start();
		 main2.setName(player2);
		 TicTacToeGame ticTacToeGame=new TicTacToeGame(player1,player2);
//		 ticTacToeGame.player1 = player1;
//		 ticTacToeGame.player2=player2;
		 synchronized(main)
		 {
			 try { 
			 main.wait();
			 }
			 catch(InterruptedException e)
			 {
				 e.printStackTrace();
			 }
		 }
		 synchronized(main2)
		 {
			 try {
			 main2.wait();
			 }
			 catch(InterruptedException e)
			 {
				 e.printStackTrace();
			 }
		 }
	}
}

