// TODO
// there are hardcoded rules for periods and spaces
// you shouldn't make any rules to change the reflector; it should remain static

class ReflectorPanel{

  String settings;

  ReflectorPanel(String settings){
    this.settings = settings;
  }
  // Make extra garbage to be overly clear. Optimize later when you run out of bugs to fix.
  private boolean forward = true;
  private boolean backward = false;

  // relevant if it's best to set reflector settings within this class
  // otherwise, it's irrelevant
  // void setReflector();

  int indexOfMatch(String ch, String settings){
    // ch is a single char, and settings are the full reflector panel, alpha*2
    if(ch.length() != 1){
      System.out.println();
      System.out.println("ARGUMENT ERROR");
      System.out.println();
    }

    int i;

    i = 0;
    while(i < settings.length()){
      // if the char passed in matches the chara at the given index
      //System.out.println(ch.substring(0,1) + settings.substring(i, i+1));
      // even when these are equal, it won't work gg I'm done
      // Ｄｒ. Ｂｕｓｈｅｙ                                         :  ^)   pls end me
      // exact same method works perfectly in other classes reeeeeeeeeeeeeeeee
      if(ch.substring(0,1).equals(settings.substring(i,i+1)))
        return i;
      i++;
    }

    // there wasn't any matching index of char found
    return -1;
  }

  String reflect(String ch) {
    int ind = indexOfMatch(ch, this.settings);
    String returnMe;
    if(ind % 2 == 1) {
      returnMe = reflectBkwd(ch);
    }
    else {
      returnMe = reflectFwd(ch);
    }
    //System.out.println("Received " + ch + " outputting " + );
    return returnMe;
  }
  /*
  // big O(n)                        :   ^)
  int indexOfMatch(String ch, String settings, boolean forward){
  // ch is a single char, and settings are the full reflector panel, alpha*2
    if(ch.length() != 1){
      System.out.println();
      System.out.println("ARGUMENT ERROR");
      System.out.println();
    }

    int i;

    if(forward){
      i = 0;
      while(i < settings.length()){
        // if the char passed in matches the chara at the given index
        if(ch.substring(0,1) == settings.substring(i,i+1))
          return i;
        i+=2;
      }
    }

    // otherwise, we are travelling in reverse
    else{
      i = settings.length()-1;
      while(i > -1){
        // if the char passed in matches the chara at the given index
        if(ch.substring(0,1) == settings.substring(i,i+1))
          return i;
        i-=2;
      }
    }

    // there wasn't any matching index of char found
    return -1;
  }
  */

  // define reflectos panel settings somewhere. Pulled from Ciphers?
  String reflectFwd(String ch){
    // make this the first thing in the method, otherwise indexOfMatch may not work
    int match = indexOfMatch(ch, this.settings);
    if(ch.length() != 1){
      return "~";
    }
    // now you can continue
    else{
      if(match > -1){ // if you go out of bounds
        // return the character after the said match in the reflector, to "reflect" forward
        if(settings.length() < match+1)
          return settings.substring(0,1);
        return settings.substring(match+1, match+2);
      }
    }
    // if found index is -1, it doesn't get translated at all
    System.out.println("nope" + match);
    return ch;
  }

  String reflectBkwd(String ch){
    // make this the first thing in the method, otherwise indexOfMatch may not work
    int match = indexOfMatch(ch, settings);
    if(ch.length() != 1){
      return "~";
    }
    // now you can continue
    else{
      if(match > -1){
        // return the character before the said match in the reflector, to "reflect" backward
        return settings.substring(match-1, match);
      }
    }
    // if found index is -1, it doesn't get translated at all
    // you used relative conditions which were probably a mistake, but scope is small and hurry
    System.out.println("nope" + match);
    return ch;
  }
}

