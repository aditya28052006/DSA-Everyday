class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> mpp=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        int j=0;
        for(int i=0;i<nums1.length;i++){
            mpp.put(nums1[i],true);
            if(j<nums2.length){
                if(mpp.containsKey(nums2[j])) {
                    set.add(nums2[j]);
                    j++;
                }
            }
            
        }
        if(j<nums2.length){
            for(int i=j;i<nums2.length;i++){
                if(mpp.containsKey(nums2[i])) set.add(nums2[i]);
            }
        }
        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
        return arr;

    }
}