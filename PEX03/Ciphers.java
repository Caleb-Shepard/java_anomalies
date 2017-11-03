import java.util.ArrayList;

// somewhat static class that defines ciphers
// this keeps us from running into scope problems when rotating in local wheels
class Ciphers{

  // Strings aren't char arrays in Java ¯\(°_o)/¯
  private ArrayList<String> cipherList = new ArrayList<String>(){{
    add("AUNGHOVBIPWCJQXDKRY ELSZFMT.");
    add("O J.ETYCHMRWAFKPUZDINSXBGLQV");
    add("FBDHJLNPRTVXZ.ACEGI KMOQSUWY");
    add(".HKPDEAC WTVQMYNLXSURZOJFBGI");
    add("YDNGLCIQVEZRPTAOXWBMJSUH.K F");
  }};

  String getCipher(int num/*, int start*/){
    if(num > 4)
      return "~";
    if(num < 0)
      return "~";

    return cipherList.get(num);
  }
}

