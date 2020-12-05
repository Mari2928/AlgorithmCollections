/* 
    Get Max value of the current stack in O(1).
    Input: 1, 6, 3, 4, 5
    st: [(1, 1), (6, 6), (3, 6) (4, 6), (5, 6)]
*/

// let each element have max value in the moment
StackElement {
  int value;
  int maxValue;
}

Stack {
  push(int value) {
    int maxValue = (st.empty() || st.pop().maxValue < value) ? value : st.pop().maxValue;
    st.push(new StackElement{value, maxValue});
  }

  pop() {
    st.pop();
  }

  getMax() {
    return st.pop().maxValue;
  }

  List<StackElement> st = new List<>();
}
