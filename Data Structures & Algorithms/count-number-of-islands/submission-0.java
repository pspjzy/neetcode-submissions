class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        //[1][1], left[1][0], 
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    sink(grid, i, j);
                }
            }
        }
        return res;
    }
    private void sink(char[][] grid, int r, int c){
        
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }
        if(grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        
        sink(grid, r-1, c);
        sink(grid, r+1, c);
        sink(grid, r, c-1);
        sink(grid, r, c+1);
    }
}
