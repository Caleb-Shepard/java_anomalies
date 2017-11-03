import java.util.Scanner;

// don't worry about validation until you finish GUI
// this is pre-release logic testing on fasttrack
class Main{
  // create a cli to interface your methods and test them before moving forward with gui
  public static void main(String[] args){
    // lets be wasteful but clear
    // choose which of five preset CipherWheel settings you'd like to use
    int innerChoice;
    int middleChoice;
    int outerChoice;

    int innerStart;
    int middleStart;
    int outerStart;

    String reflectorSettings;
    String plugBoardSettings;

    // 1-5
    innerChoice = 1;
    middleChoice = 5;
    outerChoice = 3;

    // 1-?
    innerStart = 14;
    middleStart = 9;
    outerStart = 24;

    // Strings
    reflectorSettings = "KMAXFZGODICNBRPVLTEQHSUW";
    plugBoardSettings = "SZGTDVKUFOMYEWJNIXLQ";


    CipherWheel cw = new CipherWheel(innerChoice, middleChoice, outerChoice, innerStart, middleStart, outerStart);
    // Ciphers cphrs = new Ciphers();   only instantiated within CipherWheel

    String cryptMe = "Dean";

    ReflectorPanel beta = new ReflectorPanel(reflectorSettings);

    String tmp = beta.reflect("G");
    System.out.println(tmp);

    String result = cw.encrypt(cryptMe, plugBoardSettings, reflectorSettings);
    // TODO
    /*
       somewhere, make a file importer
       make something that can actually run the ops on these files and on Strings
    */
  }

}
