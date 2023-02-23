# Comparable & Comparator

|  | Comparable | Comparator |
| --- | --- | --- |
|  | 인터페이스 | 인터페이스 |
| 재정의 | compareTo(T o) 메소드 구현 | compare(T o1, o2) 메소드 구현 |
| 파라미터 개수 | 1 | 2 |
| 비교 대상 | 자기 자신과 매개변수 객체비교 | 두 매개변수 객체를 비교 |

### Comparable

```java
class Student implements Comparable<Student> {
 
	int age;			// 나이
	int classNumber;	// 학급
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compareTo(Student o) {
    
		// 자기자신의 age가 o의 age보다 크다면 양수
		if(this.age > o.age) {
			return 1;
		}
		// 자기 자신의 age와 o의 age가 같다면 0
		else if(this.age == o.age) {
			return 0;
		}
		// 자기 자신의 age가 o의 age보다 작다면 음수
		else {
			return -1;
		}
	}
}
```

### Comparator

```java
import java.util.Comparator;
 
public class Test {
	public static void main(String[] args)  {
 
		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반
		Student c = new Student(15, 3);	// 15살 3반
			
		// a객체와는 상관 없이 b와 c객체를 비교한다.
		int isBig = a.compare(b, c);
		
		if(isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}
		
	}
}
 
class Student implements Comparator<Student> {
 
	int age;			// 나이
	int classNumber;	// 학급
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compare(Student o1, Student o2) {
		return o1.classNumber - o2.classNumber;
	}
}
```

### Comparator 비교 기능만 따로 두고싶다면?

> 익명의 객체(클래스)를 활용한다
이름이 정의되지 않은 객체
>