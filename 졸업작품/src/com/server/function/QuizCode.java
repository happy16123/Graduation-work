package com.server.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuizCode implements Code{
	
	@Override
	public ArrayList<String> fileWrite(String code) {
		return null;
	}
	
	@Override
	public ArrayList<String> fileWrite(String code, String className) {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		command.add("/bin/bash");
		command.add("make.sh");
		command.add(code);
		command.add(className);
		 
		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/junit"));
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
			error.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ArrayList<String> compile() {
		return null;
	}

	@Override
	public ArrayList<String> compile(String testClassName) {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		command.add("/bin/bash");
		command.add("compile.sh");
		command.add(testClassName);

		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/junit"));
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
			error.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ArrayList<String> resultData() {
		return null;
	}
	
	@Override
	public ArrayList<String> resultData(String testClassName) {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		command.add("/bin/bash");
		command.add("result.sh");
		command.add(testClassName);
		
		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/junit"));
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
			error.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void remove(String className) {
		ProcessBuilder pb = null;
		Process process = null;
		ArrayList<String> command = new ArrayList<String>();
		
		command.add("/bin/bash");
		command.add("remove.sh");
		command.add(className);
		
		try {
			pb = new ProcessBuilder(command);
			pb.directory(new File("/home/web/junit"));
			process = pb.start();
			
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove() {
		// TODO 자동 생성된 메소드 스텁
		
	}
}

