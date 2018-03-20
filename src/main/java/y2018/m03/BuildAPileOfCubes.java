package y2018.m03;

/**
 * ### 2017/03/20
 *
 * Your task is to construct a building which will be a pile of n cubes. The cube at the bottom will have a volume of n^3,
 * the cube above will have volume of (n-1)^3 and so on until the top which will have a volume of 1^3.
 *
 * You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?
 *
 * The parameter of the function findNb (find_nb, find-nb, findNb) will be an integer m and you have to
 * return the integer n such as **n^3 + (n-1)^3 + ... + 1^3 = m** if such a n exists or -1 if there is no such n.
 *
 * **Examples:**
 * ```java
 * findNb(1071225) --> 45
 * findNb(91716553919377) --> -1
 * ```
 */
public class BuildAPileOfCubes {
    /**
     * ```java
     * int n = 0;
     * while (m > 0) {
     *      m = m - (long) Math.pow(++n, 3);
     * }
     * return m == 0 ? n : -1;
     * ```
     * @param m
     * @return
     */
    public static long findNb(long m) {
        int n = 0;
        while (m > 0) {
            m = m - (long) Math.pow(++n, 3);
        }
        return m == 0 ? n : -1;
    }

    /**
     * ```java
     * long mm = 0, n = 0;
     * while (mm < m) mm += ++n * n * n;
     * return mm == m ? n : -1;
     * ```
     * @param m
     * @return
     */
    public static long findNbBest(long m) {
        long mm = 0, n = 0;
        while (mm < m) mm += ++n * n * n;
        return mm == m ? n : -1;
    }
}
