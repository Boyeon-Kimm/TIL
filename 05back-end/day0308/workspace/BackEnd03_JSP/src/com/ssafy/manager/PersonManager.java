package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

// 사람의 목록 관리를 하는 매니저
// 싱글턴으로 제한을 걸고 싶다?!!
public class PersonManager {
	// 사람 목록
	private List<Person> list = new ArrayList<>();
	
	private static PersonManager manager = new PersonManager();
	
	// 기본 생성자 막기
	private PersonManager() {
		
	}
	
	// 외부에서 그래도 만들어진 매니저를 가져다 써야하니까~
	public static PersonManager getInstance() {
		return manager;
	}
	
	
	// 사람을 등록하는 기능
	public void regist(Person p) {
		list.add(p);
	}
	
	// 사람의 목록을 반환하는 기능
	public List<Person> getAll(){
		return list;
	}
	
	// ... 다양하게 분류를 지어 가져오도록 만들어 볼 수도 있음...
}
