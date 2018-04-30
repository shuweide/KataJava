package y2018.m04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ###2018/04/30###
 *
 * In this kata you have to write a simple Morse code decoder. While the Morse code is now mostly superceded by voice and digital data communication channels, it still has its use in some applications around the world.
 * The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−. The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code, a single space is used to separate the character codes and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.
 *
 * NOTE: Extra spaces before or after the code have no meaning and should be ignored.
 *
 * In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of those is the international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···. These special codes are treated as single special characters, and usually are transmitted as separate words.
 *
 * Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
 *
 * For example:
 *
 * ```java
 * MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
 * //should return "HEY JUDE"
 * ```
 *
 * The Morse code table is preloaded for you as a dictionary, feel free to use it. In CoffeeScript, C++, Go, JavaScript, PHP, Python, Ruby and TypeScript, the table can be accessed like this: MORSE_CODE['.--'], in Java it is MorseCode.get(".--"), in C# it is MorseCode.Get(".--") (returns string), in Haskell the codes are in a Map String String and can be accessed like this: morseCodes ! ".--", in Elixir it is morse_codes variable, in Rust it is self.morse_code.
 *
 * All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions. In C#, tests will fail if the solution code throws an exception, please keep that in mind. This is mostly because otherwise the engine would simply ignore the tests, resulting in a "valid" solution.
 *
 * Good luck!
 */
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        return Arrays.stream(morseCode.trim().split("[ ]{3}"))
                .map(s -> Arrays.stream(s.split(" ")).map(MorseCode::get).collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

    static class MorseCode {
        private static Map<String, String> morses = new HashMap<>();

        static {
            morses.put("....", "H");
            morses.put(".", "E");
            morses.put("-.--", "Y");
            morses.put("..-", "U");
            morses.put(".---", "J");
            morses.put("-..", "D");
        }

        public static String get(String code) {
            return morses.get(code);
        }
    }
}
