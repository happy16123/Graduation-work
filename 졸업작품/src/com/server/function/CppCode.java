package com.server.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CppCode implements Code {
	
	@Override
	public ArrayList<String> fileWrite(String code, String className) {
		return null;
	}
	
	@Override
	public ArrayList<String> fileWrite(String code) {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		command.add("/bin/bash");
		command.add("cpp_make.sh");
		command.add(code);
		 
		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/test"));
			process = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream())); 

			String res = null; // 실행결과담기
			while ((res = br.readLine()) != null) {
				result.add(res);
			}
			
			while((res = error.readLine()) != null) {
				result.add(res);
			}
			
			
			process.waitFor();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ArrayList<String> compile(String testClassName) {
		return null;
	}

	@Override
	public ArrayList<String> compile() {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		command.add("/bin/bash");
		command.add("cpp_compile.sh");
		
		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/test"));
			process = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream())); 

			String res = null; // 실행결과담기
			while ((res = br.readLine()) != null) {
				result.add(res);
			}
			
			while((res = error.readLine()) != null) {
				result.add(res);
			}
			
			
			process.waitFor();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ArrayList<String> resultData(String testClassName) {
		return null;
	}

	@Override
	public ArrayList<String> resultData() {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
				
		command.add("./a.out");
		
		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/test"));
			process = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream())); 

			String res = null; // 실행결과담기
			while ((res = br.readLine()) != null) {
				result.add(res);
			}
			
			while((res = error.readLine()) != null) {
				result.add(res);
			}
			
			
			process.waitFor();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void remove() {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		
		command.add("/bin/bash");
		command.add("cpp_remove.sh");
		
		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/test"));
			process = pb.start();		
			
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String className) {
		// TODO 자동 생성된 메소드 스텁
		
	}

}

