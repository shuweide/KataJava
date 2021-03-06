package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BreadcrumbGeneratorTest {
    @Test
    public void examplesTests() {
        // assertEquals("expected", "actual");

        String[] urls = new String[]{"https://mysite.com/pictures/holidays.html",
                "www.codewars.com/users/GiacomoSorbi?ref=CodeWars",
                "www.microsoft.com/docs/index.htm#top",
                "mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.asp",
                "www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi"};

        String[] seps = new String[]{" : ", " / ", " * ", " > ", " + "};

        String[] anss = new String[]{"<a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>",
                "<a href=\"/\">HOME</a> / <a href=\"/users/\">USERS</a> / <span class=\"active\">GIACOMOSORBI</span>",
                "<a href=\"/\">HOME</a> * <span class=\"active\">DOCS</span>",
                "<a href=\"/\">HOME</a> > <a href=\"/very-long-url-to-make-a-silly-yet-meaningful-example/\">VLUMSYME</a> > <span class=\"active\">EXAMPLE</span>",
                "<a href=\"/\">HOME</a> + <a href=\"/users/\">USERS</a> + <span class=\"active\">GIACOMO SORBI</span>"};

        for (int i = 0; i < 5; i++) {
            System.out.println(" \nTest with : " + urls[i]);
            String actual = BreadcrumbGenerator.generate_bc(urls[i], seps[i]);
            String actualBest = BreadcrumbGenerator.generate_bcBest(urls[i], seps[i]);
            if (!actual.equals(anss[i])) {
                System.out.println(String.format("Expected : %s", reformat(anss[i])));
                System.out.println(String.format("Actual :   %s", reformat(actual)));
            }
            assertEquals(anss[i], actual);
            assertEquals(anss[i], actualBest);
        }
    }

    String reformat(String s) {
        return s.replace("<", "<");
    }

}