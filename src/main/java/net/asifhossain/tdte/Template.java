package net.asifhossain.tdte;

import java.util.HashMap;
import java.util.Map;

/**
 * @author asif.hossain
 * @since 3/1/17.
 */
public class Template {

    private String template;
    private Map<String, String> variables;

    public Template(String template) {
        variables = new HashMap<>();
        this.template = template;
    }

    public void set(String variable, String value) {
        variables.put(variable, value);
    }

    public String evaluate() {

        String text = new String(template);
        for (String variable : variables.keySet()) {

            text = text.replaceAll("\\$\\{" + variable +"}", variables.get(variable));
        }

        checkForMissingValue(text);
        return text;
    }

    private void checkForMissingValue(String renderedText) {
        if (renderedText.matches(".*\\{.+\\}.*")) {
            throw new MissingValueException();
        }
    }
}
