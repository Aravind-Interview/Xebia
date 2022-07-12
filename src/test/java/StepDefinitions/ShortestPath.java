package StepDefinitions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

	static final int ROW = 3;
    static final int COL = 3;
    // Direction Vectors
    static int dirRow[] = { -1, 0, 1, 0 };
    static int dirCol[] = { 0, 1, 0, -1 };
    static class pointLocationation {
        int x, y, k;
        public pointLocationation(int x, int y, int k) {
            super();
            this.x = x;
            this.y = y;
            this.k = k;
        }
    };
    static class pair {
        int first, second;
        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    //BFS
    static int BFS(int matrix[][], int k, pair src, pair dest) {
        // To Store pointLocationation of each cell
        Queue<pointLocationation> q = new LinkedList<ShortestPath.pointLocationation>();
        //To store distance
        int[][] dist = new int[ROW][COL];
        // To store count
        int[][] obstacles = new int[ROW][COL];
        // Push source cell into queue
        q.add(new pointLocationation(src.first, src.second, k));
        // Run until queue is not empty
        while (!q.isEmpty()) {
            pointLocationation te = q.peek();
            int x = te.x;
            int y = te.y;
            int tk = te.k;
            //Current cell is same as destination --> return destination
            if (x == dest.first && y == dest.second)
                return dist[x][y];
            q.remove();
            //Current cell is an obstacle then decrement current value
            if (matrix[x][y] == 1) {
                if (tk > 0)
                    tk--;
                else
                    continue;
            }
            // if current value is less than previous value
            if (obstacles[x][y] >= tk)
                continue;
            obstacles[x][y] = tk;
            // Push valid adjacent cells into queue
            for (int i = 0; i < 4; i++) {
                int ax = x + dirRow[i];
                int ay = y + dirCol[i];
                if (ax < 0 || ay < 0 || ax >= ROW || ay >= COL)
                    continue;
                q.add(new pointLocationation(ax, ay, tk));
                // Update current cell distance from source
                dist[ax][ay] = dist[x][y] + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int matrix[][] = { { 0, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 } };
        int k = 2;
        pair src = new pair(0, 0);
        pair dest = new pair(2, 2);
        System.out.print("Shortest Path:  "+ BFS(matrix, k, src, dest));
    }
}
