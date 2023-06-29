# 데이터 모델링

## 엔티티-관계(Entity-Relationship) 모델

### ER(Entity-relationship) 데이터 모델

- 개념적 데이터 모델
- 엔티티(Entity), 애트리뷰트(Attribute), 관계(Relationship)을 이용해서 실세계를 개념적으로 표현하는 기법

<br>

### ER 모델의 구성 요소

- 엔티티(Entity)
- 애트리뷰트(Attribute)
- 관계(Relationship)

<br>

### 엔티티(Entity)

- 모델의 관리 대상
- 사람과 물건, 장소 같은 실체가 있는 것이나 개념을 엔티티로 선택
- 시스템 구축 단계까지 진행되면 파일이나 데이터베이스의 테이블로 구현
- ER 다이어그램에서는 사각형으로 표현
- 실제로 존재하는 대상들
- ER 모델에서 가장 기본이 되며, 고유하게 식별이 되어야만 한다.
- 엔티티 예시

| 분야별 | 가능한 엔티티 |
| --- | --- |
| 사람 | 학생, 교수, 사원 |
| 장소 | 학교, 강의실 |
| 사물 | 교과서, 생산 제품 |
| 사건 | 강의, 면담 |
| 개념 | 강좌, 과목, 프로젝트 |

<br>

### 애트리뷰트(Attribute)

- 엔티티의 구성 요소
- ER 다이어그램에서는 타원으로 표현
- 엔티티 또는 관계가 갖는 성질이나 특성
- 엔티티는 반드시 하나 이상의 키 애트리뷰트를 갖고 있어서 나머지 애트리뷰트를 유일하게 정의할 수 있다

<br>

### 관계(Relationship)

- 엔티티 간의 관계를 나타내는 것으로 1:1, 1:N, M:N 관계를 표현
- 관계는 관계형 데이터베이스로 매핑(Mapping, 사상)되는데 ER 다이어그램에서는 마름모로 표현

<br>

### 엔티티 타입(Entity Type)

- 여러 엔티티가 모여서 하나의 집단을 이룬 형태
- ER 다이어그램에서 엔티티 타입은 사각형으로 표현
- 강한 엔티티 타입
- 약한 엔티티 타입 : 자신의 키 애트리뷰트가 없는 엔티티 타입

<br>

### 단순 애트리뷰트(Simple Attribute)

- 학생 (학생 엔티티에 대한 애트리뷰트들)
    - 학번
    - 주소
    - 이름
    - 생년월일

<br>

### 키 애트리뷰트(Key Attribute)

- 엔티티들을 식별할 수 있는 유일한 제약조건을 갖는 애트리뷰트

<br>

### 복합 애트리뷰트(Composite Attribute)

- 두 개 이상의 애트리뷰트로 이루어진다
- 각각의 애트리뷰트는 그 자체로도 독립적인 의미가 있다
- 주소 (복합 애트리뷰트)
    - 시
    - 구
    - 동
    - 아파트 번호

<br>

### 다치 애트리뷰트(Multivalue Attribute)

- 애트리뷰트 하나에 여러 값이 들어갈 수 있는 애트리뷰트
- ex : 보유 기술

<br>

### 유도된 애트리뷰트(Derived Attribute)

- 애트리뷰트에 실제 값이 저장되어 있는 것이 아니라 저장된 값으로부터 계산해서 얻은 값을 사용하는 애트리뷰트
- ex : 나이

<br>

### 부분 키(Partial Key)

- 키와 비슷하지만 완벽하게 키라고는 할 수 없고 약한 엔티티에서만 사용되는데, 키 애트리뷰트에 반해서 부분키라고 한다.
- 부분키는 ER 다이어그램에서 점선으로 밑줄을 그어서 표현

![Untitled](./ERD_data/Untitled.png)

<br>

### 관계 타입

- 엔티티 타입 간의 관계를 표현할 때 사용
- 엔티티 간에 존재하는 수학적 관계를 말한다
- ER 다이어그램에서 마름모를 사용하여 표현

<br>

### 카디널리티 비율(Cardinality Ratio)

- 두 엔티티 타입 사이의 관계에서 참여자의 수를 표현하는 것
- 1:1, 1:N, M:N 등이 있다
- ER 다이어그램에서는 실선 위에 1 또는 N을 표기해서 구분

<br>

### 전체 참여와 부분 참여

- 전체 참여는 두 줄로 표현하고 부분 참여는 한 줄로 표현한다

<br>

### 관계 타입 차수

- 참여하고 있는 엔티티 타입의 개수
- 순환적 관계 : 차수가 1인 관계

![Untitled](./ERD_data/Untitled%201.png)

<br>

[[2장 데이터 모델링] 2. 엔티티-관계(Entity-Relationship) 모델](https://www.youtube.com/watch?v=qm8cqItjIPo)

[관계형 데이터 모델링 - 4.3. ERD의 구성요소](https://www.youtube.com/watch?v=E6LbuLoU6rc)