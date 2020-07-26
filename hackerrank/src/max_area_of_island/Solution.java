package max_area_of_island

class Solution {
    
    private int ROW;
    private int COL;
    
    // to calculate adjacents
    private int [] X = {-1, 0, 1, 0};
    private int [] Y = {0, 1, 0, -1};
    
    private int max = 0;
    private int size = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        
        for(int i = 0; i<ROW; i++){
            for(int j = 0; j<COL; j++){
                dfs(i, j, grid);
                max = Math.max(size, max);
                size = 0;
            }
        }
        
        return max;
    }
    
    
    public void dfs(int row, int col, int [][] grid) {
        
        if(grid[row][col] == 0) return;
        
        size++;
        grid[row][col] = 0;
        
        for(int k = 0; k<4; k++){
            if((row+X[k]) > ROW-1 || (col+Y[k]) > COL-1) continue;
            if((row+X[k]) < 0 || (col+Y[k]) < 0) continue;
            dfs(row+X[k], col+Y[k], grid);
        }
    }
}