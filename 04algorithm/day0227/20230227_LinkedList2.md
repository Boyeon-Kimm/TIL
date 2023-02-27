# 2023.02.27

# APS기본 - 링크드리스트(Linked List)

## 연결 스택(Linked Stack)

### 리스트를 이용해 스택을 구현할 수 있다.

### 스택의 원소 : 리스트 노드

스택 내의 순서는 리스트의 링크를 통해 연결됨

- push : 리스트의 마지막 노드 삽입
- pop : 리스트의 마지막 노드 반환 / 삭제

### 변수 top

- 리스트의 마지막 노드를 가리키는 변수
- 초기 상태 : top = null

### 리스트를 이용해 push 와 pop연산 구현

1. null 값을 가지는 노드를 만들어 스택 초기화
2. 원소 A삽입 : push(A)
3. 원소 B삽입 : push(B)
4. 원소 C삽입 : push(C)
5. 원소 반환 : pop

### Push / Pop

```java
push(i) {            // 원소 i를 스택에 push
	temp = createNode();
	temp.data = i;
	temp.linke = top;
	top = temp;
}

pop() {
	temp = top
	if(top == null) return 0;
	else {
		item = temp.data;
		top = temp.link  // top이 가리키는 노드 변경
		free(temp);
		return item;
	}
}
```

## 연결 큐(Linked Queue)

### 단순 연결 리스트(Linked List)를 이용한 큐

- 큐의 원소 : 단순 연결 리스트의 노드
- 큐의 원소 순서 : 노드의 연결 순서. 링크로 연결되어 있음
- front : 첫 번째 노드를 가리키는 링크
- rear : 마지막 노드를 가리키는 링크

### 상태 표현

- 초기 상태 : front = rear = null
- 공백 상태 : front = rear = null
1. 공백 큐 생성 : createLinkedQueue();
2. 원소 A 삽입 : enQueue(A);
3. 원소 B 삽입 : enQueue(B);
4. 원소 삭제 : deQueue();
5. 원소 C 삽입 : enQueue(C);

### 초기 공백 큐 생성 : createLinkedQueue()

- 리스트 노드 없이 포인터 변수만 생성함
- front와 rear을 null로 초기화

```java
createLinkedQueue(){
	front <- null;
	rear <- null;
}
```

### 공백상태 검사 : isEmpty()

- 공백상태 : front = rear = null

```java
isEmpty(){
	if(front == null) return true;
	else return false;
}
```

### 삽입 : enQueue(item)

- 새로운 노드 생성 후 데이터 필드에 item저장
- 연결 큐가 공백인 경우, 아닌 경우에 따라 front, rear 변수 지정
- old가 가리키는 노드 삭제하고 메모리 반환

```java
deQueue(){
	if(isEmpty()) Queue_Empty();
	else {
		old <- front;
		item <- front.data;
		front <- front.link;
		if(isEmpty()) rear <- NULL;
		free(old);
		return item;
	}
}
```

### 우선순위 큐의 구현

- 배열을 이용한 우선순위 큐
- 리스트를 이용한 운선순위 큐

### 우선순위 큐의 기본 연산

- 삽입 : enQueue
- 삭제 : deQueue

### 배열을 이용하여 우선순위 큐 구현

- 배열을 이용하여 자료 저장
- 원소를 삽입하는 과정에서 우선순위를 비교하여 적절한 위치에 삽입하는 구조
- 가장 앞에 최고 우선순위의 원소가 위치하게 됨

### 문제점

- 배열을 사용하므로, 삽입이나 삭제 연산이 일어날 때 원소의 재배치가 발생함
- 이에 소요되는 시간이나 메모리 낭비가 큼

### 리스트를 이용하여 우선순위

- 연결 리스트를 이용하여 자료 저장
- 원소를 삽입하는 과정에서 리스트 내 노드의 원소들과 비교하여 적절한 위치에 노드를 삽입하는 구조
- 리스트의 가장 앞쪽에 최고 우선순위가 위치하게 됨

### 배열 대비 장점

- 삽입 / 삭제 연산 이후 원소의 재배치가 필요 없음
- 메모리의 효율적인 사용이 가능

## 삽입 정렬(Insertion Sort)

도서관 사서가 책을 정렬할 때, 일반적으로 활용되는 방식이 삽입 정렬이다.

자료 배열의 모든 원소들을 앞에서부터 차례대로 이미 정렬된 부분과 비교하여, 자신의 위치를 찾아냄으로써 정렬을 완성한다.

### 정렬 과정

- 정렬할 자료를 두 개의 부분집합 S와 U로 가정
    - 부분집합 S : 정렬된 앞부분의 원소들
    - 부분집합 U : 아직 정렬되지 않은 나머지 원소들
- 정렬되지 않은 부분집합 U의 원소를 하나씩 꺼내서 이미 정렬 되어있는 부분집합 S의 마지막 원소부터 비교하면서 위치를 찾아 삽입한다.
- 삽입 정렬을 반복하면서 부분집합 S의 원소는 하나씩 늘리고 부분집합 U의 원소는 하나씩 감소하게 한다. 부분집합 U가 공집합이 되면 삽입정렬이 완성된다.

### 시간 복잡도

- O(n^)

### 정렬 알고리즘

| 알고리즘 | 평균 수행시간 | 최악 수행시간 | 알고리즘 기법 | 비고 |
| --- | --- | --- | --- | --- |
| 버블 정렬 | O(n^) | O(n^) | 비교와 교환 | 코딩이 가장 손쉽다. |
| 선택 정렬 | O(n^) | O(n^) | 비교와 교환 | 교환의 회수가 버블, 삽입정렬보다 작다 |
| 카운팅 정렬 | O(n + k) | O(n + k) | 비교환 방식 | n이 비교적 작을 때만 가능하다 |
| 삽입 정렬 | O(n^) | O(n^) | 비교와 교환 | n이 개수가 작을 때 효과적이다 |
|  병합 정렬 | O(n log n) | O(n log n) | 분할 정복 | 연결리스트의 경우 가장 효율적인 방식 |
| 퀵 정렬 | O(n log n) | O(n^) | 분할 정복 |  최악의 경우 O(n^)이지만, 평균적으로는 가장 빠르다. |