package com.collections.exs;

import java.io.FileWriter;
import java.util.Map;
import java.util.Properties;

public class PropertiesEx {

	public static void main(String[] args) throws Exception {
		Properties p = System.getProperties();
	
		for(Map.Entry e: p.entrySet()) {
			p.setProperty(e.getKey().toString(), e.getValue().toString());
		}
		System.out.println("Before");
		p.store(new FileWriter("test.properties"), "System Properties");
		System.out.println("After");
	}

}
