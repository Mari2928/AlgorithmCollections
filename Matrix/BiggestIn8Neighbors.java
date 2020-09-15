/*
 * Q1: Find the points where it is the only biggest value in 8 neighbors.
 * Reflect them as a matrix graph.
 */
static boolean biggest;

public static boolean[][] BuildMatrixGraph(int[][] image) {
    int N = image.length;
    boolean[][] matrix = new boolean[N][image[0].length];    	
    int[][] plateau = new int[N][image[0].length];

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            int start = image[i][j];  
            biggest = true;
            //System.out.println("start "+ start);
            isBiggest(image, start, i, j);
            if(biggest)	{
                matrix[i][j] = true;
                //matrix[j][i] = 1;
                plateau = buildPlateau(plateau, i,  j); // plateauに適用する
            }	        	
        }
    }
    return matrix;              
}
/**
 * Q3: Build plateau for given the highest point.
 */
public static int[][] buildPlateau(int[][] plateau, int i, int j){
    for(int a = -1; a < 2; a++) {
        try {plateau[i][j+a] = 1;}
        catch(Exception e) {}	        	
        try {plateau[i-1][j+a] = 1;}
        catch(Exception e) {}
        try {plateau[i+1][j+a] = 1; }
        catch(Exception e) {}
    }    	
    return plateau;      
}  
/*
 * Q1: Bruteforce tofind the biggest node in 8 neighbors.
 */
public static void isBiggest(int[][] image, int start, int sr, int sc){     
    if(sr-1 >= 0 && sc-1 >= 0) { // naname left above
        if (image[sr-1][sc-1] >= start) {
            biggest = false; 
            return;
        }
    }
    if(sr-1 >= 0) { // above
        if (image[sr-1][sc] >= start) {
            biggest = false; 
            return;
        }
    }
    if(sr-1 >= 0 && sc+1 < image[0].length) { // naname right above
        if (image[sr-1][sc+1] >= start) {
            biggest = false; 
            return;
        }
    }
    if(sc-1 >= 0) { // left
        if (image[sr][sc-1] >= start) {
            biggest = false; 
            return;
        }
    }
    if(sc+1 < image[0].length) { // right
        if (image[sr][sc+1] >= start) {
            biggest = false; 
            return;
        }
    }

    if(sr+1 <= image.length && sc-1 >= 0) { // naname left shita
        if (image[sr+1][sc-1] >= start) {
            biggest = false; 
            return;
        }
    }
    if(sr+1 <= image.length) { // shita
        if (image[sr+1][sc] >= start) {
            biggest = false; 
            return;
        }
    }
    if(sr+1 <= image.length && sc+1 < image[0].length) { // naname right shita
        if (image[sr+1][sc+1] >= start) {
            biggest = false; 
            return;
        }
    }     
}    
