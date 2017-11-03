import java.util.Scanner;
// This is a human which will likely lose
public class player {

  // Declare all of your variables
  private String playerName = "TTTrips";
  private char symbol;

  public void setSide(char side) {
    symbol = side;
  }

  public void setName(String name){
    playerName = name;
  }

  public char getSide(){
    return symbol;
  }

  public String getName(){
    return playerName;
  }

  public int makeMove(Scanner reader){
    System.out.println("Make a move");
    return reader.nextInt();
  }


}
