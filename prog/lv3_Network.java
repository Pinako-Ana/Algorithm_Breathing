package prog;

import java.util.*;
class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i= 0; i< n; i++)
            answer += bfs(i, computers);
        return answer;
    }
    private static int bfs(int x, int[][] arr){
        Queue<Integer> mq = new LinkedList<>();
        if(visit[x]) return 0;
        else{
            visit[x] = true;
            mq.offer(x);
            while(!mq.isEmpty()){
                int cur = mq.poll();
                for(int i = 0; i < arr.length; i++){
                    if(!visit[i] && arr[cur][i] == 1){
                        mq.offer(i);
                        visit[i] = true;
                    }
                }
            }
            return 1;
        }
    }
}