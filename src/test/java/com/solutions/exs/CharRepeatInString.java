package com.solutions.exs;

import java.util.HashMap;
import java.util.Map;

public class CharRepeatInString {

	public static void main(String args[]) {
		String str = "Iaaam working in aaa Compaany";
		Map<Character, Integer> mapObj = new HashMap<Character, Integer>();
		int maxCount = 0;
		char maxChar = ' ';
		for(char chr : str.toCharArray()) {
			if (mapObj.containsKey(chr)) {
				int i = mapObj.get(chr);
				mapObj.put(chr, i + 1);
				if (maxCount < (i + 1)) {
					maxChar = chr;
					maxCount = i + 1;
				}
			}
			else {
				mapObj.put(chr, 1);
				if (maxCount < 1) {
					maxChar = chr;
					maxCount = 1;
				}

			}
		}

/*		for (Map.Entry<Character, Integer> entry : mapObj.entrySet()) {
			if (maxCount < entry.getValue()) {
				maxCount = entry.getValue();
				maxChar = entry.getKey();
			}
		}*/
		
		System.out.println("Most Repeted character : " + maxChar + " & Count : " + maxCount);
		
	}
}