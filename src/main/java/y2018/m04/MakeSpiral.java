package y2018.m04;

/**
 * ###2018/04/11###
 *
 * Your task, is to create a NxN spiral with a given size.
 *
 * For example, spiral with size 5 should look like this:
 *
 * ```java
 * 00000
 * ....0
 * 000.0
 * 0...0
 * 00000
 * ```
 * and with the size 10:
 *
 * ```java
 * 0000000000
 * .........0
 * 00000000.0
 * 0......0.0
 * 0.0000.0.0
 * 0.0..0.0.0
 * 0.0....0.0
 * 0.000000.0
 * 0........0
 * 0000000000
 * ```
 * Return value should contain array of arrays, of 0 and 1, for example for given size 5 result should be:
 *
 * ```java
 * [[1,1,1,1,1],[0,0,0,0,1],[1,1,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * ```
 * Because of the edge-cases for tiny spirals, the size will be at least 5.
 *
 * General rule-of-a-thumb is, that the snake made with '1' cannot touch to itself.
 */
public class MakeSpiral {
    /**
     * ```java
     * int[][] spiral = new int[size][size];
     *
     * int x = 0, y = 0, dx = 0, dy = 1;
     * int currentRound = 1;
     * while (currentRound <= size * size) {
     *     spiral[x][y] = 1;
     *     if (hitEdge(x, y, dx, dy, size, spiral)) {
     *         //trun
     *         int t = dx;
     *         dx = dy;
     *         dy = -t;
     *
     *         if (isTwoOrOdd(size)) {
     *              if (sumNearGrid(size, spiral, x + dx, y + dy) > 2) {
     *                   break;
     *              }
     *         }
     *      }
     *      x += dx;
     *      y += dy;
     *      currentRound++;
     * }
     *
     * return spiral;
     * ```
     * @param size
     * @return
     */
    public static int[][] spiralize(int size) {

        int[][] spiral = new int[size][size];

        int x = 0, y = 0, dx = 0, dy = 1;
        int currentRound = 1;
        while (currentRound <= size * size) {
            spiral[x][y] = 1;
            if (hitEdge(x, y, dx, dy, size, spiral)) {
                //trun
                int t = dx;
                dx = dy;
                dy = -t;

                if (isTwoOrOdd(size)) {
                    if (sumNearGrid(size, spiral, x + dx, y + dy) > 2) {
                        break;
                    }
                }
            }
            x += dx;
            y += dy;
            currentRound++;
        }

        return spiral;
    }

    //calculate 3 x 3
    private static int sumNearGrid(int size, int[][] spiral, int x, int y) {
        int countOne = 0;
        for (int r = x - 1; r <= x + 1; r++) {
            for (int c = y - 1; c <= y + 1; c++) {
                if (r >= 0 && c >= 0 && r < size && c < size)
                    countOne += spiral[r][c];
            }
        }
        return countOne;
    }

    private static boolean isTwoOrOdd(int size) {
        return (size > 2 && size % 2 == 1 || size == 2);
    }

    private static boolean hitEdge(int x, int y, int dx, int dy, int size, int[][] spiral) {

        int nextX = x + dx;
        int nextY = y + dy;

        int nextXX = nextX + dx;
        int nextYY = nextY + dy;

        return nextX < 0 || nextX == size || nextY < 0 || nextY == size
                || ((nextXX < size) && (nextXX >= 0) && (nextYY < size) && (nextYY >= 0) && spiral[nextXX][nextYY] != 0);
    }
}
