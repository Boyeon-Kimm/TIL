# string, char

## char을 Scanner 통해 입력받는 방법

- int와 string과는 달리 char은 Scanner를 통해 바로 입력받는 방법이 없다.

### charAt()

- next()를 통해 String을 Scanner로 받은 다음, charAt(0)으로 char형으로 바꿔주는 방법 사용
    - 여기서 (0)은 문자의 위치를 말한다.

1 )

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		char c = s.charAt(0);
		
		System.out.println(c);
	}
}
```

2 )

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char c = sc.next().charAt(0);
		
		System.out.println(c);
	}
}
```

### String.toCharArray()

문자열을 한 글자씩 쪼개서 `char[ ]` 에 넣어주는 메소드

- String(문자열)을 char형 배열로 바꾼다

```java
String s1 = "Hello World!";
char[] charArr = s1.toCharArray();

// 공백도 포함한다. 배열 안에 공백도 들어가있음
System.out.println(charArr[5]); // ← 공백출력
```

- 추가로, char형 배열을 합쳐서 하나의 String(문자열)로 만들 수 있다.

```java
String s2 = new String(charArr);
```

### String.split()

- 한 글자씩  배열에 저장

```java
String str = "hello";
String[] arr = str.split("");
```

- 단어를 기준으로 배열에 저장

```java
String str = "hello";
String[] arr = str.split(" ");
```

- 특정한 구분자를 기준으로 배열에 저장

```java
String str = "hello, world";
String[] arr = str.split(",");
```

- 최대 분할 개수 지정하여 배열에 저장

```java
String str = "helloworld";
String[] arr = str.split("", 2);
// arr[0] == h, arr[1] == e 까지 저장
```