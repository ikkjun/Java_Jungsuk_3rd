
public class Exercise14_2 {

	public static void main(String[] args) {
		System.out.print("(String s) -> s.length()			=> ");
		System.out.println("String::length");
		System.out.print("() -> new int[]{}				=> ");
		System.out.println("int[]::new");
		System.out.print("arr -> Arrays.stream(arr)			=> ");
		System.out.println("Arrays::stream");
		System.out.print("(String str1, String str2) -> str1.equals(str2)	=> ");
		System.out.println("String::equals");
		System.out.print("(a, b) -> Integer.compare(a,b)			=> ");
		System.out.println("변환불가");
		System.out.print("(String kind, int num) -> new Card(kind, num)	=> ");
		System.out.println("변환 불가");
		System.out.print("(x) -> System.out.println(x)			=> ");
		System.out.println("System::print");
		System.out.print("()->Math.random()				=> ");
		System.out.println("Math::random");
		System.out.print("(str)->str.toUpperCase()			=> ");
		System.out.println("String::toUpperCase");
		System.out.print("()->new NullPointerException()			=> ");
		System.out.println("변환불가");
		System.out.print("(Optional opt)->opt.get()			=> ");
		System.out.println("Optional::get");
		System.out.print("(StringBuffer sb, String s)->sb.append(s)	=> ");
		System.out.println("StringBuffer::append");
		System.out.print("(String s)->System.out.println(s)		=> ");
		System.out.println("String::pringln");
		
	}

}
