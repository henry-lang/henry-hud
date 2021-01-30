package net.henrylang.henryhud;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Config {
	
	public class Value<T> {
		
	}
	
	public static HashMap<String, Value> values = new HashMap<String, Value>();
	static File config;
	
	public static void load(String dir) {
		config = new File(dir + File.separator + "hudconfig.txt");
		
		if(!config.exists()) {
			try {
				config.createNewFile(); 
//				values.put("HighlightColor", );
			} catch (IOException exception) {
				System.out.println("Error creating config.");
				exception.printStackTrace();
			}
		}
		
		
	}
}
