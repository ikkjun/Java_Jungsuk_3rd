package book;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx4 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));
		set.add(new Person2("David",10));
		
		System.out.println(set);
	}

}

class Person2 {
	String name;
	int age;
	
	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person2)) return false;
		return ((Person2)obj).age == this.age && ((Person2)obj).name == this.name;
	}
	
	public String toString() {
		return name + ":" + age;
	}
	
	
}