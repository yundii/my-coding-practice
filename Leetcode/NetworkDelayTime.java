// 743. Network Delay Time
import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k){
        // step1: build adjList for graph
       List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: times) {
            int src = edge[0], target = edge[1], weight = edge[2];
            adjList.get(src-1).add(new int[]{target-1, weight});
        }

        // step2: initialize priority queue
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        };
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        minHeap.add(new int[]{k-1, 0});
        // step3: distance list to store the shortest path to each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currNode = curr[0], time = curr[1];
            if (time > dist[currNode]) continue;

            for (int[] neighbor: adjList.get(currNode)) {
                int nextNode = neighbor[0], newTime = neighbor[1]+time;
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    minHeap.add(new int[]{nextNode, newTime});
                }
            }
            
        }
        // get the max value in dist list
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;


    }

    // time complexity: O(ElogV)
    // space complexity: O(V+E)


}
