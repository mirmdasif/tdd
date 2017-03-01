package net.asifhossain.tdte;

/**
 * @author asif.hossain
 * @since 3/1/17.
 */
public class Template {

    private String variable;

    public Template(String template) {

    }

    public void set(String variable, String value) {
        this.variable = value;
    }

    public String evaluate() {
        return "Hello, " + variable;
    }
}
