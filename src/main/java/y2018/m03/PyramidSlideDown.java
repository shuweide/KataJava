package y2018.m03;

public class PyramidSlideDown {

    public static int longestSlideDown(int[][] pyramid) {

        for (int floor = pyramid.length - 2; floor >= 0; floor--) {
            for (int num = 0; num < pyramid[floor].length; num++) {
                pyramid[floor][num] += getNextFloorMaxNumber(num, pyramid[floor + 1]);
            }
        }
        return pyramid[0][0];
    }

    private static int getNextFloorMaxNumber(int thisFloorMaxNumberIndex, int[] nextFloor) {
        return Integer.max(nextFloor[thisFloorMaxNumberIndex], nextFloor[thisFloorMaxNumberIndex + 1]);
    }
}
