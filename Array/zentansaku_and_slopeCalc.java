/*
 * 全探索とスロープ計算 : Find the number of pairs that its slope of two points is >= -1 and < 1.
 * Input: N = 3
 * 0 0
 * 1 2
 * 2 1
 * Output: 2 (slope of each point is 2, 0.5, and -1)
 */
static int gentlePairs(int N, int[][] p) {
    int count = 0;
    for(int i = 0; i < N-1; i++) {
        for(int j = i+1; j < N; j++) {
            double slope = calcSlope(p[i], p[j]);
            if(slope >= -1 && slope < 1) count++;
        }
    }
    return count;
}

static double calcSlope(int[] p1, int[] p2) {
    return (p2[1] - p1[1]) / (p2[0] - p1[0]);
}
