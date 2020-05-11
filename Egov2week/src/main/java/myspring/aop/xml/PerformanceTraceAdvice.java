package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 * advice 클래스
 * */
public class PerformanceTraceAdvice {
	
	/*
	 * Around Advice에서 사용할 공통 기능 메서드는 대부분 파라미터로 전달 받은 ProceedingJoinPoint의 proceed()
	 * 메서드만 호출하면 된다.
	 */
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result;
		//타겟 메서드의 signature 정보
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "시작");
		
		//타겟의 메서드가 호출되기 전의 시간
		long start =System.currentTimeMillis();
		try {
			//타겟의 메서드 호출
			result = joinPoint.proceed();
			return result;
		} finally {
			// 타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + "실행 시간 : " + (finish - start) + " ms");
		}
	}
	
}
