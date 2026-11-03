class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;
        
        // 记录可以流向太平洋和大西洋的坐标
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 1. 从顶部和底部边界开始 DFS
        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific, Integer.MIN_VALUE);       // 顶部（太平洋）
            dfs(heights, m - 1, c, atlantic, Integer.MIN_VALUE); // 底部（大西洋）
        }

        // 2. 从左侧和右侧边界开始 DFS
        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific, Integer.MIN_VALUE);       // 左侧（太平洋）
            dfs(heights, r, n - 1, atlantic, Integer.MIN_VALUE); // 右侧（大西洋）
        }

        // 3. 寻找两个矩阵都为 true 的交集
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // 边界检查：越界、已经访问过、或者当前格子高度小于前一个格子（无法逆流）
        if (r < 0 || r >= m || c < 0 || c >= n || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        // 标记当前格子可以到达该海洋
        ocean[r][c] = true;

        // 四方向递归搜索（上、下、左、右）
        dfs(heights, r + 1, c, ocean, heights[r][c]);
        dfs(heights, r - 1, c, ocean, heights[r][c]);
        dfs(heights, r, c + 1, ocean, heights[r][c]);
        dfs(heights, r, c - 1, ocean, heights[r][c]);
    }
}
