package y2018.unfinish;

public class MakeSpiral {
    public static int[][] spiralize(int size) {

        int[][] spiral = new int[size][size];

        int x = 0, y = 0, dx = 0, dy = 1;
        int current = 1;
        while (current <= size * size) {
            current++;

            spiral[x][y] = 1;
            int nx = x + dx, ny = y + dy;
            //edge condition
            if (nx < 0 || nx == size || ny < 0 || ny == size
                    || ((nx + dx < size) && (nx + dx >= 0) && (ny + dy < size) && (ny + dy >= 0) && spiral[nx + dx][ny + dy] != 0)) {
                //trun
                int t = dx;
                dx = dy;
                dy = -t;

                int countOne = 0;
                for (int r = x + dx - 1; r <= x + dx + 1; r++) {
                    for (int c = y + dy - 1; c <= y + dy + 1; c++) {
                        if (r >= 0 && c >= 0 && r < size && c < size)
                            countOne += spiral[r][c];
                    }
                }
//                if (countOne > 2 && (size > 2 && size % 2 == 1 || size == 2) ) {
                if (countOne > 2) {
                    break;
                }
            }
            x += dx;
            y += dy;
        }

        return spiral;
    }
}
