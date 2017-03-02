package net.asifhossain.tdte;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author asif.hossain
 * @since 3/1/17.
 */
public class TestTemplate {

    Template template;
    @Before
    public void setUp() {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multipleVariables() throws Exception {
        assertTemplatesEvaluateTo("1, 2, 3");
    }

    @Test
    public void unknownVariableAreIgnored() throws Exception {
        template.set("unknown", "value unknown");
        assertTemplatesEvaluateTo("1, 2, 3");
    }

    @Test(expected = MissingValueException.class)
    public void missingValueException() {
        new Template("${foo}").evaluate();
    }

    private void assertTemplatesEvaluateTo(String expected) {
        assertEquals(expected, template.evaluate());
    }
}
