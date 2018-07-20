package y2018.m07;

public class InsaneColouredTriangles {

    public static char triangle2(final String row) {
        char[] a = row.toCharArray();
        for (int s = 59049; s > 0; s /= 3) {
            while (a.length > s) {
                char[] b = new char[a.length - s];
                for (int i = 0; i+s < a.length; i++)
                    b[i] = (char) ((666 - a[i] - a[i+s]) % 3);
                a = b;
            }
        }
        return "BRG".charAt(a[0] % 3);
    }

    private static char[] define = new char[]{'R', 'G', 'B'};

    public static char triangle(final String row) {
        String newRow = row.replace('R', '0').replace('G', '1').replace('B', '2');
        int[] ints = new int[newRow.length()];
        for (int i = 0; i < newRow.length(); i++) {
            ints[i] = Character.getNumericValue(newRow.charAt(i));
        }

        long result = 0;
        int n = ints.length;
        int n1 = n - 1;
        for (int k = 0; k < n; k++) {
            if (ints[k] != 0) {
                long nCr = combinations(n1, k, 3);
                result = result + nCr * ints[k];
//                System.out.printf("%dC%d,nCr=%d,result=%d \n", n1, k, nCr, result);
            }
        }

        result = result % 3;

        if (n1 % 2 != 0) {
            result = result * -1;
        }

        if (result < 0) {
            result += 3;
        }

//        System.out.println(result);

        return define[(int) result];
    }

    private static long combinations(int n, int k, long p) {
        int num_degree = get_degree(n, p) - get_degree(n - k, p);
        int den_degree = get_degree(k, p);

        if (num_degree > den_degree) {
            return 0;
        }
        long res = 1;
        for (long i = n; i > n - k; --i) {
            long ti = i;
            while(ti % p == 0) {
                ti /= p;
            }
            res = (res * ti) % p;
        }
        long denom = 1;
        for (long  i = 1; i <= k; ++i) {
            long ti = i;
            while(ti % p == 0) {
                ti /= p;
            }
            denom = (denom * ti) % p;
        }
        res = (res * degree(denom, p-2, p)) % p;
        return res;
    }

    private static long degree(long a, long k, long p) {
        long res = 1;
        long cur = a;

        while (k > 0) {
            if (k % 2 > 0) {
                res = (res * cur) % p;
            }
            k /= 2;
            cur = (cur * cur) % p;
        }
        return res;
    }

    static int get_degree(long n, long p) { // returns the degree with which p is in n!
        int degree_num = 0;
        long u = p;
        long temp = n;

        while (u <= temp) {
            degree_num += temp / u;
            u *= p;
        }
        return degree_num;
    }
    
    static int getNextMagicTriangleWidth(int w) {
        int p = 1;
        while (p * 3 + 1 <= w) p *= 3;
        return p + 1;
    }

    static byte charToByte(byte c) {
        return c == 'R' ? (byte) 1 : c == 'G' ? (byte) 2 : (byte) 4;
    }

    static char byteToChar(byte b) {
        return b == 1 ? 'R' : b == 2 ? 'G' : 'B';
    }

    public static char triangle3(final String s) {
        int w = s.length();
        byte[] a = s.getBytes();
        for (int i = 0; i < w; i++) a[i] = charToByte(a[i]);
        do {
            int mw = getNextMagicTriangleWidth(w);
            w -= mw - 1;
            for (int i = 0; i < w; i++) {
                int t = a[i] ^ a[mw + i - 1];
                if (t != 0) a[i] = (byte) (t ^ 7);
            }
        } while (w > 1);
        return byteToChar(a[0]);
    }

}
