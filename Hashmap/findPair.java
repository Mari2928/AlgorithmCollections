/*  
    Find a pair of flavors matches the budget.
    1 4 5 3 2   Output: 1 4
    2 2 4 3     Output: 1 2
*/

static void whatFlavors(int[] cost, int money) {
    HashMap<Integer,Integer> T = new HashMap<>();
    for(int i = 0; i < cost.length; i++){ // put values in a table
        T.put(cost[i], i+1);            
    }
    for(int i = 0; i < cost.length; i++){ // search for the rest
        int rest = money - cost[i];
        int id = i+1;
        T.remove(cost[i], id);
        if(T.containsKey(rest)){
            System.out.println(id + " " + T.get(rest)); // print the positions
            return;
        }
    }
}
