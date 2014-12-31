/**
  Rock-Paper-Scissor Tournament
 
  In this challenge you will be the judge in a Rock-Paper-Scissor (RPS) tournament. The rules of RPS are simple: Rock (R) 
  beats Scissor (S), Scissor (S) beats Paper (P) and Paper (P) beats Rock (R).

  You will receive a key/value array with the name of the player and his move (R, P or S) and each player always play that 
  same move in all matches he/she plays.

  The rules for this tournament are:
  - The pairing for the matches must be done following the order of the players in the array
  - The player's moves need to be validated before the tournment starts and if their move is not R, P or S they should be 
  removed from the competition (do this before doing the pairing for the matches)
  - The minimum number of players in the tournament must be 2
  - If the number of player in the tournament is odd, the player without opponent advances to the next fase (yes, it will 
  be unfair to the other players but that's life).
  - If the players tie in a match, the first player (by the order in the array) is the winner

  Input Format
  Each input will be a string with the names of the players and their moves in the following format: "Paul-P,Dave-S,Jane-R,
  Mike-P"

  Output Format
  The output should be the name of the winner (Ex: "Dave") or "No tournament" if the number of players is not enough.

  Sample Input
  Paul-P,Dave-S,Jane-R,Mike-P

  Sample Output
  Dave

  Memory Limit
  512M
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RPSTournament
{
    /** Input channel. */
    private static BufferedReader _in;
    
    private static final String INVALID_SIZE = "No tournament";
    
    /** Returns true if tournament as apropriate size*/
    private static boolean hasValidSize(ArrayList<String> tournament)
    {
      return (tournament.size() > 1);
    }
    
    /**
     * Removes players with invalid moves (anything other than "R", "S" or "P").
     *
     */
    private static void doRemoveInvalidMoves(ArrayList<String> tournament)
    {
      String[] playerData;
      int i=0;
      
      
      for(Iterator<String> it = tournament.iterator(); it.hasNext(); /*nothing*/)
      {
        String s = it.next();
	playerData = s.split("-");
	
	if(playerData[1].equals("R") || playerData[1].equals("P") || playerData[1].equals("S"))
	  break;
	else
	  it.remove();
	
	i++;  
      }  
    }
    
    /**
     * Given two strings, each containing name and move of the player separated by a dash ("John-S")
     * returns a string containing
     */
    private static String findWinner(String player1,String player2)
    {
      String winner = new String();
      
      String firstPlayer = player1.split("-")[0];
      String secondPlayer = player2.split("-")[0];
    
      String firstMove = player1.split("-")[1];
      String secondMove = player2.split("-")[1];
      
      switch(firstMove)
      {
	case "R":
	  if(secondMove.equals("S"))
	    winner = firstPlayer;
	  else if(secondMove.equals("P"))
	    winner = secondPlayer;
	  else
	    winner = firstPlayer;
	  break;
	case "P":
	  if(secondMove.equals("R"))
	    winner = firstPlayer;
	  else if(secondMove.equals("S"))
	    winner = secondPlayer;
	  else
	    winner = firstPlayer;
	  break;
	case "S":
	  if(secondMove.equals("P"))
	    winner = firstPlayer;
	  else if(secondMove.equals("R"))
	    winner = secondPlayer;
	  else
	    winner = firstPlayer;
	  break;
      }
       
     if(winner.equals(firstPlayer))
	return player1;
     else
	return player2;
    }
    
    /**
     * Where the recursive magic happens.
     *
     */
    private static ArrayList<String> findTournamentWinner(ArrayList<String> players)
    {
	int i, lastElm = players.size()-1;
	ArrayList<String> result = new ArrayList<String>();
	
	for(i=0; i <= lastElm; i+=2)
	{
	  if(i==lastElm)
	    result.add(players.get(i));
	  else
	    result.add(findWinner(players.get(i),players.get(i+1)));
	}
	
	if(result.size() > 1)
	  result = findTournamentWinner(result);
	  
	return result;
    }
    
     /** Main */
    public static void main(String args[])
    {
      _in = new BufferedReader(new InputStreamReader(System.in));
    
      String input = new String();	  
	
      try{
	input = _in.readLine();
      }catch(IOException e){}
      
      
      String[] tournament = input.split(",");
      
      ArrayList<String> players = new ArrayList(Arrays.asList(tournament));
      
      doRemoveInvalidMoves(players);
      
      if(!hasValidSize(players)){
	System.out.println(INVALID_SIZE);
	System.exit(1);
      }
      
      String winner =  findTournamentWinner(players).get(0).split("-")[0];
    
      System.out.println(winner);
    
    }

}