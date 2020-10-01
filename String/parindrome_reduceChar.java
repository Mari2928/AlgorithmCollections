/*
    Reduce char by one to make a palindrome and return the min number of operation.
    abc
    abcba
    abcd
    cba     Output: 2, 0, 4, 2
*/

static int theLoveLetterMystery(String s) {
    if(isPlalindrome(s)) return 0;
    int count = 0;        
    char[] charArr = s.toCharArray();

    // look at the chars from leftside and from rightside together toward the middle
    int j = 0;
    for(int i = charArr.length-1; i >= 0; i--){           
        while(charArr[j] != charArr[i]){
            if(charArr[j] < charArr[i]){
                charArr[i] = (char)(charArr[i] - 1);
            }
            else{
                charArr[j] = (char)(charArr[j] - 1);
            }                
            count++;   
        }
        s = String.valueOf(charArr);
        if(isPlalindrome(s))    return count; 
        j++;
    }
    return -1;
}

static boolean isPlalindrome(String s){
    String reverse = new StringBuffer(s).reverse().toString(); 
    // check whether the string is plalindrome or not 
    if (s.equals(reverse))  return true; 
    else    return false;          
}
