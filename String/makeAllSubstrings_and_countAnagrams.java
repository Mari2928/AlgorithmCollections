/* 
    Count anagrams in all the list of substrings: abba -> 4 
*/
static int sherlockAndAnagrams(String s) {
    ArrayList<String> anagL = new ArrayList<>(); 
    int subLen = 1;
    int count = 0;

    // make possible substrings of length from 1 
    while(subLen < s.length()){ 
        for(int j = 0; j + subLen <= s.length(); j++){
            String str = s.substring(j, j + subLen);
            anagL.add(str); // [a,b,b,a] -> [ab,bb,ba]-> [abb,bba]
        }                   
        count += countAnagram(anagL);
        anagL.clear();
        subLen++;
    } 
    return count;
}

/* 
    Count anagrams in a list: [ab,bb,ba] -> 2
*/
static int countAnagram(ArrayList<String> L){
    int count = 0;
    for(int i = 0; i < L.size(); i++){
        for(int j = i+1; j < L.size(); j++){
            if(areAnagrams(L.get(i), L.get(j)))  count++;
        }
    } 
    return count;       
}

/*
    Check if strings are anagrams: ab, ba -> true
*/
static boolean areAnagrams(String a, String b) {
    char[] a1 = a.toCharArray();
    char[] b1 = b.toCharArray();
    int n1 = a1.length; 
    int n2 = b1.length; 

    if (n1 != n2) {return false; }

    Arrays.sort(a1); 
    Arrays.sort(b1); 

    // Compare sorted strings 
    for (int i = 0; i < n1; i++) {
        if (a1[i] != b1[i]) {return false; }                
    }           
    return true;
}
