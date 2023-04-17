# 2023.04.17

# Spring Framework - Interceptor

## Interceptor

### Interceptor란?

- HandlerInterceptor를 구현한 것(또는 HandlerInterceptorAdapter를 상속한 것)
- 요청(requests)을 처리하는 과정에서 요청을 가로채서 처리
- 접근 제어(Auth), 로그(Log)등 비즈니스 로직과 구분되는 반복적이고 부수적인 로직 처리
- HandlerIntercepter의 주요 메서드
    - `preHandle()`
    - `postHandle()`
    - `afterCompletion()`

<br>
<br>

### `preHandle`

```java
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception{
```

- Controller(핸들러) 실행 이전에 호출
- false를 반환하면 요청을 종료한다

<br>
<br>

### `postHandle`

```java
@Override
public boolean postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	ModelAndView modelAndView) throws Exception{
```

- Controller(핸들러) 실행 후 호출
- 정상 실행 후 추가 기능 구현 시 사용
- Controller에서 예외 발생 시 해당 메서드는 실행되지 않음

<br>

<br>

### `afterCompletion`

```java
@Override
public boolean afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	Exception ex) throws Exception{
```

- 뷰가 클라이언트에게 응답을 전송한 뒤 실행
- Controller에서 예외 발생 시, 네 번째 파라미터로 전달이 된다. (기본은 null)
- 따라서 Controller에서 발생한 예외 혹은 실행 시간 같은 것들을 기록하는 등 후처리 시 주로 사용

<br>
<br>

### Interceptor 흐름

![Untitled](2023%2004%2017%2083221d806f0940089a4d2b68d842f205/Untitled.png)

<br>

<br>

### 로그인 인터셉터 만들기

```java
package com.ssafy.mvc;

import javax.servlet.http.HttpServletReqeust;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
// HandlerInterceptorAdapter Class의 상속은 권장되지 않음(Deprecated)
import org.springframework.web.servlet.handler.HandlerInterceptorAdaptor;

// HandlerInterceptor 인터페이스 구현
public class LoginCheckInterceptor implements HandlerInterceptor{
	// preHandle 메서드 오버라이드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			response.sendRedirect(request.getContextPath() + "/login.do");
			return false;
		}
		return false;
	}
}
```

<br>
<br>

### servlet-context.xml에 bean 등록 & interceptor 매핑 설정

```java
	<!-- Resolves views selected for rendering by @Controllers to .jsp resources
		in the /WEB-INF/views directory -->
	<beans:bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>

	<context:component-scan base-package="com.ssafy.mvc" />
	// Interceptor를 bean으로 등록
	<beans:bean id="confirm" class="com.ssafy.mvc.LoginCheckInterceptor" />

	// 요청 경로(path)와 Interceptor bean을 매핑
	<interceptors>
		<interceptor>
			<mapping path="/a.do" />
			<beans:ref bean="comfirm" />
		</interceptor>
	</interceptors>

	// exclude-mapping 방식으로도 가능
	<interceptors>
		<interceptor>
			<mapping path="*" />
			<exclude-mapping path="/b.do" />
			<beans:ref bean="confirm" />
		</interceptor>
	</interceptors>

</bean:beans>
```