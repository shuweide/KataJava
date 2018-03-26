package y2018.m03;

/**
 * ### 2018/03/26
 *
 * You live in the city of Cartesia where all roads are laid out in a perfect grid.
 * You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk.
 * The city provides its citizens with a Walk Generating App on their phones --
 * everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']).
 * You know it takes you one minute to traverse one city block, so create a function that will return true
 * if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!) and will,
 * of course, return you to your starting point. Return false otherwise.
 *
 * Note: you will always receive a valid array containing a random assortment of direction letters ('n', 's', 'e', or 'w' only).
 * It will never give you an empty array (that's not a walk, that's standing still!).
 */
public class TenMinWalk {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValid(char[] walk) {
        if (walk.length != 10)
            return false;

        Point point = new Point(0, 0);
        for (int i = 0; i < walk.length; i++) {
            point.x += walk[i] == 'e' ? 1 : walk[i] == 'w' ? -1 : 0;
            point.y += walk[i] == 'n' ? 1 : walk[i] == 's' ? -1 : 0;
        }
        return point.x == 0 & point.y == 0;
    }
}
