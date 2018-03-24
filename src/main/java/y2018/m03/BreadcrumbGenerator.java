package y2018.m03;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * ### 2018/03/25
 *
 * As breadcrumb menùs are quite popular today, I won't digress much on explaining them,
 * leaving the wiki link to do all the dirty work in my place.
 *
 * What might not be so trivial is instead to get a decent breadcrumb from your current url.
 * For this kata, your purpose is to create a function that takes a url,
 * strips the first part (labelling it always HOME) and then builds it making each element
 * but the last a &lt;a&gt; element linking to the relevant path; last has to be a <span> element getting the active class.
 *
 * All elements need to be turned to uppercase and separated by a separator, given as the second parameter of the function;
 * the last element can terminate in some common extension like .html, .htm, .php or .asp;
 * if the name of the last element is index.something, you treat it as if it wasn't there,
 * sending users automatically to the upper level folder.
 *
 * A few examples can be more helpful than thousands of words of explanation, so here you have them:
 *
 * ```java
 * Solution.generate_bc("mysite.com/pictures/holidays.html", " : ").equals( '<a href="/">HOME</a> : <a href="/pictures/">PICTURES</a> : <span class="active">HOLIDAYS</span>' );
 * Solution.generate_bc("www.codewars.com/users/GiacomoSorbi", " / ").equals( '<a href="/">HOME</a> / <a href="/users/">USERS</a> / <span class="active">GIACOMOSORBI</span>' );
 * Solution.generate_bc("www.microsoft.com/docs/index.htm", " * ").equals( '<a href="/">HOME</a> * <span class="active">DOCS</span>' );
 * ```
 * Seems easy enough?
 *
 * Well, probably not so much, but we have one last extra rule: if one element (other than the root/home) is longer than 30 characters,
 * you have to shorten it, acronymizing it (i.e.: taking just the initials of every word);
 * url will be always given in the format this-is-an-element-of-the-url and you should ignore words
 * in this array while acronymizing: ["the","of","in","from","by","with","and", "or", "for", "to", "at", "a"];
 * a url composed of more words separated by - and equal or less than 30 characters long needs to be just uppercased
 * with hyphens replaced by spaces.
 *
 * Ignore anchors (www.url.com#lameAnchorExample) and parameters (www.url.com?codewars=rocks&pippi=rocksToo) when present.
 *
 * Examples:
 * ```java
 * Solution.generate_bc("mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.htm", " > ").equals( '<a href="/">HOME</a> > <a href="/very-long-url-to-make-a-silly-yet-meaningful-example/">VLUMSYME</a> > <span class="active">EXAMPLE</span>' );
 * Solution.generate_bc("www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi", " + ").equals( '<a href="/">HOME</a> + <a href="/users/">USERS</a> + <span class="active">GIACOMO SORBI</span>' );
 * ```
 */
public class BreadcrumbGenerator {

    public static String generate_bc(String url, String separator) {
        final String preATagStart = "<a href=\"";
        final String preATagEnd = "\">";
        final String postATag = "</a>";
        final String preSpanTag = "<span class=\"active\">";
        final String postSpanTag = "</span>";

        int preUrlIndex = url.indexOf("//");
        url = preUrlIndex == -1 ? url : url.substring(preUrlIndex + 2);
        String[] subUrl = url.split("/");
        List<String> subBC = new LinkedList<>();
        for (int i = 0, line = 1; i < subUrl.length; i++, line++) {
            //first
            if (line == 1) {
                if (line != subUrl.length) {
                    subBC.add(preATagStart + "/" + preATagEnd + "HOME" + postATag);
                } else {
                    subBC.add(preSpanTag + "HOME" + postSpanTag);
                }
                //end
            } else if (line == subUrl.length) {
                //remove #&.
                String spanUrl = subUrl[i].split("#")[0];
                spanUrl = spanUrl.split(Pattern.quote("?"))[0];
                spanUrl = spanUrl.split(Pattern.quote("."))[0];

                if (spanUrl.equalsIgnoreCase("index") || spanUrl.trim().equals("")) {
                    if (line == 2) {
                        spanUrl = "HOME";
                    } else {
                        spanUrl = subUrl[i - 1];
                    }
                    subBC.remove(i - 1);
                }

                subBC.add(preSpanTag + getContent(spanUrl) + postSpanTag);
            } else {
                String hrefContent;
                //multi middle
                if (line > 2) {
                    hrefContent = "/";
                    for (int j = 1; j <= i; j++) {
                        hrefContent = hrefContent + subUrl[j] + "/";
                    }
                } else {
                    hrefContent = "/" + subUrl[i] + "/";
                }
                subBC.add(preATagStart + hrefContent + preATagEnd + getContent(subUrl[i]) + postATag);
            }
        }
        return subBC.stream().collect(Collectors.joining(separator));
    }

    private static String getContent(String originUrl) {
        final List<String> filterWords =
                Arrays.asList("the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at", "a");

        String content;
        if (originUrl.length() > 30) {
            content = Arrays.stream(originUrl.split("-"))
                    .filter(str -> !filterWords.contains(str.toLowerCase()))
                    .map(str -> "" + str.charAt(0))
                    .collect(Collectors.joining(""));
        } else {
            content = originUrl;
        }
        return content.toUpperCase().replace("-", " ");
    }

    private static final Set<String> IGNORE_WORDS = new HashSet<>(Arrays.asList("the of in from by with and or for to at a".toUpperCase().split(" ")));

    /**
     * ```java
     * public static String generate_bcBest(String url, String separator) {
     *      List<String> bcLst = new ArrayList();
     *
     *      String[] urlArray = url.replaceAll("https?://|/index[.].*|([.]\\w+)?([?#].*)?|/$", "")
     *          .split("/");
     *
     *      for (int i = 0; i < urlArray.length - 1; i++) {
     *          if (i == 0) bcLst.add("<a href=\"/\">HOME</a>");
     *          else
     *              bcLst.add(String.format("<a href=\"/%1$s/\">%2$s</a>",
     *                  String.join("/", Arrays.copyOfRange(urlArray, 1, i + 1)),
     *                  formatStr(urlArray[i])));
     *      }
     *
     *      bcLst.add(String.format("<span class=\"active\">%s</span>", urlArray.length == 1 ? "HOME"
     *          : formatStr(urlArray[urlArray.length - 1])));
     *
     *      return String.join(separator, bcLst.toArray(new String[0]));
     * }
     *
     * private static String formatStr(String item) {
     *
     *      item = item.toUpperCase().replace("-", " ");
     *      if (item.length() > 30)
     *          item = Arrays.stream(item.split(" "))
     *              .filter(s -> !IGNORE_WORDS.contains(s))
     *              .map(s -> s.substring(0, 1))
     *              .collect(Collectors.joining(""));
     *      return item;
     * }
     * ```
     * @param url
     * @param separator
     * @return
     */
    public static String generate_bcBest(String url, String separator) {
        List<String> bcLst = new ArrayList();

        String[] urlArray = url.replaceAll("https?://|/index[.].*|([.]\\w+)?([?#].*)?|/$", "")
                .split("/");

        for (int i = 0; i < urlArray.length - 1; i++) {
            if (i == 0) bcLst.add("<a href=\"/\">HOME</a>");
            else
                bcLst.add(String.format("<a href=\"/%1$s/\">%2$s</a>",
                        String.join("/", Arrays.copyOfRange(urlArray, 1, i + 1)),
                        formatStr(urlArray[i])));
        }

        bcLst.add(String.format("<span class=\"active\">%s</span>", urlArray.length == 1 ? "HOME"
                : formatStr(urlArray[urlArray.length - 1])));

        return String.join(separator, bcLst.toArray(new String[0]));
    }

    private static String formatStr(String item) {

        item = item.toUpperCase().replace("-", " ");
        if (item.length() > 30)
            item = Arrays.stream(item.split(" "))
                    .filter(s -> !IGNORE_WORDS.contains(s))
                    .map(s -> s.substring(0, 1))
                    .collect(Collectors.joining(""));
        return item;
    }
}
