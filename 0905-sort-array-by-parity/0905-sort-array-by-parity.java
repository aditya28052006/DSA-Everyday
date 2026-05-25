class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j=nums.length-1;
        int i=0;
        while(i<=j){
            if(nums[j]%2==0){
                if(nums[i]%2!=0){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j--;
                }
                i++;
                
            }
            else if(nums[i]%2!=0){
                if(nums[j]==0){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    i++;
                }
                j--;
            }
            else{
                i++;
                j--;
            }
        }
        return nums;
    }
}