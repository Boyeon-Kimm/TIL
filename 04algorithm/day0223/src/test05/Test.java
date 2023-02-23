package test05;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	// 내부 클래스
	static class Person{
		int num; // 사람의 번호
		int cnt; // 큐에서 나왔을 때 마이쮸 몇개를 가져갈지??
		
		// 생성자 만들기
		Person(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) {
		int N = 20; // 마이쮸 개수
		int pNum = 1; // 사람 번호
		
		Queue<Person> q = new LinkedList<Person>();
		// 제일 처음에 1번 사람을 넣고 시작, 
		// 1번 사람은 제일 처음에 나올 때 마이쮸 한개를 가져감
		q.offer(new Person(pNum, 1));
		
		while(N > 0) { // 마이쮸가 남아있다면
			Person p = q.poll(); // 큐에서 첫번째 사람을 꺼내요.
			N -= p.cnt; // 마이쮸 주기
			// 1. N > 0
			// 2. N == 0 // 마이쮸 소진
			// 3. N < 0 // 마이쮸 소진
			// => 소진시킨 사람이 마지막 마이쮸를 가져간 사람이므로... p.num;
			if(N <= 0) {
				
			} else { // 소진되지 않은 상황
				p.cnt++;
				q.offer(p);
				q.offer(new Person(++pNum, 1));
			}
		}
		
	}
}
