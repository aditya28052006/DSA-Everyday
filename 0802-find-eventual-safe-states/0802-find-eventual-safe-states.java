class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> rev=new ArrayList<>();
        for(int i=0;i<n;i++){
            rev.add(new ArrayList<>());
        }
        int outdegree[]=new int[n];
        for(int i=0;i<n;i++){
            outdegree[i]=graph[i].length;
            for(int v:graph[i]){
                rev.get(v).add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int parent:rev.get(node))[
                outdegree[parent]--;
                if(outdegree[parent]==0){
                    q.offer(parent);
                }
            ]
        }
        Collections.sort(ans);
        return ans;
    }
}