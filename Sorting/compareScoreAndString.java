class Checker implements Comparator<Player> {

  	/* 
        Compare player A and player B. -> [Jones,20],[Smith,20],[Jones,15]
    */
	public int compare(Player a, Player b) {
        if(a.score > b.score) return -1;
        else if(a.score < b.score) return 1;        
        if(a.name.equals(b.name))   return 0;
        
        // same score and different name
        return compareString(a.name, b.name);
    }
    
    /*  
        Compare String A and String B. -> Jones > Smith == 1
    */
    public int compareString(String a, String b){
        int N = Math.min(a.length(), b.length());
        for(int i = 0; i < N; i++){
            if(a.charAt(i) > b.charAt(i)) 
                return 1;
            else if(a.charAt(i) < b.charAt(i)) 
                return -1;
        }
        return a.length() == N? -1 : 1;
    }
}
