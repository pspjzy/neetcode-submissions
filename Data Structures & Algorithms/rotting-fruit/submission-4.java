class Solution {
    public record Index(int row, int col){}
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Deque<Index> queue =  new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new Index(r, c));
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty() && freshCount > 0){
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                Index curr = queue.poll();
                int r = curr.row;
                int c = curr.col;
                for(int[] d: dir){
                    int nextR = r + d[0];
                    int nextC = c + d[1];
                    if(nextR<0 || nextC<0 || nextR>=rows || nextC>=cols){
                        continue;
                    }
                    if(grid[nextR][nextC] == 1){
                grid[nextR][nextC] = 2;
                freshCount--;
                queue.offer(new Index(nextR, nextC));
            }

                } 

            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
