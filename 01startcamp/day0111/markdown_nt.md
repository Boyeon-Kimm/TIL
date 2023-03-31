빽킷을 활용해서 인라인 코드를 만들 수 있어요.

# markdown 문법 필기

## heading

- h1 -> `#`  -> html `<h1>내용물</h1>`

- h2 -> `##` 

- h3 -> `###`

- h4 -> `####`

- h5 -> `#####`

- h6 -> `######`

`ctrl + 숫자` 로 전환 가능



## list

### unordered list (순서가 없는 리스트)

`*`/`-` + `tab` 

- a
  - b
    - c
      - d
        - e
          - f

`<ul></ul>`

### ordered list (순서가 있는 리스트)

`숫자` + `.`

1. 순서가 있는 리스트
2. 순서가 있는 리스트
   1. 순서가 있는 리스트 2의 1
   2. 순서가 있는 리스트 2의 2

`<ol></ol>`



## text style

### bold

`**` 볼드`**`

`ctrl`+`b`

안녕하세요 **김보연**입니다.



### italic

`*`기울기`*`

`ctrl`+`i`

안녕하세요 *김보연*입니다.



- bold + italic (***)

  - 안녕하세요 ***서울 8반***입니다.

  

## hyperlink

### link

`[텍스트](내가 가고 싶은 url)`

[구글](https://www.google.com)

[네이버](https://www.naver.com)

### img

`![대체 텍스트](내가 보여주고 싶은 이미지 url)`

![춘식이](C:\Users\SSAFY\Desktop\TIL\assets\b5d3d6a7b67fbf5afdaffb79fffbf8b18f324a0b9c48f77dbce3a43bd11ce785.png)

## Code Block

### inline code block

빽킷을 활용해서 인라인 코드 만들 수 있어요.

글1, 글2, 글3, `코드1`



### code block

빽킷을 세번 입력

```java
// c://user/SSAFY/Desktop/intro1.java 주석

class sample {
    public static void main(String args[]){
        System.out.println("Hello Java");
    }
}
```





## Table

bar | 를 이용

| 이름 | 학년 | 기수 | 전공 | 연락처 |
| ---- | ---- | ---- | ---- | ------ |
|      |      |      |      |        |
|      |      |      |      |        |
|      |      |      |      |        |
|      |      |      |      |        |
|      |      |      |      |        |

