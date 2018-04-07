package y2018.m04;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * ###2018/04/08###
 *
 * Here's a seemingly simple challenge. We're giving you a class called bagel, exactly as it appears below.
 * All it really does is return an int, specifically 3.
 * ```java
 * public class Bagel {
 *      public final int getValue() {
 *          return 3;
 *      }
 * }
 * ```
 * The catch? For the solution, we're testing that the result is equal to 4. But as a little hint, the solution to the this Kata is exactly the same as the example test cases.
 */
public class BagelSolver {
    /**
     * ```java
     * try {
     *      Field field = Boolean.class.getField("FALSE");
     *      Field modifiersField = Field.class.getDeclaredField("modifiers");
     *      modifiersField.setAccessible(true);
     *      modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
     *      field.set(null, Boolean.TRUE);
     * } catch (Exception e) {
     * }
     * return new Bagel();
     * ```
     * @return
     */
    public static Bagel getBagel() {
        try {
            Field field = Boolean.class.getField("FALSE");
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Bagel();
    }

}