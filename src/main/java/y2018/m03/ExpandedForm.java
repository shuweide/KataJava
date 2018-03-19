package y2018.m03;

/**
 * ### 2018/03/19
 * <p>
 * Write Number in Expanded Form
 * You will be given a number and you will need to return it as a string in Expanded Form. For example:
 * <p>
 * DoGiveMeFive.expandedForm(12); # Should return "10 + 2"
 * DoGiveMeFive.expandedForm(42); # Should return "40 + 2"
 * DoGiveMeFive.expandedForm(70304); # Should return "70000 + 300 + 4"
 * NOTE: All numbers will be whole numbers greater than 0.
 */
public class ExpandedForm {

    /**
     * ```java
     * String[] numStrs = String.valueOf(num).split("");
     * String form = "";
     * for (int i = 0; i < numStrs.length; i++) {
     * if (!numStrs[i].equals("0")) {
     * int multiplier = (int) Math.pow(10, (numStrs.length - i - 1));
     * form = form + String.valueOf(Integer.valueOf(numStrs[i]) * multiplier) + " + ";
     * }
     * }
     * return form.substring(0, form.length() - 3);
     * ```
     *
     * @param num
     * @return
     */
    public static String expandedForm(int num) {
        String[] numStrs = String.valueOf(num).split("");
        String form = "";
        for (int i = 0; i < numStrs.length; i++) {
            if (!numStrs[i].equals("0")) {
                int multiplier = (int) Math.pow(10, (numStrs.length - i - 1));
                form = form + String.valueOf(Integer.valueOf(numStrs[i]) * multiplier) + " + ";
            }
        }
        return form.substring(0, form.length() - 3);
    }

    /**
     * ```java
     * String outs = "";
     * for (int i = 10; i < num; i *= 10) {
     *      int rem = num % i;
     *      outs = (rem > 0) ? " + " + rem + outs : outs;
     *      num -= rem;
     * }
     * outs = num + outs;
     *
     * return outs;
     * ```
     * @param num
     * @return
     */
    public static String expandedFormBest(int num) {
        String outs = "";
        for (int i = 10; i < num; i *= 10) {
            int rem = num % i;
            outs = (rem > 0) ? " + " + rem + outs : outs;
            num -= rem;
        }
        outs = num + outs;

        return outs;
    }
}