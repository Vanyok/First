package com.kostiushko.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskValidator {

    public static final Pattern pattern = Pattern.compile("[*.\\w]*");

    public static boolean isValid(String mask) {

	Matcher matcher = pattern.matcher(mask);
	return matcher.matches();

    }

    public static boolean isNameValid(String mask, String name) {
	String regex = "";
	mask = mask.toLowerCase();
	char[] chars = mask.toCharArray();
	for (char c : chars) {
	    if (c == '*') {
		regex = regex + "[.\\w]*";
	    } else if (c == '_') {
		regex = regex + ".";
	    } else {
		regex = regex + c;
	    }
	}

	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(name.toLowerCase());
	return matcher.matches();
    }
}
