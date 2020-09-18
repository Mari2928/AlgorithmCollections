/*
    Find the number of common chars in all strings.
    abcdde
    baccd
    eeabg   
    Output: 2 (only a and b are common)
*/
static int gemstones(String[] arr) {

    ArrayList<Character> bag = new ArrayList<>();
    ArrayList<Character> bag2 = new ArrayList<>();
    int count = 0;
    for(int i = 0; i < arr[0].length(); i++){
        bag.add(arr[0].charAt(i));
    }
    // start comparing
    for(int i = 1; i < arr.length; i++){
        String s = arr[i];
        for(int a = 0; a < s.length(); a++){
            if(bag.contains(s.charAt(a))){
                bag2.add(s.charAt(a));
                int pos = bag.indexOf(s.charAt(a));
                bag.remove(pos);
            }                
        }
        bag.clear();
        for(int a = 0; a < bag2.size(); a++){
            bag.add(bag2.get(a));
        }            
        bag2.clear();          
    }
    return bag.size();

}
