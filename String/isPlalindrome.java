/*
    Replace middle chars and check plalindrome.
*/
static String solve(int N, String str){
    if(isPlalindrome(str)) return "YES";    
    char temp = str.charAt(N/2);
    char temp1 = str.charAt(N/2-1);
    str = str.replace(temp, temp1);
    if(isPlalindrome(str)) return "YES";
    return "NO";      
}

static boolean isPlalindrome(String s){
    String reverse = new StringBuffer(s).reverse().toString(); 		  
    // check whether the string is plalindrome or not 
    if (s.equals(reverse))  return true; 
    else	return false;	      
}
