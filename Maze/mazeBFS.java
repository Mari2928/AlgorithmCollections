"""
スタートからゴールまでの最短手（例は将棋のコマのように凹の字に進む）

STDIN       FUNCTION
-----       --------
3           grid[] size n = 3
.X.         grid = ['.X.','.X.', '...']
.X.
...
0 0 0 2     startX = 0, startY = 0, goalX = 0, goalY = 2
    
"""
    
    static class Cell{
        int x;
        int y;
        int dist;
        Cell(int x,int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        boolean[][] visited = new boolean[n][n];
        Queue<Cell> q = new ArrayDeque<>();
        q.add(new Cell(startX, startY, 0));
        while(!q.isEmpty()){
            Cell cell = q.remove();
            int x = cell.x;
            int y = cell.y;
            int dist = cell.dist;
            
            if(x == goalX && y == goalY)    return dist;
            // down
            for(int i = x; i < n && grid.get(i).charAt(y) != 'X'; i++){
                if(!visited[i][y]){
                    System.out.println(i +" " +y +" "+ dist);
                    q.add(new Cell(i, y, dist+1));
                    visited[i][y] = true;
                }
            }
            //up
            for(int i = x; i >= 0 && grid.get(i).charAt(y) != 'X'; i--){
                if(!visited[i][y]){
                    q.add(new Cell(i, y, dist+1));
                    visited[i][y] = true;
                }                
            }
            //right
            for(int i = y; i < n && grid.get(x).charAt(i) != 'X'; i++){
                if(!visited[x][i]){
                    q.add(new Cell(x, i, dist+1));
                    visited[x][i] = true;
                }                
            }
            //left
            for(int i = y; i>= 0 && grid.get(x).charAt(i) != 'X'; i--){
                if(!visited[x][i]){
                    q.add(new Cell(x, i, dist+1));
                    visited[x][i] = true;
                }                
            }
        }
        return -1;
    }
