package 예제12_11;

import java.util.ArrayList;

class NewClass {
	int newField;
	int getNewField() {
		return newField;
	}
	
	@Deprecated
	int oldField;
	
	@Deprecated
	int getOldField() {
		return oldField;
	}
}

public class AnnotationEx3 {
	@SuppressWarnings("deprecation")	// deprecation관련 경고를 억제

	public static void main(String[] args) {
		NewClass nc = new NewClass();
		nc.oldField = 10;
		System.out.println(nc.getOldField());
		
		@SuppressWarnings("unchecked")
		ArrayList<NewClass> list = new ArrayList();	// 타입을 지정하지 않음
		list.add(nc);
	}

}
