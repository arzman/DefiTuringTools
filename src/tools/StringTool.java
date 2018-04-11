package tools;

import java.util.ArrayList;

public class StringTool {

	public static String[] circularPerm(String chaine) {

		ArrayList<String> tmp = new ArrayList<String>();

		for (int i = 0; i < chaine.length(); i++) {

			StringBuffer buff = new StringBuffer();

			for (int j = 0; j < chaine.length(); j++) {

				buff.append(chaine.charAt((j + i) % chaine.length()));

			}
			tmp.add(buff.toString());

		}

		return tmp.toArray(new String[tmp.size()]);

	}

	public static ArrayList<String> allPerm(String chaine) {

		ArrayList<String> tmp = new ArrayList<String>();

		if (chaine.length() == 1) {
			tmp.add(chaine);
		} else {

			for (String word : allPerm(chaine.substring(1))) {

				for (int i = 0; i < word.length() + 1; i++) {
					tmp.add(word.substring(0, i) + chaine.charAt(0) + word.substring(i));
				}

			}
		}

		return tmp;
	}

	public static boolean isPalindrome(String chaine) {

		boolean res = true;

		if (chaine.length() != 1) {

			for (int i = 0; res && 2 * i < chaine.length(); i++) {

				res = chaine.charAt(i) == chaine.charAt(chaine.length() - 1 - i);

			}

		}

		return res;

	}

}
