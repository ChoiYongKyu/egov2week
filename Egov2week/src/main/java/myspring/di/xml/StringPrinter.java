package myspring.di.xml;

public class StringPrinter implements Printer {
	// 문자열 저장
	private StringBuffer buffer = new StringBuffer();

	// buffer에 문자열추가
	public void print(String message) {
		buffer.append(message);
	}

	// return 메소드
	public String toString() {
		return buffer.toString();
	}
}
