package com.home.test;

class Solution {

    public static void main(String a[]) {
        System.out.println(new Solution().rob(new int[]{1,2,1,1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length==2) return Math.max(nums[0], nums[1]);
        return Math.max(firstHouse(nums), lastHouse(nums));
    }

    public int firstHouse(int[] nums) {
        int[] dp = new int[nums.length-1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
    public int lastHouse(int[] nums) {
        int[] dp = new int[nums.length];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}