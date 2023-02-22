package test02;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
	public static void main(String[] args) {
		// Queue는 인터페이스
		// LinkedList를 구현체로 사용
		Queue<Integer> q = new LinkedList<>();
		
		// enQueue => offer(), add()
		// deQueue => poll(), remove()
		// peek => peek(), element()
		q.offer(1);
		q.add(2);
		q.offer(3);
		
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.element());
		System.out.println(q.remove());
		System.out.println(q.poll());
		
		// add, remove, element 예외를 발생시킴
		// offer, poll, peek은 값을 리턴
		
		// add
		// - 새로운 원소 추가에 실패 => IllegerStateException
		// offer
		// - 새로운 원소 추가에 실패 => false
		
		// remove
		// - 큐에 원소가 없을 때 => NoSuchElementException
		// poll
		// - 큐에 원소가 없다면 null 반환
		
		// element
		// - 큐에 원소가 없을 때 => NoSuchElementException
		// peek
		// - 큐에 원소가 없다면 null 반환
	}
}
