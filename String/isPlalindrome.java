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


/*
 * Check Palindrome with stack and queue.
 */
static boolean checkPalindrome(String input) {
    Stack<Character> stack = new Stack<>();
    Queue<Character> q = new LinkedList<>();
    char[] s = input.toCharArray();
    // Enqueue/Push all chars to their respective data structures:
    for (char c : s) {
        stack.push(c);
        q.add(c);
    }

    // Pop/Dequeue the chars at the head of both data structures and compare them:
    boolean isPalindrome = true;
    for (int i = 0; i < s.length/2; i++) {
        if (stack.pop() != q.poll()) {
            isPalindrome = false;                
            break;
        }
    }
    return isPalindrome;	        
}
