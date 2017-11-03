class CipherWheel{

  int innerStart;
  int middleStart;
  int outerStart;

  int whichInner;
  int whichMiddle;
  int whichOuter;

  // you pass in 1 indexxed, but you get out zero indexxed
  CipherWheel(int whichInner, int whichMiddle, int whichOuter, int innerStart, int middleStart, int outerStart){
    this.whichInner = whichInner-1;
    this.whichMiddle = whichMiddle-1;
    this.whichOuter = whichOuter-1;
    // keep zero indexxing
    this.innerStart = innerStart-1;
    this.middleStart = middleStart-1;
    this.outerStart = outerStart-1;
    rotateSets();
  }

  Ciphers CList = new Ciphers();

  // define cipher rings for the rotors
  String innerWheel = CList.getCipher(this.whichInner);       // inner
  String middleWheel = CList.getCipher(this.whichMiddle);     // middle
  String outerWheel = CList.getCipher(this.whichOuter);       // outer

  // make extra garbage to make debugging easier
  int wheelSize = innerWheel.length();

  void rotateInner(){
    String lastChar = innerWheel.substring(wheelSize-1, wheelSize);
    String allButLast = innerWheel.substring(0, wheelSize);
    this.innerWheel = lastChar + allButLast;
  }

  void rotateMiddle(){
    String lastChar = innerWheel.substring(wheelSize, wheelSize + 1);
    String allButLast = innerWheel.substring(0, wheelSize);
    this.innerWheel = lastChar + allButLast;
  }

  void rotateOuter(){
    String lastChar = innerWheel.substring(wheelSize, wheelSize + 1);
    String allButLast = innerWheel.substring(0, wheelSize);
    this.innerWheel = lastChar + allButLast;
  }

  // only used when setting strings, within rotateSets (plural)
  private String rotateSet(String wheel, int start){
    String s2 = wheel.substring(0, start);
    String s1 = wheel.substring(start, wheelSize);
    wheel = s1 + s2;

    return wheel;
  }

  // rotate all sets
  private void rotateSets(){
    innerWheel = rotateSet(innerWheel, innerStart);
    middleWheel = rotateSet(middleWheel, middleStart);
    outerWheel = rotateSet(outerWheel, outerStart);
  }

  // String ch in String wheel
  int indexOfMatch(String ch, String wheel){
    // ch is a single char, and settings are the full reflector panel, alpha*2
    if(ch.length() != 1){
      System.out.println();
      System.out.println("ARGUMENT ERROR");
      System.out.println();
    }

    int i;

    i = 0;
    while(i < wheel.length()){
      // if the char passed in matches the char at the given index
      if(ch.substring(0,1).equals(wheel.substring(i,i+1))){
        return i;
      }
      i++;
    }

    // there wasn't any matching index of char foun
    return -1;
  }

  //TODO make this for an entire String, not just a char
  // add arge, tie this class together by making this function appropriately
  String encrypt(String cryptMe, String plugboardSettings, String reflectorSettings){
    // Create plugboard and reflector panel
    ReflectorPanel Mirror = new ReflectorPanel(reflectorSettings);
    PlugBoard PlugB = new PlugBoard(plugboardSettings);
    cryptMe = cryptMe.toUpperCase();
    String returnMe = "";
    int i;
    int oTime;
    i = 0;
    oTime = 0;

    System.out.println(cryptMe);
    while(i < cryptMe.length()) {
      String tStr = "";
      int tInt;

      // Step 1 PlugBoard
      tStr = PlugB.translate(cryptMe.substring(i, i+1));

      // Step 2 CipherWheel
      // find char on inner rotor
      tInt = indexOfMatch(tStr, this.innerWheel);
      // note char aligned on outer rotor
      if(tInt != -1) {
        tStr = outerWheel.substring(tInt, tInt + 1);
      }
      // find char on middle rotor
      tInt = indexOfMatch(tStr, this.middleWheel);
      // output aligned on outer rotor
      if(tInt != -1){
        tStr = outerWheel.substring(tInt, tInt + 1);
      }

      // Step 3 ReflectorPanel
      tStr = Mirror.reflect(tStr);

      // Step 4 Reverse Cipher Wheel
      tInt = indexOfMatch(tStr, outerWheel);
      if(tInt != -1){
        tStr = middleWheel.substring(tInt, tInt+1);
      }
      tInt = indexOfMatch(tStr, outerWheel);
      if(tInt != -1){
        tStr = innerWheel.substring(tInt, tInt+1);
      }

      // Step 5 Plugboard Again
      tStr = PlugB.translate(tStr);

      // Append String
      returnMe += tStr;

      // Rotate inner wheel
      if(i > 0 && oTime == 27) {
        rotateOuter();
        oTime = 0;
      } else if(i > 0 && i % 27 == 0) {
        rotateMiddle();
        oTime++;
      } else
        rotateInner();

      // Continue through String
      i++;
    }

    System.out.println("Returning " + returnMe);
    return returnMe;
  }

  //TODO
  // you may need to make this one into a string
  void decrypt(){

  }

}
