package com.yuemei.okhttpsourcecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    @Test
    public void test(){
        int [] nums = new int[]{2, 7, 11, 15};
        int[] towSum = towSum(nums, 18);
        arryPrint(towSum);

        arryPrint(towSum2(nums,18));
    }

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int [] towSum(int []nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * hash表法
     * @param nums
     * @param target
     * @return
     */
    public int [] towSum2(int []nums,int target){
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    private void arryPrint(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.println(nums[i] + "]");
            }
        }
    }
}
