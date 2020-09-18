/*
    Sort each row and see if column is ordered.
    abc
    ade
    efg
    Output: YES
*/
static String gridChallenge(String[] grid) {
    int N = grid.length;
    int M = grid[0].length();
    char[][] newG = new char[N][M];
    for(int i = 0; i < N; i++){
        String s = grid[i];
        char tempArray[] = s.toCharArray();           
        Arrays.sort(tempArray); 
        newG[i] = tempArray; 
    }
    for(int i = 0; i < M; i++){
        char tempArray[] = new char[N];
        for(int j = 0; j < N; j++){                
            tempArray[j] = newG[j][i];                
        }
        String s1 = new String(tempArray);
        Arrays.sort(tempArray);
        String s2 = new String(tempArray);            
        if(!s1.equals(s2)) return "NO";
    }
    return "YES";

}
