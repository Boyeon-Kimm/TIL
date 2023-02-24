# 2023.02.24

# APS기본 - 링크드리스트(LinkedList)

## 연결리스트

### 특성

- 자료의 논리적인 순서와 메모리 상의 물리적인 순서가 일치하지 않고, 개별적으로 위치하고 있는 원소의 주소를 연결하여 하나의 전체적인 자료구조를 이룬다.
- 링크를 통해 원소에 접근하므로, 순차 리스트에서처럼 물리적인 순서를 맞추기 위한 작업이 필요하지 않다.
- 자료구조의 크기를 동적으로 조정할 수 있어, 메모리의 효율적인 사용이 가능하다.

### 노드

- 연결 리스트에서 하나의 원소에 필요한 데이터, 주소값을 갖고 있는 자료단위
- 구성 요소
    - 데이터 필드
        - 원소의 값을 저장하는 자료구조
        - 저장할 원소의 종류나 크기에 따라 구조를 정의하여 사용함
    - 링크 필드
        - 다음 노드의 주소를 저장하는 자료구조
    

### 헤드

- 리스트의 처음 노드를 가리키는 레퍼런스

![Untitled](2023%2002%2024%20e8976f5c7cf94ef686a97e6436bb5867/Untitled.png)

### ArrayList & LinkedList & Vector 시간 비교

![Untitled](2023%2002%2024%20e8976f5c7cf94ef686a97e6436bb5867/Untitled%201.png)

```java
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
```

- ArrayList
    - 삽입, 삭제가 덜 일어나는대신 조회는 많이 일어날 때 용이
- LinkedList
    - 삽입, 삭제 빈번 / 조회는 많지 않을 때 용이

## 단순 연결 리스트(Singly Linked List)

### 연결 구조

- 노드가 *하나의 링크 필드*에 의해 다음 노드와 연결되는 구조를 가진다
    - Singly 링크가 하나, 한쪽 방향으로만 연결된 것
- 헤드가 가장 앞의 노드를 가리키고, 링크 필드가 연속적으로 다음 노드를 가리킨다.
- 최종적으로 NULL을 가리키는 노드가 리스트의 가장 마지막 노드이다.
- 다음 노드에 접근하기 위해서는 직전 노드를 통해서 접근할 수 밖에 없다.

![Untitled](2023%2002%2024%20e8976f5c7cf94ef686a97e6436bb5867/Untitled%202.png)

### ‘A’, ‘C’, ‘D’를 원소로 갖고 있는 리스트의 두번째에 ‘B’ 노드를 삽입할 때

1. 메모리를 할당하여 새로운 노드 new 생성
2. 새로운 노드 new의 데이터 필드에 ‘B’ 저장
3. 삽입될 위치의 바로 앞에 위치한 노드의 링크 필드를 new에 복사
    1. ‘B’ 에 ‘C’를 먼저 연결한 뒤 ‘B’에 ‘A’를 연결한다.
4. new의 주소를 앞 노드의 링크 필드에 저장

### 첫 번째 노드로 삽입하는 알고리즘

```java
addtoFirst(L, i) {     // 리스트 포인터 L == head, 원소 i
	new <- createNode(); // 새로운 노드 생성
	new.data = i;        // 데이터 필드 작성
	new.link = L;        // 링크 필드 작성
	L = new;             // 리스트의 처음으로 지정
}
```

### 가운데 노드로 삽입하는 알고리즘

- 노드 pre의 다음 위치에 노드 삽입

```java
add(L, pre, i)            // 리스트 L, 노드 pre, 원소 i
	new <- createNode();    // 새로운 노드 생성
	new.data = i;           // 데이터 필드 작성
	if(L == NULL) {
		L = new;
		new.link = NULL:
	} else {
		new.link = pre.link;
		pre.link = new;
	}
```

### 마지막 노드로 삽입하는 알고리즘

- 마지막 노드 찾기(현재)
- 마지막 노드가 새로운 마지막 노드를 가리키도록
- temp 변수 : 현재 노드의 주소값
    - [temp.link](http://temp.link) : 다음 노드 주소값
        - [temp.link](http://temp.link) ≠ null ⇒ temp = temp.link

```java
addtoLast(L, i)              // 리스트 L, 원소 i
	new <- createNode();       // 새로운 노드 생성
	new.data = i;
	new.link = NULL;
	if(L == NULL) {            // 빈 리스트일 때(head == null), 최초 노드 추가
		L = new;
		return;
	} 
	temp = L;                  // 노드 링크 이용하여 리스트 순회
	while(temp.link != NULL){  // 마지막 노드 찾을 때까지 이동(다음 노드의 주소값이 있다면)
		temp = temp.link;        // 그 다음 노드의 주소값을 덮어쓴다
	}                          // while이 종료되었다는 것은 temp.link == NULL
	temp.link = new;           // 마지막 노드 추가
```

### ‘A’, ‘B’, ‘C’, ‘D’ 리스트의 ‘B’ 노드를 삭제할 때

1. 삭제할 노드의 앞 노드(선행노드) 탐색
    1. B를 삭제하고 싶다면 B를 통해서 C의 주소값을 알아야 함
    2. A가 C를 가리키도록
2. 삭제할 노드의 링크 필드를 선행노드의 링크 필드에 복사

### 노드를 삭제하는 알고리즘

- 노드 pre의 다음 위치에 있는 노드 삭제

```java
delete(L, pre) {                // 리스트 L, 노드 pre
	if(L == NULL) error;
	else {
		target = pre.link;          // 삭제 노드 지정
		if(target == NULL) return;
		pre.link = target.link;
	}
	freeNode(target)              // 할당된 메모리 반납
}
```

## 이중 연결 리스트(Doubly Linked List)

### 특성

- 양쪽 방향으로 순회할 수 있도록 노드를 연결한 리스트
- 두 개의 링크 필드와 한 개의 데이터 필드로 구성

![Untitled](2023%2002%2024%20e8976f5c7cf94ef686a97e6436bb5867/Untitled%203.png)

### 연결 구조

![Untitled](2023%2002%2024%20e8976f5c7cf94ef686a97e6436bb5867/Untitled%204.png)

### cur가 가리키는 노드 다음으로 D값을 가진 노드를 삽입하는 과정

1. 메모리를 할당하여 새로운 노드 new를 생성하고 데이터 필드에 ‘D’를 저장한다.
2. cur의 next를 new의 next에 저장하여 cur의 오른쪽 노드를 삽입할 노드 new의 오른쪽 노드로 연결한다.
3. new의 주소를 cur의 next에 저장하여 노드 new를 cur의 오른쪽 노드로 연결한다.
4. cur에 있는 링크 값을 new의 prev에 저장하여 cur를 new의 왼쪽 노드로 연결한다.
5. new의 주소를 new의 오른쪽 노드의 prev에 저장하여 노드 new의 오른쪽 노드의 왼쪽 노드로 new를 연결한다.

### cur가 가리키는 노드를 삭제하는 과정

1. 삭제할 노드 cur의 오른쪽노드의 주소를 cur의 왼쪽노드의 next에 저장하여  cur의 오른쪽노드를 cur의 오른쪽노드를 cur의 왼쪽노드의 오른쪽노드로 연결한다.
2. 삭제할 노드 cur의 왼쪽노드의 주소를 cur의 오른쪽노드의 prev에 저장하여 cur의 왼쪽노드를 cur의 오른쪽노드의 왼쪽노드로 연결한다.
3. cur가 가리키는 노드에 할당된 메모리를 반환한다.