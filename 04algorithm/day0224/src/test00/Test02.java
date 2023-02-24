package test00;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test02 {
	public static void main(String[] args) {
		List<Object> al = new ArrayList<>();
		List<Object> ll = new LinkedList<>();
		List<Object> v = new Vector<>();
		
		
		test1("순차적 추가 -  ArrayList - ", al);
		test1("순차적 추가 -     Vector - ", v);
		test1("순차적 추가 - LinkedList - ", ll);
		
		
		test2("맨앞에 추가 -  ArrayList - ", al);
		test2("맨앞에 추가 -     Vector - ", v);
		test2("맨앞에 추가 - LinkedList - ", ll);
		
		test3("데이터 접근 -  ArrayList - ", al);
		test3("데이터 접근 -     Vector - ", v);
		test3("데이터 접근 - LinkedList - ", ll);
		
		
		
	}
	
	public static void test1(String testname, List<Object> list) {
		long start = System.nanoTime();
		for(int i=0; i<50000; i++) {
			list.add(new String("Hello"));
		}
		long end = System.nanoTime();
		System.out.printf("%s \t 소요시간: %15d ns. \n", testname, end-start);
	}
	
	public static void test2(String testname, List<Object> list) {
		long start = System.nanoTime();
		for(int i=0; i<50000; i++) {
			list.add(0, new String("Hello"));
		}
		long end = System.nanoTime();
		System.out.printf("%s \t 소요시간: %15d ns. \n", testname, end-start);
	}
	
	public static void test3(String testname, List<Object> list) {
		long start = System.nanoTime();
		for(int i=0; i<list.size(); i++) {
			list.get(i);
		}
		long end = System.nanoTime();
		System.out.printf("%s \t 소요시간: %15d ns. \n", testname, end-start);
	}
}
