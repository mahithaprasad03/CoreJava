package Ineuron_Java;


import java.util.Scanner;

//Features added

//1.Added a new player

//2.Restricted number guessing from 0 to 10 

//3.Printed the number given by Guesser irrespective of whether it is right or wrong


class Guesser
{
	int guessNum;
	
	public int guessNumber()
	{
		Scanner scan=new Scanner(System.in);
		
		
		System.out.println("Guesser kindly guess the number from 0 to 10");
		guessNum=scan.nextInt();
		
		while(guessNum>10 || guessNum<0) {
			
			System.out.println("Guesser kindly guess the number from 0 to 10");
			guessNum=scan.nextInt();
		}
		return guessNum;	
		
	}	

}

class Player
{
	int pguessNum;
	
	public int guessNumber()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player kindly guess the number from 0 to 10");
		pguessNum=scan.nextInt();
		while(pguessNum>10 || pguessNum<0) {
			
			System.out.println("Player kindly guess the number from 0 to 10");
			pguessNum=scan.nextInt();
		}
		
		return pguessNum;
	}
}

class Umpire
{
	
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	int numFromPlayer4;
	
	
	public void collectNumFromGuesser()
	{
		Guesser g=new Guesser();
		numFromGuesser=g.guessNumber();
		
	}
	
	
	public void collectNumFromPlayer()
	{
		Player p1=new Player();
		Player p2=new Player();
		Player p3=new Player();
		Player p4=new Player();
		
		
		numFromPlayer1=p1.guessNumber();
		numFromPlayer2=p2.guessNumber();
		numFromPlayer3=p3.guessNumber();
		numFromPlayer4=p4.guessNumber();
	}
	
	void compare()
	{
		
		if(numFromGuesser==numFromPlayer1)
		{
			if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3 && numFromGuesser==numFromPlayer4)
			{
				System.out.println("Game tied all four players guessed correctly");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			else if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3 ) {
				
				System.out.println("Player 1,Player2 and Player 3 won the game");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			else if(numFromGuesser==numFromPlayer2)
			{
				System.out.println("Player 1 and Player2 won the game");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			else if(numFromGuesser==numFromPlayer3)
			{
				System.out.println("Player 1 and Player3 won ");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			else if(numFromGuesser==numFromPlayer4) {
				System.out.println("Player 1 and Player 4 won");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			else
			{
			
			System.out.println("Player 1 won the game");
			System.out.println("Guesser number is "+ numFromGuesser );
			}
		}
		
		
		else if(numFromGuesser==numFromPlayer2)
		{
			
		    if(numFromGuesser==numFromPlayer3 && numFromGuesser==numFromPlayer4) {
		    	
		    	System.out.println("Player 2,Player3 and Player 4 won the game");
		    	System.out.println("Guesser number is "+ numFromGuesser );
		    }
			
			else if(numFromGuesser==numFromPlayer3)
			{
			System.out.println("Player 2 and Player3 won the game");
			System.out.println("Guesser number is "+ numFromGuesser );
			}
			else if(numFromGuesser==numFromPlayer4)
			{
				System.out.println("Player 2 and Player 4 won the game");	
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			else
			{
				System.out.println("Player 2 won the game");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
		}
		
		else if(numFromGuesser==numFromPlayer3)
		{
			if(numFromGuesser==numFromPlayer3 && numFromGuesser==numFromPlayer4) {
				
				System.out.println("Player 3 and Player 4 won the game");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			else
			{
				System.out.println("Player 3 won the game");
				System.out.println("Guesser number is "+ numFromGuesser );
			}
			
		}	
		
		
		else if(numFromGuesser==numFromPlayer4)
		{
			System.out.println("Player 4 won the game");
			System.out.println("Guesser number is "+ numFromGuesser );
		}
		else
		{
			System.out.println("Game lost! try again");
			System.out.println("Guesser number is "+ numFromGuesser );
		}
	}
	
}


public class Launchgame {

	public static void main(String[] args) {		
		
		Umpire u=new Umpire();
		u.collectNumFromGuesser();
		u.collectNumFromPlayer();
		u.compare();

	}

}







