
public class OperatorEx16 {

	public static void main(String[] args) {
		float pi = 3.141592f;
		float shortPi = (int)(pi*1000) / 1000f;
		System.out.println(shortPi);
		// int / int를 수행함ㄴ 결과가 float나 double이 아닌 int이다.
		// 위의 수식에서 제일 먼저 수행되는 것은 괄호 안의 'pi*1000'이다. -> 3141.592f
		// 그 다음으로는 단항연산자인 형변환 연산자의 형변환이 수행된다. 3141.592f를 int로 변환하면 3141을 얻는다.
		// int와 float의 연산이므로 int가 float로 변환된 다음, float와 float의 연산이 수행된다. 따라서 결과는 3.131f
	}

}
