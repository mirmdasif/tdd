package net.asifhossain.tdte;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
/**
 * @author asif.hossain
 * @since 4/16/17.
 */
public class TestTemplateParser {

    private TemplateParser parser;

    @Before
    public void initialize() {
        parser = new TemplateParser();
    }

    @Test
    public void testEmptyTemplatesRendersEmptyString() {
        assertSegments(parser.parse(""), "");
    }

    @Test
    public void testTemplateWithOnlyPlainText() {
        String template = "Text with no variable";
        assertSegments(parser.parse(template), template);
    }

    private void assertSegments(List<String> expected, String... actual) {
        assertEquals("Number of segments", expected.size(), actual.length);
        assertEquals(expected, Arrays.asList(actual));
    }
}
