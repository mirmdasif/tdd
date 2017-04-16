package net.asifhossain.tdte;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * @author asif.hossain
 * @since 4/16/17.
 */
public class TestTemplateParser {

    @Test
    public void testEmptyTemplatesRendersEmptyString() {
        TemplateParser parser = new TemplateParser();
        List<String> segments = parser.parse("");

        assertEquals("Number of segments", 1, segments.size());
        assertEquals("", segments.get(0));
    }
}
