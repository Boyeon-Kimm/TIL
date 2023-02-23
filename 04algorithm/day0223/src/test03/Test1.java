package test03;

import java.util.PriorityQueue;

public class Test1 {
	public static void main(String[] args) {
		PriorityQueue<Person> pq = new PriorityQueue<>();
		
		pq.offer(new Person("김민식", 22));
		pq.offer(new Person("유태영", 55));
		pq.offer(new Person("차지은", 17));
		pq.offer(new Person("신산하", 23));
		pq.offer(new Person("김두현", 7));
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
	}
}
