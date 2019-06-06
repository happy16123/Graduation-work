package bj_algor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split(" ");
		int cnt=0;
		for(int i=0; i<arr.length; i++)
			if(!arr[i].equals(""))
				cnt++;
		System.out.println(cnt);
	}
}


