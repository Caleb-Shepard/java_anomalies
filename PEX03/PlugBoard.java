// TODO
// the goal is to call transpose, which runs plugboard ops on the string

class PlugBoard{

  String settings;

  PlugBoard(String settings){
    this.settings = settings;
  }
  // args passed from user become plugboard settings

  boolean forward = true;
  boolean backward = false;

  // relevant if it's best to set reflector settings within this class
  // otherwise, it's irrelevant

  // big O(n)                        :   ^)
  // like the one in reflector except that we search for matches anywhere
  int indexOfMatch(String ch){
  // ch is a single char, and settings are the full reflector panel, alpha*2
    if(ch.length() != 1){
      System.out.println();
      System.out.println("ARGUMENT ERROR");
      System.out.println();
    }

    int i;

    i = 0;
    while(i < settings.length()){
      // if the char passed in matches the char at the given index
      if(ch.substring(0,1).equals(settings.substring(i,i+1))){
        return i;
      }
      i++;
    }

        // there wasn't any matching index of char foun
    return -1;
  }

  // define reflectors panel settings somewhere. Pulled from Ciphers?
  String translate(String ch){
    // make this the first thing in the method, otherwise indexOfMatch may not work
    if(ch.length() != 1){
      return "~";
    }
    // now you can continue
    else{
      int match = indexOfMatch(ch);
      // if found index is -1, it doesn't get translated at all
      if(match == -1)
        return ch;
      // if the number is odd, then return the previous char
      if(match % 2 == 1) {
        return settings.substring(match - 1, match);
      }
      else {
        return settings.substring(match + 1, match + 2);
      }
    }
  }

}
