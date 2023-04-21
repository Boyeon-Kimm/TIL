# 2023.04.21

# Spring Framework -Java Config & 동적 SQL

## Java Config

### Spring DI

- XML
- Annotation
- Java

<br>

<br>

### Java Config

```java
@Configuration
public class ApplicationConfig{
	@Bean
	public Desktop desktop(){
		return new Destop();
	}
	@Bean
	public Laptop laptop(){
		return new Laptop();
	}
}
```

```java
@Configuration
@ComponentScan(basePackages = {"com.ssafy.di"})
public class ApplicationConfig{
}
```

```java
public class Test{
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
```

<br>
<br>

## MyBatis - 동적 SQL

### 동적 SQL

- Runtime 시점에서 사용자의 입력 값에 따라 동적으로 SQL을 생성하여 실행하는 방식
- JDBC나 다른 Framework 사용 시 어려움을 느낄 수 있음.
- MyBatis는 이를 편리하게 사용할 수 있게 도움을 줌.
- JSTL이나 XML 기반의 텍스트 프로세서를 사용해본 사람에게는 친숙할 것이다.

<br>
<br>

### MyBatis 동적 SQL 종류

- if
- choose(when, otherwise)
- trim(where, set)
- foreach

<br>
<br>

### Spring TX

- 데이터 무결성을 위해서 사용
- 스프링에서 제공하는 트랜잭션 기능을 활용할 수 있음
- jar or pom.xml 을 이용하여 등록

```java
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-tx</artifactId>
	<version>${org.springframework-version}</version>
</dependency>
```

<br>
<br>

### Spring TX 사용

- 트랜잭션 관리자 설정

```java
<bean id="transactionManager"
	class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	<constructor-arg ref="dataSource"></constructor-arg>
</bean>
```

- 어노테이션 기반 트랜잭션 설정

```java
<tx:annotation-driven transaction-manager="transactionManager"/>
```

- 메소드나 클래스에 `@Transactional` 이 선언되어 있으면, AOP를 통해 트랜잭션 처리

```java
@Transactional
public int insert(Movie movie){
	return movieDao.insert(movie);
}
```