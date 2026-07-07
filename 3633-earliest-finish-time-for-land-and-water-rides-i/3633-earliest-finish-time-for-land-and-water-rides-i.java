class Solution {
    public int earliestFinishTime(int[] landStart, int[] landDuration, int[] waterStart, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStart.length; i++) {
            for (int j = 0; j < waterStart.length; j++) {

                // Land -> Water
                int landFinish = landStart[i] + landDuration[i];
                int waterBegin = Math.max(landFinish, waterStart[j]);
                int finish1 = waterBegin + waterDuration[j];

                // Water -> Land
                int waterFinish = waterStart[j] + waterDuration[j];
                int landBegin = Math.max(waterFinish, landStart[i]);
                int finish2 = landBegin + landDuration[i];

                ans = Math.min(ans, Math.min(finish1, finish2));
            }
        }

        return ans;
    }
}