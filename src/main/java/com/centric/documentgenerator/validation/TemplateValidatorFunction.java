package com.centric.documentgenerator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateValidatorFunction {
    private static final String TEMPLATE_PATTERN = "(data.[a-z_.]+|([a-z0-9_]*\\]))";
    private static final String EXTRACT_EXACT_STRING = "[a-z0-9_.]*";

    public static String  isValidTemplate(String text) {
        Pattern pattern = Pattern.compile(TEMPLATE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String matchedText = matcher.group(0);
            // System.out.println("Matched Text: " + matchedText);
            if(matchedText.contains("]")){
                matchedText=  matchedText.replace("]","");
                System.out.println(matchedText);
                return matchedText;
            }
            return matchedText;
        }
        return null;
    }
}
