package arrays;

import java.util.ArrayList;

/**
 * Created by manish on 2/11/17.
 */
public class SplitWords {


    public static void findcommonwords(String s1, String s2){


        String[] firststring = s1.split(" ");
        String[] secondstring = s2.split(" ");

        if( s1 ==null || s2 == null){
            System.out.println("empty string");
        }
        if( s1!= null || s2 != null ) {
            for(int i=0;i < firststring.length; i++) {
                boolean isCommon = false;
                for(int j=0;j<secondstring.length;j++) {
                    if(firststring[i].equalsIgnoreCase(secondstring[j])) {
                        isCommon = true;
                    }
                }
                if(!isCommon) {
                    System.out.println(firststring[i]);
                }
            }
        }
    }



    public static void main(String args[]){

        findcommonwords("### bbb ***","ddd ### eee");

    }
}
