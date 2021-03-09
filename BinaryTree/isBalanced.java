/*
    木がバランスとれているか判定する ->　左右の木の高さの差が１以上あるならfalse
*/

static boolean isBalanced(Node root) {
    return checkHeight(root) != Integer.MIN_VALUE; // -1のエラーコードは使用済みのためこれを使う
}

static int checkHeight(Node root) {
    if(root == null)	return -1;　// n = 1の時、-1+1 = 0　になる

    int leftHeight = checkHeight(root.left);
    if(leftHeight == Integer.MIN_VALUE)	return Integer.MIN_VALUE;

    int rightHeight = checkHeight(root.right);
    if(rightHeight == Integer.MIN_VALUE)	return Integer.MIN_VALUE;

    int heightDif = Math.abs(leftHeight - rightHeight);
    if(heightDif > 1)	return Integer.MIN_VALUE; 
    return Math.max(leftHeight, rightHeight) + 1;
}
