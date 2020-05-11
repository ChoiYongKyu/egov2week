package myspring.di.xml;

import java.util.List;
import java.util.Map;

public class Hello {
	
	//멤버변수 name 
	private String name;
	//멤버변수 Printer 타입 printer
	private Printer printer;
	//멤버변수 컬렉션 타입(list) names;
	private List<String> names;
	//멤버변수 컬렉션 타입(map) ages;
	private Map<String,Integer> ages;
	//기본 생성자
	public Hello() {}
	
	//2개의 멤버 변수를 인자값으로 가지고있는 생성자
	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	public void setAges(Map<String, Integer> ages) {
		this.ages = ages;
	}

	//String 타입의 Hello 문자열과 + 멤버변수 name 값을 리턴
	public String sayHellow() {
		return "Hello " + name;
	}
	
	//Printer 인터페이스의 print 메서드를 호출해주는 메서드
	public void print() {
		this.printer.print(sayHellow());
	}
	
}
