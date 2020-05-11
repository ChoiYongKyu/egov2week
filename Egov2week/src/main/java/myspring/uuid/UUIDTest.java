package myspring.uuid;

import java.util.UUID;


/*
 * UUID 클래스를 사용해서 유일한 식별자 생성
 * ex)
 * 1. 업로드된 파일명의 중복을 방지하기 위해 파일명을 변경할 때 사용
 * 2. 첨부파일 파일다운로드시 다른 파일을 예측하여 다운로드하는것을 방지하는데 사용.
 * 3. 일련변호 대신 유추하기 힘든 식별자를 사용하여 다른 컨텐츠의 이믜 접근을 방지하는데 사용.
 * */
public class UUIDTest {
	public static void main(String[] args) {
		UUID one = UUID.randomUUID();
		UUID two = UUID.randomUUID();
		
		System.out.println("UUID One: " + one.toString());
		System.out.println("UUID Two: " + two.toString());
	}

}
