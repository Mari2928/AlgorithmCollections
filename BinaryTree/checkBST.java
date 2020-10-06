/*
    Check if the tree is BST: 
*/

boolean checkBST(Node root) {
    return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);        
}

boolean checkBST2(Node root, int min, int max){
    if(root == null)   return true;
    if(root.data <= min || root.data >= max) return false;  // data must be less/greater than max/min
    return checkBST2(root.left, min, root.data) && checkBST2(root.right, root.data, max);
}
