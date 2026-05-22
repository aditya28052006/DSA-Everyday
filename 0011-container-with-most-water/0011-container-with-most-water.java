class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxStoredWater=0;

        while(left<right){
            int h=Math.min(height[left],height[right]);
            int width=right-left;
            int area=width*h;
            maxStoredWater=Math.max(area,maxStoredWater);

            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxStoredWater;
    }
}