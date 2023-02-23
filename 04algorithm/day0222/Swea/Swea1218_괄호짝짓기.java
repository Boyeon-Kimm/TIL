package homework;
import java.util.Scanner;
import java.util.Stack;
public class Swea1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
            char[] arr = sc.next().toCharArray();
            
            Stack<Character> large = new Stack<>();
            Stack<Character> mid = new Stack<>();
            Stack<Character> small = new Stack<>();
            Stack<Character> dia = new Stack<>();
              
            boolean check = true;
              
             for(int i = 0; i < n; i++) {
                 switch(arr[i]) {
                     case '[' :
                         large.push(arr[i]);
                         break;
                         
                     case ']' :
                         if(!large.isEmpty()) large.pop();
                         else check = false;
                         break;
                         
                     case '{' :
                         mid.push(arr[i]);
                         break;
                         
                     case '}' :
                         if(!mid.isEmpty()) mid.pop();
                         else check = false;
                         break;
                         
                     case '(' :
                         small.push(arr[i]);
                         break;
                         
                     case ')' :
                         if(!small.isEmpty()) small.pop();
                         else check = false;
                         break;
                         
                     case '<' :
                         dia.push(arr[i]);
                         break;
                         
                     case '>' :
                         if(!dia.isEmpty()) dia.pop();
                         else check = false;
                         break;
                 }
                 if(!check) break;
             }

             if(!check) System.out.printf("#%d 0\n", tc);
             else System.out.printf("#%d 1\n", tc);
 		}
	}
}
