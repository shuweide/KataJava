package y2018.m04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * ### 2018/04/17 ###
 *
 * ###Description:###
 *
 * The learning game - Machine Learning #1
 * Growing up you would have learnt a lot of things like not to stand in fire,
 * to drink food and eat water and not to jump off very tall things But Machines have it difficult they cannot learn
 * for themselves we have to tell them what to do, why don't we give them a chance to learn it for themselves?
 *
 * ###Task###
 *
 * Your task is to finish the Machine object. What the machine object must do is learn from its mistakes!
 * The Machine will be given a command and a number you will return a random action.
 * After the command has returned you will be given a response (true/false) if the response is true then you have done good,
 * if the response is false then the action was a bad one.
 *
 * You must program the machine to learn to apply an action to a given command using the reponse given.
 * Note: It must take no more than 20 times to teach an action to a command also different cmdMap can have the same action.
 *
 * ###Info###
 *
 * In the preloaded section there is a constant called ACTIONS it is a function that returns the 5 possible actions.
 * In Java, this a constant Actions.FUNCTIONS of type List<Function<Integer, Integer>>
 */
public class MachineLearning {

    private Map<Integer, Integer> cmdMap = new HashMap<>();
    private int currentCmd;

    /**
     * ```java
     *  this.currentCmd = cmd;
     *  if (!cmdMap.containsKey(cmd)) {
     *      cmdMap.put(cmd, 0);
     *  }
     *  int action = cmdMap.get(cmd);
     *  return Actions.FUNCTIONS.get(action).apply(num);
     * ```
     * @param cmd
     * @param num
     * @return
     */
    public int command(int cmd, int num) {
        this.currentCmd = cmd;
        if (!cmdMap.containsKey(cmd)) {
            cmdMap.put(cmd, 0);
        }
        int action = cmdMap.get(cmd);
        return Actions.FUNCTIONS.get(action).apply(num);
    }

    /**
     * ```java
     * if (!result) {
     *      int action = cmdMap.get(currentCmd);
     *      cmdMap.put(currentCmd, action + 1);
     * }
     * ```
     * @param result
     */
    public void response(boolean result) {
        if (!result) {
            int action = cmdMap.get(currentCmd);
            cmdMap.put(currentCmd, action + 1);
        }
    }

    static class Actions {
        static final List<Function<Integer, Integer>> FUNCTIONS = Arrays.asList(x -> x + 1, x -> 0, x -> x % 2, x -> x / 2, x -> x * 100);
    }
}
