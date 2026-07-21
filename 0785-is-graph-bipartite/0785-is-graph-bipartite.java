class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int col[]=new int[n];
        Arrays.fill(col,-1);
        for(int i=0;i<n;i++){
            if(col[i]==-1){
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int adj:graph[node]){
                        if(col[adj]==-1){
                            col[adj]=1-col[node];
                            q.offer(adj);
                        }
                        else if(col[adj]==col[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}