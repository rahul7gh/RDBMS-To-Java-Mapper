package utils;

public class Util {

	public static String removeQuotesIfPresent(String input) {
		if (input.length() > 2 && input.charAt(0) == '\"' && input.charAt(input.length() - 1) == '\"') {
			return input.substring(1, input.length() - 1);
		}
		return input;
	}

}
