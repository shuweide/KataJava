package y2018.m04;

public class User {

    public int rank;
    public int progress;

    public User() {
        rank = -8;
    }

    public int rank() {
        return rank;
    }

    public void incProgress(int rank) {
        if (Math.abs(rank) > 8 || rank == 0) {
            throw new RuntimeException("illegal number!");
        }
        int diff = this.rank < 0 && rank > 0 ? rank - this.rank - 1
                : this.rank > 0 && rank < 0 ? rank - this.rank + 1
                : rank - this.rank;
        int point = diff == -1 ? 1 : diff == 0 ? 3 : diff > 0 ? diff * diff * 10 : 0;
        progress += point;
        if (progress >= 100) {
            int upLevel = progress / 100;
            if (this.rank < 0 && this.rank + upLevel >= 0) {
                this.rank += upLevel + 1;
            } else {
                this.rank += upLevel;
            }
            progress = progress % 100;
        }
        if (this.rank == 8) {
            progress = 0;
        }
    }

    public int progress() {
        return progress;
    }
}
