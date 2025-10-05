import java.util.PriorityQueue;
import java.lang.Math;

class trapping_rainwater_2 {
    class Cell implements Comparable<Cell>{ 
        int row, col, height;
        Cell(int row, int col, int height){
            this.row = row;
            this.col=col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell other) {
            return this.height - other.height;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int m = heightMap.length; 
        int n = heightMap[0].length;

        if (m <= 2 || n <= 2) {
            return 0; 
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        boolean [][] vis = new boolean[m][n];

        for(int i=0;i<m;i++){
            vis[i][0] = true;
            vis[i][n-1]=true;

            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }
        for(int j=1;j<n-1;j++){ 
            vis[0][j] = true;
            vis[m-1][j] = true;

            pq.offer(new Cell(0,j,heightMap[0][j]));
            pq.offer(new Cell(m-1,j,heightMap[m-1][j]));
        }

        int[][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        int res =0, maxH =0;

        while(!pq.isEmpty()){
            Cell cell = pq.poll();

            maxH = Math.max(maxH,cell.height);
            res+=Math.max(0, maxH - cell.height); 

            for(int[] dir: dirs){
                int nr = cell.row + dir[0];
                int nc = cell.col + dir[1];

                if(nr < 0 || nr ==m || nc < 0 || nc ==n || vis[nr][nc])
                continue;

                pq.offer(new Cell(nr, nc, heightMap[nr][nc]));
                vis[nr][nc]= true; 
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        trapping_rainwater_2 solution = new trapping_rainwater_2();
        
        int[][] heightMap1 = {
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}
        };
        int result1 = solution.trapRainWater(heightMap1);
        System.out.println("Test Case 1 (Expected: 4): " + result1); 

        int[][] heightMap2 = {
            {3,3,3,3,3},
            {3,2,2,2,3},
            {3,2,1,2,3},
            {3,2,2,2,3},
            {3,3,3,3,3}
        };
        int result2 = solution.trapRainWater(heightMap2);
        System.out.println("Test Case 2 (Expected: 10): " + result2); 
    }
}
