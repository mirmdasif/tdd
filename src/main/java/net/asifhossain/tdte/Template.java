package net.asifhossain.tdte;

import java.util.HashMap;
import java.util.List;
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
        TemplateParser parser = new TemplateParser();
        List<String> segments = parser.parse(template);

        StringBuilder result = new StringBuilder();

        for (String segment : segments) {
            append(segment, result);
        }

        return result.toString();
    }

    private void append(String segment, StringBuilder result) {
        if (segment.startsWith("${") && segment.endsWith("}")) {
            String var = segment.substring(2, segment.length() - 1);

            if (!variables.containsKey(var)) {
                throw new MissingValueException("No value for variable " + segment);
            }

            result.append(variables.get(var));
        } else {
            result.append(segment);
        }
    }
}
