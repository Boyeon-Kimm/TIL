# 2023.04.20

# Spring Framework - Mybatis

## Spring-Mybatis

### MyBatis-Spring

- 마이바티스-스프링 연동 모듈은 둘을 간편하게 연동하도록 도와준다.
- 해당 모듈은 마이바티스로 하여금 스프링 트랜잭션에 쉽게 연동되도록 처리한다.

<br>

<br>

### MyBatis와 Spring 연동 - 1

- MyBatis와 스프링 프레임워크를 연동하기 위해서는 mybatis-spring 연동 라이브러리가 필요
- jar 파일을 추가하거나 pom.xml을 통해 추가한다

```xml
<!-- pom.xml -->

<!-- Mybatis -->
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis-spring</artifactId>
	<version>2.0.3</version>
</dependency>
```

<br>

<br>

### MyBatis와 Spring 연동 - 2

- MyBatis 실행에 필요한 객체를 Spring Bean으로 등록하여 사용
    - datasource, sqlSessionFactory

```xml
<!-- root-context.xml -->

<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	<property name="driverClassName" value="${db.driver}" />
	<property name="url" value="${db.url}" />
	<property name="username" value="${db.username}" />
	<property name="password" value="${db.password}" />
</bean>
```

```xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	<property name="dataSource" ref="dataSource" /></property>
	<property name="mapperLocations" value="classpath:dao/mapper/**/*.xml"></property>
	<property name="typeAliasesPackage" value="model" /></property>
</bean>
```

<br>
<br>

### MyBatis와 Spring 연동 - 3

- DAO 작성
- Mapper 인터페이스를 스프링 빈으로 직접 등록

```xml
<!-- root-context.xml -->

<bean id="boardDao" class="org.mybatis.spring.mapper.MapperFactoryBean">
	<property name="mapperInterface" value="dao.BoardDao></property>
	<property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
</bean>
```

- Mapper Scanner를 사용하여 등록
- basePackage에 설정된 패키지의 하위의 모든 매퍼 인터페이스가 자동으로 bean으로 등록됨

```xml
<bean id="mapperScanner" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	<property name="basePackage" value="dao"></property>
</bean>
```