package com.evoluum.desafio.gateway;

import java.text.Normalizer;

public class StringResource {

	public static Boolean stringComparator(String text1, String text2) {
		return unaccent(text1.toLowerCase().trim()).equals(unaccent(text2.toLowerCase().trim()));
	}

	public static String unaccent(String src) {
		return Normalizer.normalize(src, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "");
	}

	public static Boolean isNullOrEmpty(String text) {
		return text == null || text.equals("") || text.trim().equals("");
	}

}
