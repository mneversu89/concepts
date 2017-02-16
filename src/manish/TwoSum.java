package manish;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by manish on 2/13/17.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 */


public class TwoSum {
    //Brute force way O(n2)
    public int[] twoSum(int[] nums, int target) throws Exception{
        if(Objects.isNull(nums)) {
            throw new Exception("nums array cannot be null");
        }
        if(nums.length == 0 || nums.length == 1) {
            return new int[0];
        }

        for(int indexI=0;indexI<nums.length;indexI++) {
            int otherNumber = target - nums[indexI];
            for(int indexJ=indexI+1; indexJ<nums.length; indexJ++) {
                if(nums[indexJ] == otherNumber) {
                    return new int[]{indexI, indexJ};
                }
            }
        }
        return new int[0];
    }

    //O(n)
    public int[] twoSum2(int[] nums, int target) throws Exception {
        if (Objects.isNull(nums)) {
            throw new Exception("nums array cannot be null");
        }
        if (nums.length == 0 || nums.length == 1) {
            return new int[0];
        }

        final HashMap<Integer, Integer> map= new HashMap<>();
        for(int indexI=0;indexI<nums.length;indexI++) {
            int otherNumber = target - nums[indexI];
            if(map.containsKey(otherNumber)) {
                return new int[]{indexI, map.get(otherNumber)};
            }
            map.put(nums[indexI],indexI);
        }
        return new int[0];
    }

    public static void main(String args[]) throws Exception{
        TwoSum twoSum = new TwoSum();
        int[] test1= {3,2,4};
        int test1Target = 6;

        int[] solution = twoSum.twoSum(test1, test1Target);
        for(int i=0;i<solution.length;i++) {
            System.out.println(solution[i]);
        }
    }
}
