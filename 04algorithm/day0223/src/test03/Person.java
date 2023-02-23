package test03;

public class Person implements Comparable<Person>{
	public String name;
	public int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		// 나이 순으로?
//		return this.age - o.age;
		
		// 이름 순으로?
		return this.name.compareTo(o.name);
	}
	
	
	
}
