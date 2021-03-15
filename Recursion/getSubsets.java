/*
 * セットの全サブセットを作る。[1,2,3] -> [3] [2] [3,2] [1] [3,1] [2,1] [3,2,1]
 * */
 
static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
    ArrayList<ArrayList<Integer>> allSubsets;

    // indexがsetと同じサイズになったら、emptySet{}足して終わり
    if(set.size() == index){
        allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<Integer>());
    }

    // otherwise 各sebsetにitemを足すのをくり返す
    else{
        allSubsets = getSubsets(set, index + 1);
        ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
        for(ArrayList<Integer> sebset : allSubsets){
            ArrayList<Integer> newSubset = new ArrayList<>();
            int item = set.get(index);
            newSubset.addAll(sebset);
            newSubset.add(item);
            moreSubsets.add(newSubset);
        }
        allSubsets.addAll(moreSubsets);
    }
    
    return allSubsets;
}

public static void main(String[] args) {		

    ArrayList<Integer> set = new ArrayList<>();
    set.add(1);
    set.add(2);
    set.add(3);    
    for(ArrayList<Integer> sebset : getSubsets(set, 0)) {
        for(Integer val : sebset)
            System.out.print(val +" ");	
        System.out.println();	
    }
}	
