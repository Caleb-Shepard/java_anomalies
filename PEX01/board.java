import java.util.Scanner;

public class board {

  // rework your algorithm
  void printBoard(String moves, char playerChar, char computerChar, boolean playerMovesFirst){
    int i;
    int j;

    i = 0;
    j = 0;
    while (i < 8){
      while(j < moves.length()) {
        if ((int) moves.charAt(j) == i && playerMovesFirst && moves.length() % 2 == 1)
          System.out.printf(" %s ", playerChar);
        else if ((int) moves.charAt(j) == i && playerMovesFirst && moves.length() % 2 == 0)
          System.out.printf(" %s ", playerChar);
        else if ((int) moves.charAt(j) == i && !playerMovesFirst && moves.length() % 2 == 1)
          System.out.printf(" %s ", computerChar);
        else if ((int) moves.charAt(j) == i && !playerMovesFirst && moves.length() % 2 == 0)
          System.out.printf(" %s ", computerChar);
        else
          System.out.printf("  ");
        j++;
      }
      System.out.printf(" %s ", moves.charAt(i));
      if((i + 1) % 3 == 0)
        System.out.printf("\n-----------\n");
      else
        System.out.printf("|");
      i++;
    }
    System.out.printf(" %s ", moves.charAt(i));
  }

  // change this; the player makes the move, not the board
  // player makeMove
  // board saveMove
  // move to metaGame

  // return a name for the player
  String prompt(Scanner support){

    String playerName;

    // the board is initially empty
    printBoard("         ", ' ', ' ', false);

    System.out.printf("Poly Tic-tac-toe has started.\n");
    System.out.printf("Enter a name for the Human Player: ");
    playerName = support.nextLine();

    System.out.printf("\n");

    return playerName;
  }

}
