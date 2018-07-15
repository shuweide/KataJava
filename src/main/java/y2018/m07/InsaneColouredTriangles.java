package y2018.m07;

public class InsaneColouredTriangles {

    private static char[] define = new char[]{'R', 'G', 'B'};

    public static char triangle(final String row) {
        String newRow = row.replace('R', '0').replace('G', '1').replace('B', '2');
        int[] ints = new int[newRow.length()];
        for (int i = 0; i < newRow.length(); i++) {
            ints[i] = Character.getNumericValue(newRow.charAt(i));
        }

        long result = 0L;
        int n = ints.length;
        int n1 = n - 1;
        for (int k = 0; k < n; k++) {
            long nCr = Math.round(chooseMod3(n1, k));
            result = (result + nCr * ints[k]) % 3;
            System.out.printf("%dC%d,nCr=%d,result=%d \n", n1, k, nCr, result);
        }

        if (n1 % 2 != 0) {
            result = result * -1;
        }

        if (result < 0) {
            result += 3;
        }

        System.out.println(result);

        return define[(int) result];
    }

    public static double chooseMod3(int x, int y) {
        if (y < 0 || y > x) return 0;
        if (y > x / 2) {
            // choose(n,k) == choose(n,n-k),
            // so this could save a little effort
            y = x - y;
        }

        double answer = 1.0d;

        for (int i = 1; i <= y; i++) {
            answer = (answer * (x + 1 - i) / i) % 3;
//            answer *= (x + 1 - i);
//            answer /= i;
        }

        return answer;
    }
}
