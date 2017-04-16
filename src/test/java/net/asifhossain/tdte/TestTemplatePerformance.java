package net.asifhossain.tdte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author asif.hossain
 * @since 3/6/17.
 */
public class TestTemplatePerformance {

    private Template  template;

    @Before
    public void setUpTemplate() {
        String templateText = "${the} ${quick} ${brown} ${fox} ${jumps} ${over} ${the} ${lazy} ${dog}";
        template = new Template(templateText);
        template.set("the", "the");
        template.set("quick", "quick");
        template.set("brown", "brown");
        template.set("fox", "fox");
        template.set("jumps", "jumps");
        template.set("over", "over");
        template.set("lazy", "lazy");
        template.set("dog", "dog");
    }

    @Test
    public void templateWith100WordsAnd20Variables() {
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;

        assertTrue("Rendering the template took " + time + "ms. Where target was 200ms", time < 200L);
    }
}
