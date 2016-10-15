package com.backbase.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestContext {
	//ConcurrentHashMap is used because I can run with many threads
	private static Map<String, Object> context = new ConcurrentHashMap<>();
	
	public static void put(String k, Object obj) {
		context.put(k, obj);
	}
	
	public static Object get(String k) {
		return context.get(k);
	}
	
}
