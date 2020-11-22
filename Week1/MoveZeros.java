package com.yuemei.okhttpsourcecode;

import org.junit.Test;

public class MoveZeros {
    @Test
    public void test(){
        int[] nums = new int[]{0,1,0,3,12};
        moveZeros(nums);
    }

    /**
     * 移动零（华为、字节跳动在近半年内面试常考）
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    private void moveZeros(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= 0){
                nums[j] = nums[i];
                if (i != j){
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}
