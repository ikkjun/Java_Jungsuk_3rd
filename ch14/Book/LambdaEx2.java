package 예제14_2;

@FunctionalInterface
interface MyFunction {
	void myMethod();
}

public class LambdaEx2 {

	public static void main(String[] args) {
		MyFunction f = () ->{};	// MyFunction f = (MyFunction)(() -> {});
		Object obj = (MyFunction)(()->{});	// Object 타입으로 형변환이 생략됨
		String str = ((Object)(MyFunction)(()->{})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(()->{}););	// 에러. 람다식은 Object타입으로 형변환 안 됨
		System.out.println((MyFunction)(()->{}));
//		System.out.println((MyFunction)(()->{}).toString());	// 에러
		System.out.println(((Object)(MyFunction)(()->{})).toString());
	}

}
