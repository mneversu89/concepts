package arrays;

import java.util.Scanner;

/**
 * Created by manish on 2/11/17.
 */
public class KSub {

    static long kSub(int s, int[] nums) {
        long value = kSub(s, nums, 0, nums.length,0);
        System.out.println(value);
        return value;
    }

    static long kSub(int s, int[] nums, int startIndex, int endIndex, int subSetsCount) {
        if(startIndex == endIndex) {
            return subSetsCount;
        }
        for(int i= startIndex;i<endIndex;i++) {
            if(getSum(startIndex, i+1, nums) % s == 0) {
                subSetsCount +=1;
            }
        }

        return kSub(s, nums,startIndex+1, endIndex, subSetsCount);
    }

    private static int getSum(int startIndex, int endIndex, int[] num) {
        int sum = 0;
        for(int i=startIndex;i<endIndex;i++) {
            sum = sum + num[i];
        }
        return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        System.out.println(numberOfTestCases);
        for(int i =0;i< numberOfTestCases;i++) {
            if(sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                String[] nKValue = line.split(" ");
                int n = Integer.parseInt(nKValue[0]);
                System.out.println("N value" + n);
                int k = Integer.parseInt(nKValue[1]);
                System.out.println("kavlue=" + k);
                String[] values = sc.nextLine().split(" ");
                int[] intValues = new int[values.length];
                for (int j = 0; j < values.length; i++) {
                    intValues[j] = Integer.parseInt(values[j]);
                }
                System.out.println(kSub(k, intValues));
            }

        }
    }
}
