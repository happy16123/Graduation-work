package com.server.function;

import java.util.ArrayList;

public interface Code {
	public ArrayList<String> fileWrite(String code);
	public ArrayList<String> fileWrite(String code, String className);
	public ArrayList<String> compile();
	public ArrayList<String> compile(String testClassName);
	public ArrayList<String> resultData();
	public ArrayList<String> resultData(String testClassName);
	public void remove();
	public void remove(String className);
}

