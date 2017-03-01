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
}
