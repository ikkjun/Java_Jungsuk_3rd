package Exercise;

public class Exercise9_1 {

	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c1.equals(c2):" + c1.equals(c2));
	}

}

class SutdaCard {
	int num;
	boolean  isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	/* 매개변수로 넘겨진 객체의 num, isKwang과 
	 * 멤버변수 num, isKwang을 비교하도록 오버라이딩 하시오.
	 */
	public boolean equals(Object obj) {
		
		/* 형 변환 가능한지 확인 */
		if(obj instanceof SutdaCard) {
			
			/** 형변환 가능하면 매개변수로 들어온 값을 SutdaCard로 형변환
			 *  형변환 후 멤버변수 num, isKwang과 비교
			 */
			
			SutdaCard s = (SutdaCard)obj;
			if(this.isKwang == s.isKwang && this.num == s.num)
				return true;
		}
		return false;
	}
	
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}