package test01;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			int num = arr[i] - '0';
		}
	}
}
