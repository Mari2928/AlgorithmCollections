/*
    Check if brackets are balanced.
    {[()]} -> YES
    {[(])} -> NO
    {{[[(())]]}} -> YES
*/
static String isBalanced(String s) {
    if(s.length() % 2 == 1)   return "NO";

    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); i++){
        char c =  s.charAt(i);
        // it's a closing bracket
        if(c == '}' || c==')' || c==']'){
            if(stack.isEmpty()) return "NO"; // closing bracket only
            if(matched(stack.peek(), c)) // pair matched
                stack.pop();
            else return "NO";            // pair not matched    
        }     
        // it's an open bracket           
        else stack.push(c);                
    }
    if(stack.isEmpty()) return "YES";
    return "NO";
}

static boolean matched(char c1, char c2){
    if(c1=='(' && c2==')')  return true;
    if(c1=='[' && c2==']')  return true;
    if(c1=='{' && c2=='}')  return true;
    return false;
}
