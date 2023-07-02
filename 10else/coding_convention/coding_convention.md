# 코딩 컨벤션 적용

### 코딩 컨벤션이란?

읽고 관리하기 쉬운 코드를 작성하기 위한 일종의 코딩 스타일 규약

<br>

### 코딩 컨벤션이 필요한 이유

다수의 개발자가 각자의 스타일로 코드를 작성한다고 하면 남의 코드를 이해하는데 시간이 오래걸리고 남이 작성한 코드에 대해 잘못 이해할 수 있음. 이러한 사유로 사전에 코드의 스타일을 통일함으로써 협업에 용이함. 

<br>

### 코딩 컨벤션의 필요 요소

- 파일의 구성
- Naming Convention
- 들여쓰기
- 주석
- 선언
- 명령문
- 공백

<br>

<br>

## 파일의 구성

### 파일의 구성

자바 소스 파일은 여러 section을 식별하는 주석으로 구성

2천 줄 이상의 긴 파일로 구성되는 것을 지양

소스 파일의 순서는…

1. 주석(Beginning Comments)
2. 패키지 및 import문
3. 클래스 및 인터페이스

<br>

<br>

## Naming Convention

### 패키지는 소문자로

⭐ 패키지의 이름은 소문자로 작성한다

⭐ 단어의 구분을 위해 `_` 및 대문자를 혼용하지 않는다

```java
// 나쁜 예
package com.navercorp.apiGateway
package.com.navercorp.api_gateway

// 좋은 예
package.com.navercorp.apigateway
```

<br>

### 클래스는 Camel Case

⭐ 클래스 이름은 Camel Case를 사용한다

⭐ 합쳐지는 단어의 첫 글자를 대문자로 표기하는 것을 의미

```java
// 나쁜 예
public class reservation
public class Accesstoken

// 좋은 예
public class Reservation
public class AccessToken
```

<br>
<br>

### 메소드는 동사로 시작

⭐ 메소드 명은 기본적으로 동사로 시작하며..

⭐ 다른 타입으로 변환하는 메소드는 전치사로 시작할 수 있음

```java
// 좋은 예
동사 사용 : renderHtml()
변환 메소드의 전치사 : toString()
```

<br>

### 상수는 대문자

⭐ 상수 이름은 대문자로 작성하며, 합성어는 `_` 를 사용하여 단어 구분

```java
// 좋은 
public final int UNLIMITED = -1;
public final String POSTAL_CODE_EXPRESSION = "POST";
```

<br>

### 가독성 있는 변수명

⭐ 임시 변수 외에는 1글자 변수 명 사용 금지

⭐ 이해하기 쉬운 변수 명으로 작성한다

```java
// 나쁜 예
HtmlParser p = new HtmlParser();

// 좋은 예
HtmlParser parser = new HtmlParser();
```

<br>
<br>

## 선언

클래스 등의 소스 구성 요소를 선언할 때 고려해야 할 규칙

### 클래스 import 시에는..

⭐ 클래스 import시에는 와일드카드 `*` 없이 필요한 클래스 명을 명시적으로 작성

```java
// 나쁜 예(성능에 영향을 줄 수 있음)
import java.util.*;

// 좋은 예
import java.util.List;
import java.util.ArrayList;
```

<br>

### 하나의 선언문에는 하나의 변수

⭐ 변수 선언문은 한 문장에서 하나의 변수만을 다룬다

⭐ 주석 사용을 위해 한 줄에 하나씩 선언하는 것을 권장

```java
// 나쁜 예
int base, weight;

// 좋은 예
int level; // indentation level
int size; // size of table
```

<br>
<br>

## 들여쓰기

코드의 계층을 구분하기 위해 추가

⭐ 탭을 사용하여 들여쓴다(스페이스 사용하지 않음)

⭐ 1개의 탭 사이즈는 4개의 스페이스와 같도록 에디터 설정

⭐ 클래스, 메소드, 제어문 등의 block이 생길 때 마다 1단계 들여쓰기

<br>

### 구글 코드 컨벤션, IDE 적용

⭐ 구글에서 xml파일을 제공해주고 있어 IDE에 설정해두면 편하게 적용가능.

⭐ “구글 깃허브”에서 필요한 언어와 IDE 환경에 맞는 파일을 다운로드 (자바와 인텔리제이의 조합: intellij-java-google-style.xml)

⭐ File → Setting → Editor → Code Style에서 설정

<br>
<br>

### 명명 규칙

⭐ 변수와 함수의 이름을 정할 때는 FE 개발랩에서는 camel case를 사용한다.

⭐ 예약어를 사용하지 않는다

```jsx
⭐ 상수는 영어 대문자 snake case 사용
SYMBOLIC_CONSTANTS;

⭐ 생성자는 대문자 camel case 사용
class ConstructorName {
	...
};

⭐ 변수, 함수에는 camel case 사용
// 숫자, 문자, 불린
let dog;
let variableName;

// 배열 - 배열은 복수형 이름을 사용
const dogs = [];

// 정규표현식 - 정규표현식은 'r'로 시작
const rDesc = /.*/;

// 함수
function getPropertyName() {
	...
}

// 이벤트 핸들러 - 이벤트 핸들러는 'on'으로 시작
const onClick = () => {};
const onKeyDown = () => {};

// 불린 반환 함수 - 반환 값이 불린인 함수는 'is'로 시작
let isAvailable = false;
```

<br>

⭐ Private 변수명은 `_` 로 시작한다

```jsx
let _privateVariableName;
let _privateFunctionName;

// 객체일 경우
const customObjectName = {};
customObjectName.propertyName();
customObjectName. privatePropertyName;
_privateCustomObjectName;
_prviateCustomObjectName. privatePropertyName;
```

<br>

### 선언과 할당

변수 : 값이 변하지 않는 상수는 const, 값이 변하는 변수는 let으로 선언한다

⭐ `const` 를 `let` 보다 위에 선언한다(코드가 정리되어 가독성이 좋아짐)

```jsx
// 나쁜 예
let foo;
let i = 0;
const len = this._array.length;
let bar;

// 좋은 예
const len = this._array.length;
const len2 = this._array2.length;
let i = 0;
let j = 0;
let foo, bar;
```

⭐ `const` 와 `let` 은 사용 시점에 선언 및 할당을 한다

⭐ 선언과 할당의 분리를 허용하는 경우 선언만 하는 변수는 `var` 을 한 번만 사용하는 방식을 허용한다

```jsx
// 나쁜 예
var foo,
		bar,
		quux;

// 좋은 예 - 선언만 하는 변수, 한 줄로 연결
var foo, bar, quux;

// 좋은 예
var foo;
var bar;
var quux;
```