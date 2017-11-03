// tester to see if the algo inherently follows all of the rules

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*
public class proof_test
{
  public void playGame(){

    // declare primitives
    boolean playerMovesFirst;
    char playerChar;
    int recentMove;
    int moveNumber;
    board bard;

    // declare objects
    Scanner reader;
    String moves;
    Random rng;

    player human = new player();
    ttt_master wuju = new ttt_master();

    // instantiate
    rng= new Random();
    reader = new Scanner(System.in);
    bard = new board();
    moveNumber = 0;
    moves = "";
    playerChar = 'q';

    // print out the beginning prompt, which gets the name of the player
    human.setName(bard.prompt(reader));

    // choose X or O before you start
    while(playerChar != 'X' && playerChar != 'O') {
      System.out.println("Would you like to start as X, or as O?");
      playerChar = reader.nextLine().charAt(0);
      if(playerChar != 'X' && playerChar != 'O') {
        System.out.println("Please choose 'X' or 'O' as an option.");
      }
    }

    // assign symbols
    if(playerChar == 'X')
      wuju.setSide('O');
    else if(playerChar == 'O')
      wuju.setSide('X');
    else
      System.out.println("Unexpected error when assigning symbol to ttt player.");

    human.setSide(playerChar);

    // assign first turns
    System.out.println("Coin tossing for the first move... ");
    playerMovesFirst = rng.nextBoolean();
    if(playerMovesFirst)
      System.out.println("You move first.");
    else
      System.out.println("I move first.");

    // if the computer moves first, have it make a move
    if(!playerMovesFirst){
      System.out.println("moves is " + moves);
      moves += wuju.firstMove(rng);
      System.out.println("moves is " + moves);
      moveNumber++;
    }

    if (playerMovesFirst) {
      recentMove = human.makeMove(reader);
      if(validMove(recentMove, moves)) {
        moves += (char) recentMove;
      }
      else
      {
        while(!validMove(recentMove, moves))
        {
          recentMove = human.makeMove(reader);
          System.out.println("Make a valid move! Enter an integer from 1-9");
        }
        moves += (char) recentMove;
      }
      moveNumber++;
    }


    while(gameOn(moves) && (moveNumber < 9)) {
      bard.printBoard(moves, human.getSide(), wuju.getSide(), playerMovesFirst);
      if(winConditions(moves))
        System.out.println("Someone won! I need to fix this line to say who exactly.");

      if(playerMovesFirst && moveNumber % 2 != 0) {
        moves += wuju.makeMove(rng);
      }
      else {
        moves += human.makeMove(reader);
      }

      moveNumber++;
    }

    bard.printBoard(moves, human.getSide(), human.getSide(), playerMovesFirst);

    if(winConditions(moves)) {
      if (playerMovesFirst)
        System.out.println("The human won!");
      else
        System.out.println("The computer has won!");
    }

    if(moveNumber == 9)
      if(drawGame(moves))
        System.out.println("The game was a draw");


  }

  void doSomething(){
    System.out.println("You forgot to write this out in your project!");
  }

  public static void printDirections(Scanner premade){
    System.out.println("welcome message");
    System.out.println("directions");
    System.out.println("board example with indeces");
    System.out.println("You will be playing against a computer. ");
  }

  public boolean validMove(int move, String moves){
    // if the space is already taken, the move is invalid
    // if the move isn't an integer 1-9 inclusive, the move is invalid
    int i;

    i = 0;
    while(i < moves.length())
    {
      // if the move has already been made -> the list of made moves is a String of numbers
      if((char) move == moves.charAt(i))
        return false;
      i++;
    }
    // fix later /ff

    // out of range
    if(move > 9 || move < 1)
      return false;

    return true;
  }

  public boolean gameOn(String moves){
    if(moves.length() < 1) {
      System.out.println("Within gameOn method, you tried to check the continuation of the game");
      System.out.println("without any moves made by either player");
    }
    if(moves.length() > 9) {
      System.out.println("You tried to check the continuation of the game when more than 9 moves\n"+
              "may have been made. Check your logic in the gameOn method."
      );
      System.out.println("moves is " + moves);
    }

    if(winConditions(moves) == false)
    {
      return true;
    }

    // make sure that you've examined all conditions first
    return false;
  }

  boolean winConditions(String moves){

    if(moves.length() < 1)
      System.out.println("You called for validation before a move was made. Crash.");

    int i;
    String firstPlayerMoves;
    String secondPlayerMoves;

    // making null strings jic because idk wth I'm doing and how the jvm interacts with it
    firstPlayerMoves = "";
    secondPlayerMoves = "";

    firstPlayerMoves += moves.charAt(0);

    // split moves into both sides
    i = 1;
    while(i < moves.length()){
      // every second character, started at index 0 (see firstPlayerMoves declaration)
      if(i%2 == 1)
        secondPlayerMoves += moves.charAt(i);
      else
        firstPlayerMoves += moves.charAt(i);
      i++;
    }

    // you'll have to list all of the win conditions. Hard code, ship it for now and optimize when
    // it works
    if(threeInARow(firstPlayerMoves) || threeInARow(secondPlayerMoves))
      return true;

    return false;
  }

  boolean drawGame(String moves){
    if(moves.length() >= 9 && !winConditions(moves))
      return true;
    return false;
  }

  boolean threeInARow(String playerMoves){

    if (playerMoves.length() < 3)
      return false;

    if(playerMoves.contains("1"))
    {
      if(playerMoves.contains("2") && playerMoves.contains("3"))
        return true;
      else if(playerMoves.contains("5") && playerMoves.contains("9"))
        return true;
      else if(playerMoves.contains("4") && playerMoves.contains("7"))
        return true;
    }

    if(playerMoves.contains("8"))
    {
      if(playerMoves.contains("9") && playerMoves.contains("7"))
        return true;
      else if(playerMoves.contains("5") && playerMoves.contains("2"))
        return true;
    }

    if(playerMoves.contains("6"))
    {
      if(playerMoves.contains("9") && playerMoves.contains("3"))
        return true;
      else if(playerMoves.contains("5") && playerMoves.contains("4"))
        return true;
    }

    if(playerMoves.contains("3"))
      if(playerMoves.contains("5"))
        if(playerMoves.contains("7"))
          return true;

    return false;
  }

  // we aren't making anagrams but that's basically what we're doing
  // don't use an arrayList. You can easily make an array of size 9factorial
  public static ArrayList<String> permutate(String str) {
    ArrayList<String> returnMe;
    int lastIndex;

    returnMe = new ArrayList<String>();
    // return if length is 1 (arbitrary for our problem)
    if (str.length() == 1) {
      returnMe.add(str);
    }
    else if (str.length() > 1) {
      lastIndex = str.length() - 1;
      // get a node, and make a branch
      String node = str.substring(lastIndex);
      // branch
      String branch = str.substring(0, lastIndex);
      // Perform permutation on the rest of the string
      // merge node and branch
      returnMe = merge(permutate(branch), node);
    }

    return returnMe;
  }

  // use an arraylist for now; optimize later
  // this works but it's copy pasted. Fix your implementation please
  public static ArrayList<String> merge(ArrayList<String> list, String c) {
    ArrayList<String> res = new ArrayList<String>();
    // Loop through all the string in the list
    for (String s : list) {
      // For each string, insert the last character to all possible postions
      // and add them to the new list
      for (int i = 0; i <= s.length(); ++i) {
        String ps = new StringBuffer(s).insert(i, c).toString();
        res.add(ps);
      }
    }
    return res;
  }

  */

public class proof_test {

  void printBoard(char [][]spaces){
    int i;
    int j;
    int k;

    i = 0;
    j = 0;
    k = 0;

    while (i < 8){
      System.out.printf(" %c ", spaces[j][k]);
      if((i + 1) % 3 == 0) {
        k = 0;
        System.out.printf("\n-----------\n");
        j++;
      }
      else {
        System.out.printf("|");
        k++;
      }
      i++;
    }
    System.out.printf(" %c ", spaces[j][k]);

  }

  public void makeMove(char location, boolean isX, int moveCount, char[][] spaces){
    //add the char to the right space on the board
    int i;
    int j;
    int k;
    char symbol;

    if(isX)
      symbol = 'X';
    else
      symbol = 'O';

    i = 0;
    j = 0;
    k = 0;

    while (i < 8){
      if(Character.getNumericValue(location) - 1 == i)
        spaces[j][k] = symbol;
      if((i + 1) % 3 == 0) {
        k = 0;
        j++;
      }
      else {
        k++;
      }
      i++;
    }
    if(Character.getNumericValue(location) - 1 == i)
      spaces[j][k] = symbol;


  }

  // can't manage to get this far
  public boolean winner(char [][] spaces){
    // return true if someone won
    return false;
  }

  public boolean draw(char[][] spaces){
    // if all of the spaces are X and O but winner returns false
    // then return true

    // default case
    return false;
  }

  public void everything_broke_idk(){
    Scanner reader = new Scanner(System.in);
    Random randy = new Random();
    boolean isX = false;
    boolean trouble = randy.nextBoolean();
    boolean moveFirst = trouble;
    int moveCount = 0;
    int max = 9;
    int min = 0;
    player you = new player();
    ttt_master computer = new ttt_master();
    char[][] spaces = {
      {'1', '2', '3'},
      {'4', '5', '6'},
      {'7', '8', '9'},
    };

    System.out.println("Press 1 to play as X and 2 to play as O");
    if(reader.nextInt() == 1)
      isX = true;

    printBoard(spaces);

    if(moveFirst && moveCount == 0) {
      System.out.println("Make a move, you first.");
      makeMove(reader.next().charAt(0), isX, moveCount, spaces);
      moveCount++;
    }
    else if (!moveFirst && moveCount == 0){
      makeMove((char) (randy.nextInt((max - min) + 1) + min), !isX, moveCount, spaces);
      System.out.println("I'll move first this time.");
      moveCount++;
    }

    while(moveCount < 8) {

      if(moveFirst && moveCount == 0) {
        System.out.println("Make a move, you first.");
        makeMove(reader.next().charAt(0), isX, moveCount, spaces);
        moveCount++;
      }
      else if (!moveFirst && moveCount == 0){
        makeMove((char) (randy.nextInt((max - min) + 1) + min), !isX, moveCount, spaces);
        System.out.println("I'll move first this time.");
        moveCount++;
      }
      else if((moveCount % 2  != 0) && (moveFirst)) {
        System.out.println("c1 " + moveCount % 2 + " Move first? " + moveFirst);
        printBoard(spaces);
        System.out.println("Make a move.");
        makeMove(reader.next().charAt(0), isX, moveCount, spaces);
        moveCount++;
      }
      else if((moveCount % 2  == 0) && (!moveFirst)) {
        System.out.println("c2");
        printBoard(spaces);
        System.out.println("Make a move.");
        makeMove(reader.next().charAt(0), isX, moveCount, spaces);
        moveCount++;
      }
      else if((moveCount % 2 != 0) && (!moveFirst)){
        System.out.println("c3 " + moveCount % 2 + " Move first? " + moveFirst);
        printBoard(spaces);
        makeMove((char) (randy.nextInt((max - min) + 1) + min), !isX, moveCount, spaces);
        System.out.println("I'll move this time.");
        moveCount++;
      }
      else if((moveCount % 2 == 0) && (moveFirst)){
        System.out.println("c4");
        printBoard(spaces);
        makeMove((char) (randy.nextInt((max - min) + 1) + min), !isX, moveCount, spaces);
        System.out.println("I'll move this time.");
        moveCount++;
      }

      moveCount++;
    }
  }




  public static void main(String[] args){
    proof_test trial = new proof_test();
    trial.everything_broke_idk();
    // your guess is as good as mine
  }
}
