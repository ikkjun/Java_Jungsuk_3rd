package 예제12_9;

class Parent {
	void parentMethod() { }
}

class Child extends Parent {
	@Override
	void parentmethod() {}	// 조상메서드의 이름을 잘못 적었음.
}