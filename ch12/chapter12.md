# Chapter 12. 지네릭스, 열거형, 애너테이션(generics, enumeration, annotation)
## 1. 지네릭스(Generics)
### 1.1 지네릭스란?
지네릭스는 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입체크(compile time type check)를 해주는 기능이다.
Object: 런타임 타입 확인

#### 지네릭스의 장점
1. 타입 안정성을 제공한다(type safe).
2. 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해진다.

#### 타입의 안정성을 높인다는 것의 의미는?
의도하지 않은 타입의 객체가 저장되는 것을 막고, 저장된 저장된 객체를 꺼내올 때 원래의 타입과 다른 타입으로 잘못 형변환되어 발생할 수 있는 오류를 줄인다.

### 1.2 지네릭 클래스의 선언
```java
class Box<T> {	// 두 타입이 같은 것을 의미.  T말고 E, X도 가능 
    T item;
  
    void setItem(T item) { this.item = item; }
	T getItem() { return item; }
}

Box<Apple> box = new Box<Apple>();
```
임의의 참조형 타입: 기호의 종류만 다를 뿐 의미하는 것은 모두 같다.
Box<T>: 지네릭 클래스. ‘T의 Box’ 또는 ‘T Box’라고 읽는다.
T: 타입 변수(type variable) 또는 타입 매개변수
Box: 원시 타입(raw type)
E: Element(요소)
K, V: Key, Value

지네릭스의 제한
static 멤버에 타입 변수 T를 사용할 수 없다. T는 인스턴스변수로 간주되기 때문이다. static 멤버는 대입된 타입의 종류에 관계 없이 동일한 것이어야 한다.
지네릭 타입의 배열을 생성하는 것도 허용되지 않는다. 이는 new 연산자 때문에 컴파일 시점에 타입 T가 정확히 무엇인지 알아야 하기 때문이다. 그러나 Box<T>클래스를 컴파일하는 시점에는 T가 어떤 타입이 될 지 전혀 알 수 없다.

### 1.3 지네릭 클래스의 객체 생성과 사용
지네릭 클래스 Box<T>가 정의되어 있다면, 이 Box<T>의 객체에는 한 가지 종류, 즉 T타입의 객체만 저장할 수 있다. Box<T>의 객체를 생성할 때는 참조변수와 생성자에 대입된 타입이 일치해야 한다.
```java
Box<Apple> appleBox = new Box<Apple>( );	// OK
Box<Apple> appleBox = new Box<Grape>( );	// 에러
Box<Apple> appleBox = new FruitBox<Apple>();	// OK. 다형성
```

### 1.4 제한된 지네릭 클래스
지네릭 타입에 ‘extends’를 사용하면 특정 타입의 자손들만 대입할 수 있다.
```java
class FruitBox<T extends fruit> { } // Fruit과 그의 자손만 타입으로 지정 가능
```

클래스가 아니라 인터페이스를 구현해야 한다는 제약이 필요하다면, 이 때도 ‘extends’를 사용한다. ‘implements’를 사용하지 않는다.
```java
class FruitBox<T extends Fruit & Eatable> { }
// 클래스 Fruit의 자손이면서 Eatable인터페이스도 구현해햐 한다면 & 이용.
```

### 1.5 와일드 카드
아래의 두 문장이 에러가 발생하는 이유는?
```java
static Juice makeJuice(FruitBox<Fruit> box) { }
static Juice makeJuice(FruitBox<Apple> box) { }
```

지네릭 타입이 다른 것만으로는 오버로딩이 성립하지 않기 때문이다. 지네릭 타입은 컴파일러가 컴파일할 때만 사용하고 제거해버린다. 그래서 위의 두 메서드는 오버로딩이 아니라 메서드 중복 정의이다.

<? extends T>	와일드 카드의 상한 제한. T와 그 자손들만 가능
<? super T>	와일드 카드의 하한 제한. T와 그 조상들만 가능
<?>		제한 없음(모든 타입 가능). <? extends Object>와 동일

1.6 지네릭 메서드
메서드의 선언부에 지네릭 타입이 선언된 메서드
지네릭 클래스에 정의된 타입 매개변수와 지네릭 메서드에 정의된 타입 매개변수는 전혀 다른 별개의 것이다.
static멤버에는 타입 매개변수를 사용할 수 없지만, 메서드에 지네릭 타입을 선언하고 사용하는 것은 가능하다.(지역변수를 선언한 것과 유사)
메서드를 호출할 때마다 타입을 대입해야 한다(대부분 생략 가능).
메서드를 호출할 때 타입을 생략하지 않을 때는 클래스 이름 생략 가능

public static <T extends Comparable<? super T>> void sort(List<T> list)
① 타입 T를 요소로 하는 List를 매개변수로 허용한다.
② ‘T’는 Comparable을 구현한 클래스이여야 하며(<T extends Comparable> ), ‘T’ 또는 그 조상의 타입을 비교하는 Comparable이어야 한다는 것(Comparable<? super T>)을 의미한다. 만일 T가 Student이고, Person의 자손이라면, <? super T>는 Student, Person, Object가 모두 가능하다.

1.7 지네릭 타입의 형변환
지네릭 타입과 원시 타입 간의 형변환은 바람직하지 않다.
와일드 카드가 사용된 지네릭 타입으로는 형변환 가능

1.8 지네릭 타입의 제거
컴파일러는 하위 호환성을 위해 지네릭 타입을 이용해서 소스파일을 체크하고, 필요한 곳에 형변환을 넣어준 뒤 지네릭 타입을 제거한다.

지네릭 제거 과정
지네릭 타입의 경계(bound)를 제거한다.
지네릭 타입 제거 후에 타입이 불일치하면, 형변환을 추가
와일드 카드가 포함된 경우, 적절한 타입으로 형변환 추가

2. 열거형(enums)
2.1 열거형이란?
서로 관련된 상수를 편리하게 선언하기 위한 것이다.
자바의 열거형은 열거형이 갖는 값과 타입을 관리한다(체크).

2.2 열거형의 정의와 사용
정의하는 방법: enum 열거형이름 { 상수명1, 상수명2, … }
사용하는 방법: 열거형이름.상수명

열거형의 비교
비교에는 ‘==’을 사용할 수 있지만, <와 >같은 비교연산자는 사용할 수 없고 compareTo( )는 사용할 수 있다(열거형의 원소는 객체이다). compareTo( )는 두 비교대상이 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수를 반환한다.

모든 열거형의 조상 - java.lang.Enum
String name( ): 	열거형 상수의 이름을 문자열로 반환
int ordinal( ): 	열거형 상수가 정의된 순서를 반환(0부터 시작)
values( )와 valuesOf( )는 컴파일러가 자동적으로 추가해준다.

2.3 열거형에 멤버 추가하기
불연속적인 열거형 상수의 경우, 원하는 값을 괄호( ) 안에 적는다.
괄호( )를 사용하려면, 인스턴스 변수와 생성자를 새로 추가해 줘야 한다.
enum Direction { 
EAST(1), SOUTH(5), WEST(-1), NORTH(10);
private final int value; // 정수를 저장할 필드(인스턴스 변수)
Direction(int value) {this.value = value;} // 생성자 추가
public int getValue( ) {return value;}
}
열거형의 생성자는 묵시적으로 private이기 때문에 열거형의 객체를 생성할 수 없다. 

2.4 열거형의 이해
열거형 상수 하나하나가 객체이다.
enum Direction { EAST, SOUTH, WEST, NORTH}

class Direction {
static final Direction EAST = new Direction(“EAST”);
static final Direction SOUTH = new Direction(“SOUTH”);
static final Direction WEST = new Direction(“WEST”);
static final Direction NORTH = new Direction(“NORTH”);
private String name;
private Direction(String name) {
this.name = name;
}
}

열거형의 원소끼리 ==로 비교가 가능한 이유
Direction 클래스의 static 상수의 값은 객체의주소이고, 이 값은 바뀌지 않는 값이므로 ‘==’로 비교가 가능한 것이다.

열거형에 추상 메서드를 추가하면 각 열거형 상수가 추상메서드를 구현해야 하는 이유
열거형 원소는 모두 객체이기 때문에 추상 메서드를 새로 추가하면, 클래스 앞에도 ‘abstract’를 붙여줘야 하고 각 static 상수들도 추상 메서드를 구현해줘야 한다.

3. 애너테이션(annotation)
3.1 애너테이션이란?
주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 다른 프로그램에게 유용한 정보를 제공할 수 있다는 장점이 있다.

3.2 표준 애너테이션
애너테이션
설명
@Override
컴파일러에게 오버라이딩하는 메서드라는 것을 알린다
@Deprecated
앞으로 사용하지 않을 것을 권장하는 대상에 붙인다.
@SupressWarnings
컴파일러의 특정 경고 메시지가 나타나지 않게 해준다.
@SafeVarargs
지네릭스 타입의 가변인자에 사용한다.
@FunctionalInterface
함수형 인터페이스라는 것을 알린다.
@Native
native메서드에서 참조되는 상수 앞에 붙인다.
@Target*
애너테이션이 적용 가능한 대상을 지정하는데 사용한다.
@Documented*
애너테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
@Inherited*
애너테이션이 자손 클래스에 상속되도록 한다.
@Retention
애너테이션이 유지되는 범위를 지정하는데 사용한다.
@Repeatable
애너테이션을 반복해서 적용할 수 있게 한다.

*가 붙은 것은 메타 애너테이션

@Override
메서드 앞에만 붙일 수 있는 애너테이션으로, 조상의 메서드를 오버라이딩하는 것이라는 걸 컴파일러에게 알려주는 역할을 한다.
컴 파일러가 같은 이름의 메서드가 조상에 있는지 확인하고 없으면. 에러메시지를 출력한다.

@Deprecated
다른 것으로 대체되었으니 더 이상 사용하지 않을 것을 권한다는 의미이다.

@SupressWarnings
컴파일러가 보여주는 경고메시지가 나타나지 않게 억제해준다.
억제하는 경고 메시지를 애너테이션의 뒤 괄호( )안에 문자열로 지정하면 된다.
둘 이상의 경고를 동시에 억제하려면 배열에서처럼 괄호{ }를 추가로 사용한다.
새로 추가된 경고 메시지를 억제하려면, 경고 메시지의 종류를 알아야 하는데, -Xlint옵션으로 컴파일해서 나타나는 경고의 내용 중에서 대괄호[ ] 안에 있는 것이 바로 메시지의 종류이다.

억제할 수 있는 경고 메시지의 종류
deprecation: @Deprecated가 붙은 대상을 사용해서 발생하는 경고
unchecked: 지네릭스로 타입을 지정하지 않았을 때 발생하는 경고
rawtypes: 지네릭스를 사용하지 않아서 발생하는 경고
varargs: 가변인자의 타입이 지네릭 타입일 때 발생하는 경고를 억제

@SafeVarargs
메서드에 선언된 가변인자의 타입이 non-reifiable타입일 경우 발생하는  “unchecked”경고를 억제하기 위해 '@SafeVarargs'를 사용해야 한다.
컴파일 후에도 제거되지 않는 타입을 reifiable타입이라고 하고, 제거되는 타입을 non - reifiable타입이 라고 한다. 지네릭 타입들은 대부분 컴파일 시에 제거되므로 non-reifiable타입이다.
static이나 final이 붙은 메서드와 생성자에만 붙일 수 있다. 
즉. 오버라이드 될 수 있는 메서드에는 사용할 수 없다.
@SafeVarargs로 'unchecked'경고는 억제할 수 있지만, 'varargs'경고는 억제 할 수 없기 때문에 습관적으로 @SafeVarargs와 @SuppressWarnings("varargs")를 같이 붙인다.

@FunctionalInterface
‘함수형 인터페이스(functional interface)'를 선언할 때, 이 애너테이션을 붙이면 컴파일러가 함수형 인터페이스’를 올바르게 선언했는지 확인하고, 잘못된 경우 에러를 발생시킨다.
함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있다.

3.3 메타 애너테이션
메타 애너테이션은 ‘애너테이션을 위한 애너테이션’, 즉 애너테이션에 붙이는 애너데이션으로 애너테이션을 정의할 때 애너테이션의 적용대상(target)이나 유지기간(retention)등을 지정하는데 사용된다.

@Target*
애너테이션이 적용가능한 대상을 지정하는데 사용된다.

@Target으로 지정할 수 있는 애너테이션 적용대상의 종류
대상 타입
의미
ANNOTATION_TYPE


CONSTRUCTOR
생성자
FIELD
필드(멤버변수, enum상수)
LOCAL_VARIABLE
지역변수
METHOD
메서드
PACKAGE
패키지
PARAMETER
매개변수
TYPE
타입(클래스, 인터페이스, enum)
TYPE_PARAMETER
타입 매개변수
TYPE_USE
타입이 사용되는 모든 곳


@Retention
애너테이션이 유지(retention)되는 기간을 지정하는데 사용된다.
컴파일러가 사용하는 애너테이션은 유지 정책이 ‘SOURCE’이다.
실행 시에 사용가능한 애너테이션은 유지 정책이 ‘RUNTIME’이다.




애너테이션 유지정책(retention policy)의 종류
유지 정책
의미
SOURCE
소스 파일에만 존재. 클래스파일에는 존재하지 않음.
CLASS
클래스 파일에 존재. 실행시에 사용불가. 기본값
RUNTIME
클래스 파일에 존재. 실행시에 사용가능.


@Documented*
애너테이션에 대한 정보가 javadoc으로 작성한 문서에 포함되도록 한다.

@Inherited*
애너테이션이 자손 클래스에 상속되도록 한다.

@Repeatable
보통은 하나의 대상에 한 종류의 애너테이션을 붙이는데, ‘@Repeatable’이 붙은 애너테이션은 여러 번 붙일 수 있다.

@Native
네이티브 메서드(native method)에 의해 참조되는 상수 필드(constant field)에 붙이는 애너테이션이다. 
네이티브 메서드는 JVM이 설치된 OS의 메서드를 말한다.

3.4 애너테이션 타입 정의하기	
애너테이션을 직접 만들어 쓸 수 있다. ‘@’ 기호를 붙이는 것을 제외하면 인터페이스를 정의하는 것과 동일하다.
@interface 애너테이션이름 {
	타입 요소이름( );	// 애너테이션의 요소를 선언한다.
	…
}

애너테이션의 요소
애너테이션 내에 선언된 메서드를 ‘애너테이션의 요소'라고 한다. 
애너테이션의 요소는 반환값이 있고 매개변수는 없는 추상 메서드의 형태이다.
상속을 통해 구현하지 않아도 되지만, 애너테이션을 적용할 때 이 요소들의 값을 빠짐없이 지정해야 한다. 요소의 이름도 같이 적어주므로 순서는 상관 없다.
				
애너테이션 요소의 기본값
애너테이션의 각 요소는 기본값을 가질 수 있으며, 기본값이 있는 요소는 애너테이션을 적용할 때 값을 지정하지 않으면 기본값이 사용된다.
@interface TestInfo {
	int count( ) default 1;	// 기본값을 1로 지정
}
@TestInfo		// @TestInfo(count = 1)과 동일
애너테이션 요소가 오직 하나뿐이고 이름이 value인 경우, 애너테이션을 적용할 때 요소의 이름을 생략하고 값만 적어도 된다.
@interface TestInfo {
	String value( );
}
@TestInfo(“passed”)	// @TestInfo(value = “passed”)와 동일

요소의 타입이 배열인 경우 괄호 { }를 사용해서 여러 개의 값을 지정할 수 있다.
@interface TestInfo {
	String[ ] testTools( );
}
@Test(testTools = {“JUnit”, “AutoTester”})	// 값이 여러 개인 경우
@Test(testTools = “JUnit”)	// 값이 하나일 때는 괄호 { } 생략 가능
@Test(testTools = { })	// 값이 없을 때는 괄호 { }가 반드시 필요

java.lang.annotation.Annotation
모든 애너테이션의 조상은 Annotation이다. 그러나 애너테이션은 상속이 허용되지 않으므로 명시적으로 Annotation을 조상으로 지정할 수 없다.
Annotation은 애너테이션이 아니라 일반적인 인터 페이스로 정의되어 있다.

마커 애너테이션 Marker Annotation
값을 지정할 필요가 없는 경우, 애너데이션의 요소를 하나도 정의하지 않을 수 있다. 

애너테이션 요소의 규칙
요소의 타입은 기본형, String, enum, 애너테이션, Class만 허용
( )안에 매개변수를 선언할 수 없다.
예외를 선언할 수 없다.
요소를 타입 매개변수로 정의할 수 없다.


