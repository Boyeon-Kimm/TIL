package test04;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1 {
	public static void main(String[] args) {
//		PriorityQueue<Person> pq = new PriorityQueue<>(new NameComparator());
//		PriorityQueue<Person> pq = new PriorityQueue<>(new AgeComparator());
		
		// 무명 클래스 : 이름이 없는 클래스, 객체를 단 한번만 생성
//		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.age - o2.age;
//			}
//			
//		});
		
		// 람다표현식
		// - 람다? 그리스어 11번째 문자
		// - 함수를 간결하게 표현한 것
		// - 메서드의 길이가 짧은 경우
		// - 전통적으로 자바는 객체지향 언어.
		// - 본래는 함수가 객체를 떠나서 독자적으로 존재할 수 없었음.
		// - 람다식은 함수형 프로그래밍을 자바에 도입한 것
		// - 매개변수로 람다 함수를 전달 가능
		
		// - 문법 : ( 파라미터 ) -> { body }
		// - 파라미터가 단일 매개변수일 때 () 생략 가능
		// - body가 단일 문장일 때 {} 생략 가능
		
		PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2)-> { 
			if(o1.name.equals(o2.name)) {
				return o1.age - o2.age;
			} else {
				return o1.name.compareTo(o2.name);
			}
		});
		
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
