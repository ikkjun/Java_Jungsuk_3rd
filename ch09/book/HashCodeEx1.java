package Examples;

public class HashCodeEx1 {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		String str3 = "qwerty";
		String str4 = "qwerty";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println("str3: "+System.identityHashCode(str3));
		System.out.println("str4: "+System.identityHashCode(str4));
		if(str1 == str2) System.out.println("str1 == str2" + true);
		if(str3 == str4) System.out.println("str3 == str4 ? " + true);
	}

}
