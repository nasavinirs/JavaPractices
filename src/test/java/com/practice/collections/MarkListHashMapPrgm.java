package com.practice.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MarkListHashMapPrgm {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> hMap = new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of students");
		int n = Integer.parseInt(br.readLine());
		String[] name = new String[n];
		int[] mark = new int[n];
		int c050 = 0, c5070 = 0, c7090 = 0, c90100 = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the name of student " + (i + 1));
			name[i] = br.readLine();
			System.out.println("Enter the mark of student " + (i + 1));
			mark[i] = Integer.parseInt(br.readLine());
			if (mark[i] >= 0 && mark[i] <= 50)
				c050++;
			else if (mark[i] > 50 && mark[i] <= 70)
				c5070++;
			else if (mark[i] > 70 && mark[i] <= 90)
				c7090++;
			else if (mark[i] > 90 && mark[i] <= 100)
				c90100++;
		}

		hMap.put("0-50", c050);
		hMap.put("50-70", c5070);
		hMap.put("70-90", c7090);
		hMap.put("90-100", c90100);

		Map<String, Integer> map = new TreeMap<String, Integer>(hMap);
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) itr.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
