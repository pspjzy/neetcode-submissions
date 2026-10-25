class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        //[1][1], left[1][0], 
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(sink(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int sink(int[][] grid, int r, int c){
        
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return 0;
        }
        if(grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;
        
        return 1 + sink(grid, r-1, c)+
        sink(grid, r+1, c)+
        sink(grid, r, c-1)+
        sink(grid, r, c+1);
    }
}
