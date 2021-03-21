/*
 * 文字列がpermutationか、文字カウントで判定  O(N)
 */
static boolean checkPerm2(String s, String t) {
    if(s.length() != t.length())	return false;

    int[] letters = new int[128]; // Assume ASCII

    for(int i = 0; i < s.length(); i++) // sの文字カウント増やす
        letters[s.charAt(i)]++;

    for(int i = 0; i < t.length(); i++) { // tの文字カウント減らす
        char c = t.charAt(i);
        letters[c]--;
        if(letters[c] < 0)	return false; // カウントあわない
    } 		
    return true;
}

/*
 * 文字列がpermutationか、ソートで判定  O(NlogN) 
 */
static boolean checkPerm(String s, String t) {
    if(s.length() != t.length())	return false;
    return sort(s).equals(sort(t));
}

static String sort(String s) {  
    char[] charArray = s.toCharArray();
    Arrays.sort(charArray);     // O(NlogN) 
    return new String(charArray);
}


public static void main(String[] args) {		

    System.out.println(checkPerm2("abc", "bac")); // true
}
