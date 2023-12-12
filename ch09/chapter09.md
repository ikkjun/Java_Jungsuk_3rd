1. java.lang 패키지
1.1 Object 클래스
모든 클래스의 최고 조상, Object클래스는 멤버변수는 없고 오직 11개의 메서드만을 가지고 있다.
 - notify(), wait() 등은 쓰레드와 관련된 메서드이다.
 - equals(), hashCodeO, toString()은 적절히 오버라이딩해야 한다. 

Object클래스가 iv변수가 없음에도 불구하고 static메서드가 아니라 인스턴스 메서드인 이유는?
this를 사용한다.
this를 사용하지 않더라도 오버라이딩해서 자식이 iv를 사용하는 것이 예상되기 때문이다.

equals(Object obj)
객체 자신과 주어진 객체(obj)를 비교한다. 같으면 true, 다르면 false	
Object클래스에 정의된 equals()는 참조변수 값(객체의 주소)을 비교한다. 

hashCode( )
객체의 해시코드(int타입의 정수)를 반환하는 메서드(해시함수)
다량의 데이터를 저장&검색하는 해싱기법에 사용된다.
Object클래스의 hashCode()는 객체의 내부주소를 반환한다. 

equals()를 오버라이딩하면, hashCocle()도 같이 오버라이딩 해야 한다. equals()의 결과가 true인 두 객체의 hash cocle는 같아야하기 때문 

toString( )
객체의 정보를 문자열(String)로 제공할 목적으로 정의된 메서드 

clone( )
Object클래스에 정의된 clone( )은 단순히 인스턴스변수의 값만 복사하기 때문에 참조타입의 인스턴스 변수가 있는 클래스는 완전한 인스턴스 복제가 이루어지지 않는다.
예를 들어 배열의 경우. 복제된 인스턴스도 같은 배열의 주소를 갖기 때문에 복제된 인스턴스의 작업이 원래의 인스턴스에 영향을 미치게 된다. 이런 경우 clone메서드를 오버라이딩 해서 새로운 배열을 생성하고 배열의 내용을 복사하도록 해야 한다. 

clone( )을 사용하려면. 먼저 복제할 클래스가 Cloneable인터페이스를 구현해야하고. clone( )을 오버라이딩하면서 접근 제어지를 protected에서 public으로 변경한다. 

Cloneable 인터페이스를 구현한 클래스의 인스턴스만 clone()을 통한 복제가 가능한데, 그 이유는 인스턴스의 데이터를 보호하기 위해서이다.

공변 반환타입
공변 반환타입은 오버라이딩할 때 조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것이다.
공변 반환타입: covariant return type
반공변: contravariant 

얕은 복사와 깊은 복사
clone( )은 단순히 객체에 저장된 값을 그대로 복제할 뿐 객체가 참조하고 있는 객체까지 복제하지는 않는다. 이러한 복제(복사)를 얕은 복사(shallow copy)라고 한다. 얕은 복사에서는 원본을 변경하면 복사본도 영향을 받는다.
반면에 원본이 참조하고 있는 객체까지 복제하는 것을 깊은 복사(deep copy)라고 하며. 깊은 복사에서는 원본과 복사본이 서로 다른 객체를 참조하기 때문에 원본의 변경이 복사본에 영향을 미치지 않는다.

얕은 복사와 깊은 복사의 차이점
얕은 복사는 읽기만 할 때 유용하다(read only). 하지만 깊은 복사는 읽고 쓰고 싶을 때 사용한다(read&write). 깊은 복사는 얕은 복사보다 시간이 더 오래 걸리고 메모리를 많이 사용한다는 단점이 있다.

getClass( )
자신이 속한 클래스의 Class객체를 반환하는 메서드이다.
Class객체는 클래스의 모든 정보를 담고 있으며, 클래스 당 단 1개만 존재한다. 
클래스파일(*.class)이 메모리에 로드될 때 생성된다.

Class객체를 얻는 방법
Class cObj = new Card().getClass(); // 생성된 객체로 부터 얻는 방법 
Class cObj = Card.class; / / 클래스 리터럴 (*.class)로 부터 얻는 방법
Class cObj = Class . forName ("Card" ); // 클래스 이름으로 부터 얻는 방법

Class 객체 이용할 때의 장점
클래스에 대한 모든 정보를 얻을 수 있다. 
Class 객체를 통해서 객체를 생성하고 메서드를 호출할 수 있다.

1.2 String 클래스				
문자형 배열(char[])과 그에 관련된 메서드들이 정의되어 있다. 
String인스턴스의 내용은 바꿀 수 없다.(immutable)

변경 불가능한(immutable) 클래스
String은 변경할 수 없고 변경하려고 할 때마다 객체가 생성되는 클래스이다. 

문자열의 비교
String str1 = "abc";
 String str2 = "abc";
 String str3 =newString("abc");
 String str4 =newstring("abc"); 



equals( )를 사용했을 때는 두 문자열의 내용(“abc”)을 비교하기 때문에 두 경우 모두 true를 결과로 얻는다. 하지만, 각 String인스턴스의 주소를 등가비교연산자 ‘==’로 비교했을 때는 결과가 다르다.

문자열 리터럴
모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장된다. 클래스 파일에는 소스파일에 포함된 모든 리터럴의 목록이 있다. 해당 클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때, 이 리터럴의 목록에 있는 리터럴들이 JVM내에 있는 ‘상수 저장소(constant pool)’에 저장된다.

빈 문자열(empty string)
내용이 없는 문자열, 크기가 0인 char형 배열을 저장하는 문자열 
일반적으로 변수를 선언할 때, 각 타입의 기본값으로 초기화 하지만 Strin g은 참조형 타 입의 기본값인 null 보다는 빈문자열로(NullPointException 발생할 수 있기 때문), char형은 기본값인 ‘\u0000’ 대신 공백으로 초기화 하는 것이 보통이다.

문자열과 기본형 간의 변환
기본형 값을 String으로 변환
int i=100;
String str1 = i + “”;
String str2 = String.valueOf(i);	// 이 방법이 더 빠르다.

String을 기본형 값으로 변환
int i=Integer.parseInt(“100”);		// old
int i2 = Integer.valueOf(“100”);	// new

1.3 StringBuffer클래스와 StringBuilder 클래스
StringBuffer클래스: 동기화 o
StringBuilder클래스: 동기화 x

String클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없지만 StringBuffer클래스는 변경이 가능하다. StringBuffer클래스는 String 클래스와 같이 문자열을 저장하기 위한 char형 배열의 참조변수를 인스턴스변수로 선언해 놓고 있다.

StringBuffer의 생성자
StringBuffer인스턴스를 생성할 때는 생성자 StringBuffer(int length)를 사용해서 StringBuffer인스턴스에 저장될 문자열의 길이를 고려하여 충분히 여유있는 크기로 지정하는 것이 좋다. 버퍼의 크기를 지정해주지 않으면 16개의 문지를 저장할 수 있는 크기의 버퍼를 생성한다.

StringBuffer의 변경
String과 달리 StringBuffer는 내용을 변경할 수 있다.
StringBuffer sb = new StringBuffer(“abc”);
sb.append(“123”).append(“ZZ”);

StringBuffer의 비교
String클래스에서는 equals 메서드를 오버라이딩해서 문자열의 내용을 비교 하도록 구현되어 있지만. StringBuffer클래스는 equals메서드를 오버라이딩하지 않아서 StringBuffer클래스의 equals메서드를 사용해도 등가비교연산자(==)로 비교한 것과 같은 결과를 얻는다.
그래서 StringBuffer 인스턴스에 담긴 문자열을 비교하기 위해서는 StringBuffer 인스턴스에 toString( )을 호출해서 String인스턴스를 얻은 다음, 여기에 equals메서드를 사용해서 비교해야 한다.

StringBuffer 클래스의 생성자와 메서드
변경관련 메서드가 많다. append가 insert보다 빠르다.



1.4 Math 클래스
1.5 래퍼(wrapper) 클래스

2. 유용한 클래스
2.1 java.util.Objects 클래스
2.2 java.util.Random 클래스
2.3 정규식(Regular Expression) - java.util.regex패키지
2.4 java.util.Scanner 클래스
2.5 java.util.StringTockenizer 클래스
StringTokenizer는 긴문자열을 지정된 구분자(delimiter)를 기준으로 토큰(token)이라 는 여러 개의 문자열로 잘라내는 데 사용된다.  

그러나 StringTokenizer는 구분자로 단 하나의 문자 밖에 사용하지 못하기 때문에 보다 복잡한 형태의 구분자로 문자열을 나누어야 할 때는 어쩔 수 없이 정규식을 사용하는 String의 split(String regex)나 Scanner의 useDelimiter(String pattern) 메서드를 사용해야 한다. 

2.6 java.math.BigInteger 클래스
2.7 java.math.BigDecimal 클래스
