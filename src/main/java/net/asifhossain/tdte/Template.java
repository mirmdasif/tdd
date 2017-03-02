package net.asifhossain.tdte;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String result = replaceVariables();
        checkForMissingValue(result);

        return result;
    }

    private String replaceVariables() {
        String result = template;
        for (String variable : variables.keySet()) {

            result = result.replaceAll("\\$\\{" + variable +"}", variables.get(variable));
        }

        return result;
    }

    private void checkForMissingValue(String renderedText) {
        Matcher m = Pattern.compile(".*\\{.+\\}.*").matcher(renderedText);
        if (m.find()) {
            throw new MissingValueException("No value for variable " + m.group());
        }
    }
}
