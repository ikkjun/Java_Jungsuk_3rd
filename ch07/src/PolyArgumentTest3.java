import java.util.*;	// Vector클래스를 사용하기 위해서 추가해 주었다.

class Product3 {
	int price;
	int bonusPoint;
	
	Product3(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	Product3() {
		price = 0;
		bonusPoint = 0;
	}	// 기본 생성자
}

class Tv3 extends Product3 {
	Tv3() {
		// 조상 클래스의 생성자 Product(int price)를 호출한다.
		super(100);
	}
	//Object 클래스의 toString()을 오버라이딩한다.
	public String toString() {return "Tv";}
}

class Computer3 extends Product3 {
	Computer3() { super(200); }
	public String toString() { return "Computer"; }
}

class Audio3 extends Product3 {
	Audio3() { super(50); }
	public String toString() {return "Audio";}
}
class Buyer3 {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();			// 구입한 제품을 저장하는 데 사용될 Vector객체
	
	void buy(Product3 p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item.add(p);					// 구입한 제품을 Vector에 저장한다.
		System.out.println(p+"을/를 구입하셨습니다.");
	}
	
	void refund(Product3 p) {
		if(item.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p+"을/를 반품하셨습니다.");
		} else {
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		if(item.isEmpty()) {		// Vector가 비어있는지 확인한다.
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i = 0;i<item.size();i++) {
			Product3 p = (Product3)item.get(i);	// Vector의 i번째 있는 객체를 얻어온다.
			sum += p.price;
			itemList += (i==0)?""+p:", "+p;
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}
public class PolyArgumentTest3 {

	public static void main(String[] args) {
		Buyer3 b = new Buyer3();
		Tv3 tv = new Tv3();
		Computer3 com = new Computer3();
		Audio3 audio = new Audio3();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
		
		System.out.println("현재 남은 돈은 "+b.money + "만원입니다.");
		System.out.println("현재 보너스 점수는 "+b.bonusPoint + "점입니다.");
	}

}
