# Chapter 14. 람다와 스트림(Lambda & Stream)
## 1. 람다식
### 1.1 람다식(Lambda expression)이란?
메서드를 하나의 '식(expression)'으로 표현한 것이다.</br>
메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로. 람다식을 ‘익명 함수(anonymous function)’라고도 한다.

#### 함수와 메서드의 차이
근본적으로 함수와 메서드는 동일하다. 다만 함수는 일반적 용어이고, 메서드는 객체지향개념의 용어이다. 즉, 함수는 클래스에 독립적이고, 메서드는 클래스에 종속적이다.

### 1.2 람다식 작성하기
1. 메서드의 이름과 반환타입 제거, 매개변수 선언부와 몸통{ } 사이에 -> 추가</br>
```java
int max(int a, int b) {return a > b ? a : b;}
(int a, int b) -> {return a > b ? a : b;}
```
2. 반환값이 있는 메서드의 경우 return문을 식이나 값으로 대신할 수 있다. 문장이 아닌 식이므로 끝에 ‘;’을 붙이지 않는다.
```java
(int a, int b) -> {return a > b ? a : b;}
(int a, int b) -> a> b ? a : b
```
3. 람다식에 선언된 매개변수의 타입은 추론이 가능한 경우는 생략할 수 있다. 대부분의 경우에 생략할 수 있다.
```java
(int a, int b) -> a> b ? a : b
(a, b) -> a > b ? a : b
```
#### 주의사항
- 매개변수가 하나뿐인 경우에는 괄호( )를 생략할 수 있다. 단 매개변수의 타입이 있으면 괄호( )를 생략할 수 없다.
```java
(a)     -> a * a → a     -> a * a  // OK
(int a)	-> a * a → int a -> a * a  // 에러
```

- 괄호{ } 안의 문장이 하나일때는 괄호{ }를 생략할 수 있다. 끝에 ‘;’을 안 붙인다.
```java
(String name, int i)-> {sysout(name + “=” + i);}
(String name, int i) -> sysout(name + “=” + i)
```

- 그러나 괄호{ } 안의 문장이 return문일 경우 괄호{ }를 생략할 수 없다.
```java
(int a, int b) -> {return a > b ? a : b;} // OK
(int a, int b) -> return a > b ? a : b    // 에러
```

### 1.3 함수형 인터페이스(Functional Interface)
함수형 인터페이스: 단 하나의 추상메서드만 선언된 인터페이스</br>
람다식은 익명 클래스의 객체와 동등하다.

람다식으로 정의된 익명 객체의 메서드를 호출하려면 익명 객체의 주소를 f라는 참조변수에 저장해야 한다. 참조변수의 타입은 참조형이니까 클래스 또는 인터페이스가 가능하다. 그리고 람다식과 동등한 메서드가 정의되어 있는 것이어야 한다.
MyFunction f = new MyFunction() {
public int max(int a, int b) {
return a>b?a:b;
}
};
Int big = f.max(5,3);

MyFunction인터페이스를 구현한 익명 객체를 람다식으로 대체가 가능한 이유는, 람다식도 실제로는 익명 객체이고, MyFunction인터페이스를 구현한 익명 객체의 메서드 max( )와 람다식의 매개변수의 타입과 개수 그리고 반환값이 일치하기 때문이다.

람다식을 다루기 위한 인터페이스를 ‘함수형 인터페이스(functional interface)'라고 부르기로 했다.

함수형 인터페이스의 제약
함수형 인터페이스에는 오직 하나의 추상 메서드만 정의되어 있어야 한다는 제약이 있다. 그래야 람다식과 인터페이스의 메서드가 1:1로 연결될 수 있기 때문이다. 반면에 static 메서드와 default 메서드의 개수에는 제약이 없다.

함수형 인터페이스 타입의 매개변수와 반환타입
메서드의 매개변수가 MyFunction타입이면 이 메서드를 호출할 때 람다식을 참조하는 참조변수를 매개변수로 지정해야한다.

참조변수 없이 직접 람다식을 매개변수로 지정하는 것도 가능.

메서드의 반환타입이 함수형 인터페이스타입이라면, 이 함수형 인터페이스의 추상메서드와 동등한 람다식을 가리키는 참조변수를 반환하거나 람다식을 직접 반환할 수 있다.

람다식의 타입과 형 변환
함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐, 람다식의 타입이 함수형 인터페이스의 타입과 일치하는 것은 아니다. 그래서 대입 연산자의 양변의 타입을 일치시키기 위해 형변환이 필요하다.

람다식은 이름이 없을 뿐 분명히 객체인데도 Object타입으로 형변환 할 수 없다. 람다식은 오직 함수형 인터페이스로만 형변환이 가능하다. 굳이 Object타입으로 형변환하려면, 먼저 함수형 인터페이스로 변환해야 한다.

1.4 java.util.function 패키지


조건식의 표현에 사용되는 Predicate
Predicate는 Function의 변형으로 반환타입이 boolean이라는 것만 다르다. Predicate는 조건식을 람다식으로 표현하는데 사용된다.

매개변수가 두 개인 함수형 인터페이스
매개변수가 2개인 함수형 인터페이스는 이름 앞에 접두사 'Bi'가 붙는다.

두 개 이상의 매개변수를 갖는 함수형 인터페이스가 필요하다면 직접 만들어서 써야 한다.
@FunctionalInterface
Interface TriFunction<T,U,V,R> {
R apply(T t, U u, V v);
}

UnaryOperator와 BinaryOperator
Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있는데, 이들은 매개변수의 타입과 반환타입의 타입이 모두 일치한다.


컬렉션 프레임웍과 함수형 인터페이스
컬렉션 프레임웍의 인터페이스에 다수의 디폴트 메서드가 추가되었는데, 그 중의 일부는 함수형 인터페이스를 시용한다.

기본형을 사용하는 함수형 인터페이스
함수형 인터페이스는 매개변수와 반환값의 타입이 모두 지네릭 타입이었는데, 기본형 타입의 값을 처리할 때도 래퍼 클래스를 사용해왔다. 그래서 보다 효율적으로 처리할 수 있도록 기본형을 사용하는 함수형 인터페이스들이 제공된다.


IntFunction, TolntFunction, IntToLongFunc tion은 있어도 IntTolntFunction은 없는 이유
IntUnaryOperator가 그 역할을 하기 때문이다. 매개변수의 타입과 반환타입이 일치할 때는 앞서 배운 것처럼 Function대신 UnaryOperator를 사용해야 한다.

1.5 Function의 합성과 Predicate의 결합
Function의 합성
두 람다 식을 합성해서 새로운 람다식을 만들 수 있다. 함수 f, g가 있을 때. f.andThen(g)는 함수 f를 먼저 적용하고, 그 다음에 함수 g를 적용한다. 그리고 f.compose(g)는 반대로 g를 먼저 적용하고 f를 적용한다.

Predicate의 결합
Predicate를 and( ), or( ), negate( )로 연결해서 하나의 새로운 Predicate로 결합할 수 있다.

static메서드인 isEqual( )은 두 대상을 비교하는 Predicate를 만들 때 사용한다. 먼저, isEqual()의 매개변수로 비교대상을 하나 지정하고, 또 다른 비교대상은 test()의 매개변수로 지정한다.
boolean result = Predicate.isEqual(str1).test(str2);

1.6 메서드 참조
람다식이 하나의 메서드만 호출하는 경우에는 ‘메서드 참조(method reference)’라는 방법으로 ‘클래스이름::메서드이름’ 또는 ‘참조변수::메서드이름’으로 바꿀 수 있다.

생성자의 메서드 참조
생성자를 호출하는 람다식도 메서드 참조로 변환할 수 있다.
Supplier <MyClass> s = () -> new MyClass () ; // 람다식
Supplier <MyClass> s = MyClass::new; // 메서드참조

매개변수가 있는 생성자
매개변수의 개수에 따라 알맞은 함수형 인터페이스를 사용한다.
Function<Integer, MyClass> f = (i) -> new MyClass(i);
Function<Integer, MyClass> f2 = MyClass::new;

BiFunction<Integer, String, MyClass> bf = (i , s) -> new MyClass(i , s);
BiFunction<Integer, String, MyClass> bf2 = MyClass::new;

배열을 생성할 때
Function<Integer, int[]> f   = x -> new int[x];
Function<Integer, int[]> f2 = int[]::new;



## 2. 스트림(stream)
### 2.1 스트림이란?
스트림은 데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메서드들을 정의했다. 데이터 소스를 추상화하였다는 것은 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 되었다는 것과 코드의 재사용성이 높아진다는 것을 의미한다.

#### 스트림의 특징
1. 스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐 데이터 소스를 변경하지 않는다.(원본 유지)
2. 스트림은 Iterator처럼 일회용이다.</br>
필요하다면 스트림을 다시 생성해야한다.
3. 최종연산 전까지 중간연산이 수행되지 않는다. → 지연된 연산</br>
중간 연산을 호출하는 것은 단지 어떤 작업이 수행되어야 하는지를 지정해주는 것일 뿐이다. 최종 연산이 수행되어야 비로소 스트림의 요소들이 중간 연산을 거쳐 최종 연산에서 소모된다.
4. 스트림은 작업을 내부 반복으로 처리한다.</br>
내부 반복이라는 것은 반복문을 메서드의 내부에 숨길 수 있다는 것을 의미한다.
5. 스트림의 작업을 병렬로 처리한다. → 병렬스트림</br>

스트림의 연산
스트림이 제공하는 연산은 중간 연산과 최종 연산으로 분류할 수 있는데, 중간 연산은 연산 결과가 스트림인 연산이므로 스트림에 연속해서 중간 연산을 할 수 있다. 반면에 최종 연산은 연산결과가 스트림이 아닌 연산이며, 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.

중간 연산은 map( )과 flatMap( ), 최종 연산은 reduce( )와 collect( )가 핵심이다.

Stream〈Integer〉와 lntStream
요소의 타입이 T인 스트림은 기본적으로 Stream〈T〉이지만, 오토박싱&언박싱으로 인한 비효율을 줄이기 위해 데이터 소스의 요소를 기본형으로 다루는 스트림, IntStream, LongSream, DoubleStream이 제공된다.

병렬 스트림
스트림으로 데이터를 다룰 때의 장점 중 하나는 병렬 처리가 쉽다는 것이다. 병렬 스트림은 내부적으로 이 프레임웍을 이용해서 자동적으로 연산을 병렬로 수행한다. 스트림에 parallel()이라는 메서드를 호출해서 병렬로 연산을 수행하도록 지시하면 된다. 반대로 병렬로 처리되지 않게 하려면 sequential()을 호출하면 된다. 이 메서드는 parallel()을 호출한 것을 취소할 때만 사용한다.

### 2.2 스트림 만들기
스트림의 소스가 될 수 있는 대상은 배열, 컬렉션, 임의의 수 등

컬렉션
컬렉션의 최고 조상인 Collection에 stream( )이 정의되어 있다. 그래서 Collection의 자손인 List와 Set을 구현한 컬렉션 클래스들은 모두 이 메서드로 스트림을 생성할 수 있다.

List<Integer> list = Arrays.asList(1,2,3,4,5);
Stream<Integer> intStream = list.stream();	// list 소스

배열
Stream<String> strSteam = Stream.of(“a”,”b”,”c”);
Stream<String> strSteam
= Stream.of(new String[]{“a”,”b”,”c”});

Stream<String> strSteam
= Arrays.stream(new String[]{“a”,”b”,”c”});
Stream<String> strSteam
= Arrays.stream(new String[]{“a”,”b”,”c”}, 0, 3);

특정 범위의 정수
IntStream 스트림 =IntStream.range(int begin, int end);
IntStream intStream =
IntStream.rangeClosed(int begin, int end);

range( )의 경우 경계의 끝인 end가 범위에 포함되지 않고, rangeClosed( )의 경우는 포함된다.

임의의 수
난수를 생성하는 Random클래스의 인스턴스 메서드들이 반환하는 스트림은 크기가 정해지지 않은 무한 스트림(infinite stream)이므로 limit( )도 사용해서 스트림의 크기를 제한해 주어야 한다.

IntStream intStream = new Random().int();
intStream.limit(5).forEach(System.out::println( );

람다식 - iterate(), generate()
Stream클래스의 iterate()와 generate()는 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성한다.

iterate()는 씨앗값으로 지정된 값부터 시작해서, 람다식 f에 의해 계산된 결과를 다시 seed값으로 해서 계산을 반복한다.

generate()도 iterate()처럼, 람다식에 의해 계산되는 값을 요소로 하는 무한 스트림을 생성해서 반환하지만, iterate()와 달리 이전 결과를 이용해서 다음 요소를 계산하지 않는다.
Stream<Double> randomStream = Stream.generate(Math::random);
Stream<Integer> oneStream = Stream.generate(()->1);

한 가지 주의할 점은 iterate( )와 generate( )에 의해 생성된 스트림을 기본형 스트림 타입의 참조변수로 다룰 수 없다는 것이다. 굳이 필요하다면, mapTolnt( )와 같은 메서드로 변환을 해야 한다.
IntStream evenStream=Stream.iterate(0, n->n+2);//에러
IntStream evenStream =
Stream.iterate(0, n->n+2).mapToInt(Integer::valueOf);

파일
java.nio.file.Files는 파일을 다루는데 필요한 유용한 메서드들을 제공하는데, list( )는 지정된 디렉토리(dir)에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.
Path는 하나의 파일 또는 경로를 의미한다.
Stream<Path> Files.list(Path dir)

파일의 한 행을 요소로 하는 스트림을 생성하는 메서드도 있다.
Stream<String> Files.lines(Path path)

빈 스트림
요소가 하나도 없는 비어있는 스트림을 생성할 수도 있다. 스트림에 연산을 수행한 결과가 하나도 없을 때. null보다 빈스트림을 반환하는 것이 낫다.

Stream emptyStream = Stream.empty();

두 스트림의 연결
Stream의 static메서드인 concat( )을 사용하면, 두 스트림을 하나로 연결할 수 있다. 연결하려는 두 스트림의 요소는 같은 타입이어야 한다.

### 2.3 스트림의 중간연산
#### 스트림 자르기 - skip( ), limit( )
skip( )과 limit( )은 스트림의 일부를 잘라낼 때 사용하며, skip(3)은 처음 3개의 요소를 건너뛰고, limit(5)는 스트림의 요소를 5개로 제한한다.

#### 스트림의 요소 걸러내기 - filter( ), distinct( )
distinct( )는 스트림에서 중복된 요소들을 제거하고, filter( )는 주어진 조건(Predicate)에 맞지 않는 요소를 걸러낸다(if문).

#### 정렬 - sorted( )
스트림을 정렬할 때는 sorted( )를 사용하면 된다. Comparator를 지정하지 않으면 스트림 요소의 기본 정렬 기준(Comparable)으로 정렬한다. 단, 스트림의 요소가 Comparable을 구현한 클래스가 아니면 예외가 발생한다.

#### 변환 - map( )
스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할 때가 있다. 이 때 사용하는 것이 바로 map( )이다. 매개변수로 T타입을 R타입으로 변환해서 반환하는 함수를 지정해야 한다.

#### 조회 - peek( )
연산과 연산 사이에 올바르게 처리되었는지 확인하고 싶다면, peek( )을 사용하면 된다. 최종 연산인 forEach( )와 달리 스트림의 요소를 소모하지 않으므로 연산 사이에 여러 번 사용해도 된다. filter( )나 map( )의 결과를 확인할 때 유용하게 사용될 수 있다.

#### 스트림을 기본 스트림으로 변환
mapToInt(), mapToLong( ), mapToDouble()
Stream<T>타입의 스트림을 기본형 스트림으로 변환할 때 사용한다.

#### 기본 스트림을 스트림으로 변환
mapToObj( )를 이용해서 IntStream을 Stream<String>으로 변환할 수 있다. 그리고 IntStream을 Stream<Integer>로 변환할 때는 boxed( )를 사용한다.

#### flatMap( ) - Stream<T[]>를 Stream<T>로 변환 → flat
스트림의 요소가 배열이거나 map( )의 연산결과가 배열인 경우, 즉 스트림의 타입이 Stream<T[ ]>인 경우, Stream<T>로 다루는 것이 더 편리할 때가 있다. 그럴 때는 map( ) 대신 flatMap( )을 사용하면 된다.
Stream<String[ ]> strArrStrm =
Stream.of(new String[ ]{“abc”,”def”,”ghi”},
new String[ ]{“ABC”,”GHI”,”JKLM”});

Stream<String> strStrStrm = strArrStrm.flatMap(Arrays::stream);

### 2.4 Optional<T>와 OptionalInt
Optional<T>은 지네릭 클래스로 ‘T타입의 객체’를 감싸는 래퍼 클래스(Integer, Long…)이다. 
Optional타입의 객체에는 모든 타입의 참조변수를 담을 수 있다. 
Optional을 사용하면 간접적으로 null을 다룰 수 있게 된다(null-safe하게 다룬다.).

#### 간접적으로 null 다루는 이유는?
null을 직접 다루는 것은 위험하다.(NullPointException발생할 수 있다.)
null 체크하기 위해 if문이 필수적으로 필요하므로 코드가 지저분해진다.

Optional객체 생성하기
Optional객체를 생성할 때는 of( ) 또는 ofNullable( )을 사용해야 한다. of( )는 매개변수의 값이 null이면 NullPointerException이 발생하기 때문이다.

Optional<String> opt \Val = Optional.ofNullable(null);
Optional<T>타입의 참조변수를 기본값으로 초기화할 때는 empty( )를 사용한다. empty( )는 지네릭 메서드라서 앞에 <T>를 붙였다. 추정 가능하므로 생략할 수 있다.
Optional<String> optVal = Optional.<String>empty();

Optional객체의 값 가져오기
Optional객체에 저장된 값을 가져올 때는 get()을 사용한다. 값이 null일 때는 NoSuchElementException이 발생하며, 이를 대비해서 orElse()로 대체할 값을 지정할 수 있다.
String str2 = optVal.orElse(“”); // optVal null일 때 “” 반환

Optional 객체의 값 가져오기
orElse()의 변형으로는 null을 대체할 값을 반환하는 람다식을 지정할 수 있는 orElseGet( )과 null일 때 지정된 예외를 발생시키는 orElseThrow( )가 있다.
String str3=optVal2.orElseGet(String::new);()->new String()
String str4=optVal2.orElseThrow(NullPointerException:new);

isPresent( )
isPresent( )는 Optional객체의 값이 null이면 false를 아니면 true를 반환한다. isPresent(Consumer<T> bock)은 값이 있으면 주어진 람다식을 실행하고, 없으면 아무 일도하지 않는다. ifPresent( )는 Optional<T>를 반환하는 findAny( )나 findFirst( )와 같은 최종 연산과 잘 어울린다.


OptionalInt, OptionalLong, OptionalDouble
기본형 값을 감싸는 래퍼클래스(성능 때문에 사용)
IntStream과 같은 기본형 스트림에는 Optional도 기본형을 값으로 하는 OptionalInt, OptionalLong, OptionalDouble을 반환한다.

Optional에 저장된 값 가져오기


빈 Optional 객체와의 비교
OptionalInt opt = OptionalInt.of(0);
OptionalInt opt2 = OptionalInt.empty(); // 어떻게 구분?

저장된 값이 없는 것과 0이 저장된 것은 isPresent라는 인스턴스 변수로 구분이 가능하다. isPresent( )는 이 인스턴스변수의 값을 반환한다. 그러나 Optional객체의 경우 null을 저장하면 비어있는 것과 동일하게 취급한다.
System.out.println(opt.isPresent());	// true
System.out.println(opt2.isPresent());	// false

2.5 스트림의 최종 연산
스트림의 모든 요소에 지정된 작업을 수행
forEach( ), forEachOrdered( )
직렬 스트림: sequential() → 순서대로 처리
병렬 스트림: parrel() → 순서 보장이 되지 않는다.
⇒ forEachOrdered 사용

조건 검사
allMatch( ), anyMatch( ), noneMatch( )
스트림의 요소에 대해 지정된 조건에 모든 요소가 일치하는지 일부가 일치하는지 아니면 어떤 요소도 일치하지 않는지 확인하는데 사용할 수 있는 메서드들이다. 이 메서드들은 모두 매개변수로 Predicate를 요구하며, 연산결과로 boolean을 반환한다.

boolean allMatch (Predicate<? super T> predicate)
// 모든 요소가 조건을 만족시키면 true
boolean anyMatch() // 한 요소라도 조건을 만족시키면 true
boolean noneMatch // 모든 요소가 조건을 만족시키지 않으면 true

findFirst(), findAny()
스트림의 요소 중에서 조건에 일치하는 첫 번째 것을 반환하는 findFirst( )가 있는데, 주로 filter() 와 함께 사용되어 조건에 맞는 스트림의 요소가 있는지 확인하는데 사용된다. 병렬 스트림인 경우에는 findFirst()대신 findAny()를 사용해야 한다.

통계
count(), sum(), average(), max(), min()
대부분의 경우 위의 메서드를 사용하기보다 기본형 스트림으로 변환하거나, 아니면 앞으로 배우게 될 reduce()와 collect()를 사용해서 통계 정보를 얻는다.

리듀싱 - reduce()
reduce()는 스트림의 요소를 줄여나가면서 연산을 수행하고 최종결과를 반환한다. 그래서 매개변수의 타입이 BinaryOperator<T>이다. 처음 두 요소를 가지고 연산한 결과를 가지고 그 다음 요소와 연산한다.

Optional<T> reduce(BinaryOperator<T> accumulator)
T reduce(T identity, BinaryOperator<T> accumulator)

identity 초기값
accumulator: 이전 연산 결과와 스트림의 요소에 수행할 연산
combiner: 병렬처리된 결과를 합치는 데 사용할 연산

최종 연산 count( )와 sum( ) 등은 내부적으로 모두 reduce() 를 이용해서 작성된 것이다.
int sum = intStream.reduce(0, (a, b) -> a + b);
reduce 내부
int a = identity;
for(int b : stream)
a = a + b;


2.6 collect()
collect()가 스트림의 요소를 수집하려면 어떻게 수집할 것인가에 대한 방법이 정의되어 있어야 하는데, 이 방법을 정의한 것이 바로 컬렉터(collector)이다.

reduce( )와 collect( )의 공통점과 차이점
둘 다 최종 연산에 해당한다는 점이 공통점이다. 그러나 reduce는 전체에 대한 리듀싱인 것에 비해 collect는 그룹별 리듀싱이 가능하다.

collect(), Collector, Collectors
collect()는 Collector를 매개변수로 하는 스트림의 최종연산. 이는  매개변수가 Collector를 구현한 클래스의 객체이어야 한다는 뜻이다.
Collector는 수집(collect)에 필요한 메서드를 정의해 놓은 인터페이스이다.
Collectors 클래스는 다양한 기능의 컬렉터(Collector를 구현한 클래스)를 제공한다.

스트림을 컬렉션과 배열로 변환
toList( ), toSet( ), toMap( ), toCollection( ), toArray( )
스트림의 모든 요소를 컬렉션에 수집하려면, Collectors클래스의 toList()와 같은 메서드를 사용하면 된다. List나 Set이 아닌 특정 컬렉션을 지정하려면, toCollection()에 해당 컬렉션의 생성자 참조를 매개변수로 넣어주면 된다.

List<String> names = stuStream. map(Student::getName).collect(Collectors.toList());
ArrayList<String> list = names.stream(). collect(Collectors.toCollection(ArrayList::new));

스트림에 저장된 요소들을 ’T[ ]’타입의 배열로 변환하려면, toArray( )를 사용하면 된다.

통계
counting( ), summingInt( ), averagingInt( ), maxBy( ), minBy( )
groupingBy( )와 함께 사용할 수 있다.

리듀싱 - reducing( ) 857
그룹별 리듀싱이 가능

문자열 결합 - joining( )
문자열 스트림의 모든 요소를 하나의 문자열로 연결해서 반환한다. 스트림의 요소가 String이나 StringBuffer처럼 CharSequence의 자손인 경우에만 결합이 가능하므로 스트림의 요소가 문자열이 아닌 경우에는 먼저 map( )을 이용해서 스트림의 요소를 문자열로 변환해야 한다.

String studentNames = stuStream.map(Student::getName).collect(joining(“,”));

그룹화와 분할
Collectors
groupingBy()
스트림을 n분할 한다.


partitioningBy()
스트림을 2분할 한다.

기본 분할 + 통계 정보
Map<Boolean, Long> stuNumBySex = stuStream. collect(partioningBy(Student::isMale, counting()));

2.7 Collector 구현하기
Collector인터페이스는 다음과 같이 정의되어 있다.
public interface Collector<T, A, R> {
Supplier<A>		supplier();
BiConsumer<A, T> 	accumulator();
BinaryOperator<A>	combiner();
Function<A, R>	finisher();
Set<Characteristics> characteristics();
}

supplier()	작업결과를 저장할 공간을 제공
accumulator()	스트림의 요소를 수집할 방법을 제공
combiner()	두 저장공간을 병합할 방법을 제공(병렬)
finisher()	결과를 최종적으로 변환할 방법을 제공

2.8 스트림의 변환
