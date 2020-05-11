package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {

		// 1. IoC 컨테이너 생성
		ApplicationContext context =
				// 설정파일을 인자로 설정 (경로)
				//(interface인 ApplicationContext를 구현한 GenericXmlApplicationContext)
				new GenericXmlApplicationContext("config/beans.xml");

		// 2. Hello Bean 가져오기( bean id = hello ) id값만주기때문에 Hello로 casting해줘야한다.
		Hello hello = (Hello) context.getBean("hello");
		System.out.println("hello bean = " + hello.sayHellow());
		hello.print();
		// 3. SpringPrinter Bean 가져오기
		Printer printer = (Printer) context.getBean("printer");
		System.out.println("printer bean = " + printer.toString());

		// IoC 컨테이너가 SingleTon 형태로 관리하는지 Test (true)
		// bean id만 가져오거나 해당하는 클래스 타입을 줄수도 있음
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print();
		
		System.out.println(hello == hello2);
	}
}
