package net.asifhossain.tdte;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author asif.hossain
 * @since 4/16/17.
 */
public class TemplateParser {

    public List<String> parse(String template) {
        Pattern pattern = Pattern.compile("\\$\\{[^{]+}");
        Matcher matcher = pattern.matcher(template);

        List<String> segments = new LinkedList<>();

        int index = 0;
        while (matcher.find()) {
            if(matcher.start() != index) {
                segments.add(template.substring(index, matcher.start()));
            }

            segments.add(template.substring(matcher.start(), matcher.end()));
            index = matcher.end();
        }

        if (index < template.length()) {
            segments.add(template.substring(index));
        }

        if (segments.size() == 0 ) {
            return Arrays.asList("");
        }

        return segments;
    }
}
