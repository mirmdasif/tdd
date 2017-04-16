package net.asifhossain.tdte;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * @author asif.hossain
 * @since 3/29/17.
 */
public class RegexLearningTest {
    @Test
    public void testHowGroupCountWorks() {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";

        Matcher matcher = Pattern.compile(regex).matcher(haystack);

        assertEquals(1, matcher.groupCount());
    }

    @Test
    public void testFindStartAndEnd() {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);

        assertTrue(matcher.find());
        assertEquals("Wrong start index of first match", 4, matcher.start());
        assertEquals("Wrong end index of first match", 10, matcher.end());

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 2nd match", 22, matcher.start());
        assertEquals("Wrong end index of 2nd match", 28, matcher.end());
        assertFalse("Should not have any more matches", matcher.find());
    }

    @Test
    public void variableRegexTest() {
        String template = "${one}, ${two}, ${three}";
        Pattern pattern = Pattern.compile("\\$\\{[^{]+}");
        Matcher matcher = pattern.matcher(template);

        assertTrue(matcher.find());
        assertEquals(matcher.start(), 0);
        assertEquals(matcher.end(), 6);

        assertTrue(matcher.find());
        assertEquals(matcher.start(), 8);
        assertEquals(matcher.end(), 14);
    }

    @Test
    public void stringSplitTest() {
        assertEquals("abc, def".substring(0, 3), "abc");
    }
}
