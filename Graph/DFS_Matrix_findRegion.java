/*
    Find max region in the grid.
    1 1 0 0
    0 1 1 0
    0 0 1 0
    1 0 0 0 -> Output: 5
*/

static int region;
static int[][] g;

static int maxRegion(int[][] grid) {
    if(grid.length == 0) return 0;
    g = grid;
    int maxRegion = 0;
    for(int i = 0; i < g.length; i++){
        for(int j = 0; j < g[0].length; j++){
            if(g[i][j] == 1){
                region = 0;                    
                findRegion_DFS(i, j);                    
            }                        
            if(region > maxRegion) 
                maxRegion = region;          
        }
    }
    return maxRegion;
}

/*
    DFS to recursively increment the region.
*/
static void findRegion_DFS(int i, int j){
    // stop: out of grid or no more connected region
    if(i >= g.length || i < 0)    return;
    if(j >= g[0].length || j < 0) return;
    if(g[i][j] == 0)              return;

    region++;
    g[i][j] = 0; // flip visited state

    // recur 8 directions from current place
    findRegion_DFS(i+1, j); // below
    findRegion_DFS(i, j+1); // right
    findRegion_DFS(i, j-1); // left
    findRegion_DFS(i-1, j); // above
    findRegion_DFS(i-1, j-1); // naname topleft
    findRegion_DFS(i-1, j+1); // naname topright
    findRegion_DFS(i+1, j-1); // naname bottomleft
    findRegion_DFS(i+1, j+1); // naname bottomright
}
