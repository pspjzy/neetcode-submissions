class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 1. 把所有宝箱 (0) 的坐标加入队列，作为多源 BFS 的起点
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // 定义四个方向
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 2. 从宝箱开始向外一层一层扩散
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                // 越界，或者遇到墙壁 (-1)，或者已经访问过的格子（不是 INF），直接跳过
                if (nextR < 0 || nextC < 0 || nextR >= rows || nextC >= cols || grid[nextR][nextC] != 2147483647) {
                    continue;
                }

                // 更新邻居的距离 = 当前距离 + 1
                grid[nextR][nextC] = grid[r][c] + 1;
                // 将新格子加入队列继续扩散
                queue.offer(new int[]{nextR, nextC});
            }
        }
    }
}