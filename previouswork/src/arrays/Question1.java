package arrays;

import java.util.List;
import java.util.Stack;

/**
 * Created by manish on 2/4/17.
 */
public class Question1 {

    public static void main(String[] args){
        String[] blocks = {};
      System.out.println(  totalScore(blocks, 0));
    }

    public static int totalScore(String blocks[], int n){
        int[] sum = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        try {
            if(blocks == null || blocks.length == 0) {
                return 0;
            }
            sum[0] = Integer.valueOf(blocks[0]);
        }
        catch(NumberFormatException e) {
            sum[0] = 0;
        }
        stack.push(sum[0]);
        for(int i=1;i<n;i++){
            if(blocks[i].equals("Z")) {
                sum[i] = sum[i-1] - stack.pop();
            } else if(blocks[i].equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                sum[i] = sum[i-1] + (first+second);
                stack.push(second);
                stack.push(first);
                stack.push(first+second);
            } else if(blocks[i].equals("X")) {
                int doub = 2*stack.pop();
                sum[i] = sum[i-1] + doub;
                stack.push(doub);
            } else {
                sum[i] = sum[i-1] + Integer.valueOf(blocks[i]);
                stack.push(Integer.valueOf(blocks[i]));
            }
        }
        return sum[n-1];
    }
}
