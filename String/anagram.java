/*
 * Find a minimum number of change to make anagram
 */
static int makeAnagram(String s1, String s2) {    
    // make a list2 contains s2   
    ArrayList<Character> list2 = new ArrayList<>();
    for(int i = 0; i < s2.length(); i++){
        list2.add(s2.charAt(i));
    }     
    ArrayList<Character> list1 = new ArrayList<>();// list1 for s1
    for(int i = 0; i < s1.length(); i++){         // go through s1
        if(list2.contains(s1.charAt(i))){// add to list1 only if list2 contains
            list1.add(s1.charAt(i));
            int pos = list2.indexOf(s1.charAt(i));
            list2.remove(pos);  // remove from list2
        }
    }
    return s1.length()-list1.size();
}

/*
 * Check if two strings are anagrams
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
