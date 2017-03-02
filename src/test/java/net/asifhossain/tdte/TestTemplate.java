package net.asifhossain.tdte;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author asif.hossain
 * @since 3/1/17.
 */
public class TestTemplate {
    @Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void differentVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Bob");
        assertEquals("Hello, Bob", template.evaluate());
    }

    @Test
    public void differentTemplate() throws Exception {
        Template template = new Template("Hi, ${name}");
        template.set("name", "Bob");

        assertEquals("Hi, Bob", template.evaluate());
    }

    @Test
    public void multipleVariables() throws Exception {
        Template template = new Template("${one}, ${two}, ${three}");

        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");

        assertEquals("1, 2, 3", template.evaluate());
    }

    @Test
    public void unknownVariableAreIgnored() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Bob");
        template.set("unknown", "value unknown");

        assertEquals("Hello, Bob", template.evaluate());
    }
}
