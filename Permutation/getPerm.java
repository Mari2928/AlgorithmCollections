/*
    ユニークcharの文字のpermutationを再帰で出力 -> CCI P.355
    Input: abc: 
    abc
    bac
    bca
    acb
    cab
    cba
*/

static ArrayList<String> getPerm(String str){
    if(str == null)	return null;
    ArrayList<String> permutations = new ArrayList<>();

    if(str.length() == 0) {
        permutations.add("");
        return permutations;
    }

    char firstChar = str.charAt(0);
    String reminder = str.substring(1);
    ArrayList<String> words = getPerm(reminder);
    for(String word : words) {
        for(int i = 0; i <= word.length(); i++) {
            String s = insertCharAt(word, firstChar, i);
            permutations.add(s);    			
        }
    }
    return permutations;
}

/*
    charをwordのi番目に挿入
*/
static String insertCharAt(String word, char c, int i) {
    return word.substring(0, i) + c + word.substring(i);
}

public static void main(String[] args) {	

    for(String word : getPerm("abc"))
        System.out.println(word); 
}	
