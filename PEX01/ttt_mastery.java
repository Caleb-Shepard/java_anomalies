/*
// methods for mastering ttt

public class ttt_mastery {

  // see if the win conditions are met
  // optimize; persist and only check new possibilities
  // you won't need to manipulate board positioning if you just look at all possibilities

  // export this into a csv?
  void possibilities(){
    // generate all possibilities first, check wins second, trim if won, export list thirdly

    int i;
    final int boardWidth = 3;
    final int boardHeight = 3;

    // instantiate i to 1 so that you have a number consistent with the numbering system outlined in
    // the instructions

    // the possibilities are going to remain agnostic of team and will rely on order of player turn
    // instead. Player symbol is unimportant and doesn't change win strategy for our computer
    // functionally wa're making anagrams with the digits from 1-9 inclusive
    i = 1;

  }

  // optimize later
  int []palindromer(int []intake){
    int []list = intake;


    return list;
    // see if you can determine the number of palindromes that could be generated and give a progress learning bar
    // bookmark your place in learning to let the use know how much you know
  }

  // maybe pass in multiple possibilities at a time or something. You don't want to redef winConditions a million times
  int winIndex(int []possibility){
    // separate the array into every other number

    // define win conditions
    // brute force
    // optimize later
    int i;
    int firstWin = -1;  // set it to -1 for an error: the program will definitely crash

    int[][] winConditions = new int[][]{
      // horizontal win conditions
      { 3, 2, 1 },
      { 5, 4, 6 },
      { 7, 8, 9 },
      // vertical win conditions
      { 3, 9, 6 },
      { 5, 8, 2 },
      { 7, 4, 1 },
      // diagonal win conditions
      { 7, 5, 3 },
      { 5, 1, 9 },
    };

    // look at all odd numbers and see if there is a win condition

    i = 0;

    while(i < 8){
      // increment i by two, not by 1
      i += 2;
    }

    i = 1;
    while(i < 9){
      // increment i by two
      i+= 2;
    }
    // look at all even numbers and see if there is a win condition



    return firstWin;
  }

  String recurseMe(String str){
    // logical optimization; if it's length 1 then just return the string
    if(str.length() == 1){


    }

    String root;              // since Strings are objects in this language and we will need strings
                              // later, we won't use chars here
    root = str.substring(0);


    return str + something else ;
  }


  // generate possibilities, run through win conditions to trim, then put those into a file
  // (this will keep the initial file size smaller as well as keep you from using as much ram)
  //

}
*/
