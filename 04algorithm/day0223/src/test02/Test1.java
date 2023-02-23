package test02;

import java.util.Collections;
import java.util.PriorityQueue;

public class Test1 {
	public static void main(String[] args) {
		// 기본 값 : 숫자가 작은 것이 우선 순위가 높다.(오름차순)
		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		PriorityQueue<Person> pq2 = new PriorityQueue<>();
		// - 생성자에다가 Comparator를 만들어 넣던지..
		// - Person이 Comparable을 구현하도록..
		
		pq.offer(100);
		pq.offer(2);
		pq.offer(31);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		// 우선순위를 뒤집으면
		// 생성자에다가 Comparator 넣어주기. 내림차순 출력
		pq = new PriorityQueue<>(Collections.reverseOrder());
		
		pq.offer(100);
		pq.offer(2);
		pq.offer(31);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
