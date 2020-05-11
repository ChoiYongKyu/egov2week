package myspring.aop.annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/*
 * 어노테시연을 이용한 AOP의 구현방법
 * 클래스 선언부에 @Aspect 어노테이션을 정의한다.
 * 이클래스를 애스펙트로 사용하려면 Bean 으로 등록해야한다 
 * 그러므로 @Component (개발자가 작성한 클래스를 Bean으로 등록하기위해서)어노테시연도 정의한다.
 * */
@Component
@Aspect
public class LoggingAspect {
	/*
	 * -@Before 어드바이스를 이용해서 실행되는 타겟 객체의 메서드명과 파라미터를 출력하는 어드바이스다. 
	 * -아래의 before 메서드는 myspring 패키지 또는 그 하위 패키지에 있는 
	 * 모든 public 메서드가 호출되기 이전에 호출된다.
	 */
	@Before("execution(public * myspring..*(..))")
	public void before(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@Before [" + signatureString + "] 메서드 실행 전처리 수행");
		for(Object arg:joinPoint.getArgs()) {
			System.out.println("@Before [" + signatureString + "] 아규먼트" + arg);
		}
	}

	/*
	 * -@AfterReturning 어드바이스를 이용해서 실행되는 타겟 객체의 메서드명과 리턴값을 출력하는 어드바이스이다.
	 * -아래의 afterReturning 메서드는 myspring.user.service 패키지 하위에 있는 모든 public 메서드가 정상
	 * 종료된 이후에 호출된다.
	 * -리턴값을 참조할 때는 returning 속성을 이용해서 리턴 값을 담을 변수 이름을 지정해야 한다.
	 */
	@AfterReturning(pointcut="execution(public * myspring.user.service.*.*(..))",returning="ret")
	public void afterReturning(JoinPoint joinPoint, Object ret) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [" + signatureString + "] 메서드 실행 후처리 수행");
		System.out.println("@AfterReturning [" + signatureString + "] 리턴값 = "+ret);
	}
	/*
	 * -@AfterThrowing 어드바이스를 이용해서 실행되는 타겟 객체의 메서드명과 예외 메시지를 출력하는 어드바이스이다. 
	 * -아래의 afterThrowing 메서드는 클래스명이 UserService로 시작되는 클래스에 속한 모든 메서드가 예외가 발생된 이후에
	 * 호출된다. 
	 * -발생된 예외를 참조할 때는 throwing 속성을 이용해서 예외 객체를 담을 변수 이름을 지정해야 한다.
	 */

	
	@AfterThrowing(pointcut="execution(* *..UserService*.*(..))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing [" + signatureString + "] 메서드 실행 중 예외 발생");
		System.out.println("@AfterThrowing [" + signatureString + "] 예외 = "+ex);
	}
	
	/*
	 * -@After 어드바이스를 이용해서 실행되는 타겟 객체의 메서드명을 출력하는 어드바이스이다. 
	 * -아래의 afterFinally 메서드는 메서드명이 User로 끝나는 메서드들이 정상 종료됐을 때와 예외가 발생했을 때 모두 호출된다.
	 * -반드시 반환해야 하는 리소스가 있거나 메서드 실행 결과를 항상 로그로 남겨야 하는 경우에 사용할 수 있다.
	 * 하지만 리턴 값 이나 예외를 직접 전달받을 수는 없다.
	 * 
	 * 정상이나 예외 둘다 호출이된다
	 */
	@After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@After [" + signatureString + "] 메서드 실행 완료");
	}
}
