import java.util.Random;

// This is a bot, a ttt_master
public class ttt_master {

  // Declare all of your variables
  private String masterName = "TTTrips";
  private char symbol = 'z';

  public void setSide(char side) {
    symbol = side;
  }

  public char getSide(){
    return symbol;
  }

  public String getName(){
    return masterName;
  }

  public String firstMove(Random rng){
    int verify;
    char idk;
    verify = randIntHotfix(1, 9);
    idk = (char) verify;
    return String.valueOf(idk);
  }

  // de-randomize this later
  public String makeMove(Random rng){
    return rng.ints(1, 1, 9).findFirst().toString();
  }

  // the java random class has some interesting interactions with other functions in this program
  // that create fatal bugs
  public static int randIntHotfix(int min, int max){
    Random randy = new Random();
    return min + randy.nextInt((max - min) +1);
  }
}
