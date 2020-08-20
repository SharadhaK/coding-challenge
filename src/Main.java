package com.kt;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(removeJoiner("👩‍💻"));
        System.out.println(removeJoiner("👨‍👩‍👧‍👦"));
        System.out.println(addJoiner("👩 💻"));
        System.out.println(addJoiner("👨 👧"));
        System.out.println(addJoiner("👨 👩 👧 👦"));


    }

    /**
     * This method adds the individual emojis supplied as form of string into a single emoji
     * @param emojis
     * @return
     */
  public static String addJoiner(String emojis){
      String bigEmoji = "";
      String[] list = emojis.split(" ");
      for(int i=0;i<list.length;i++){
          bigEmoji = bigEmoji + list[i] + "\u200D" ;
      }
        return bigEmoji;
  }

    /**
     * This method splits the compound emoji provided as a string to a list of individual emojis
     * @param emoji
     */
    public static String removeJoiner(String emoji){
        StringBuilder sb = new StringBuilder();
        String emojis = "";
        int i = 0;
        while(i <= emoji.length()) {
            if(emoji‍.codePointAt(i) == 8205){
                i++;
            }else {
                sb = new StringBuilder();
                if (Character.isValidCodePoint(emoji‍.codePointAt(i))) {
                    sb.append(Character.highSurrogate(emoji‍.codePointAt(i)));
                    sb.append(Character.lowSurrogate(emoji‍.codePointAt(i)));
                    emojis = emojis + (sb.toString()) + " ";
                }
                i = i + 2;
                }
            if(i >= emoji.length()){
                break;
            }
        }
        return emojis;
    }

}
