# Chapter 8예외 처리(exception handling)
## 1. 예외처리(exception handling)
### 1.1 프로그램 오류
- 컴파일 에러: 컴파일 시에 발생하는 에러
- 런타임 에러: 실행 시에 발생하는 에러
- 논리적 에러: 실행은 되지만, 의도와 다르게 동작하는 것</br>
런타임에러를 줄여서 컴파일 에러로 옮겨야 한다.

#### 실행 시(runtime) 발생할 수 있는 프로그램 오류
- 에러(Error): 프로그램 코드에 의해서 수습될 수 없는 심각한 오류(복구 불가)
- 예외(Exception): 프로그램 코드에 의해서 수습될 수 있는 다소 미약한(덜 심각) 오류(복구 가능)

### 1.2 예외 클래스의 계층구조
모든 클래스의 조상은 Object클래스 이므로 Exception과 Error클래스 역시 Object클래스의 자손
모든 예외의 최고 조상은 Exception클래스이다.

#### 예외클래스를 두 그룹으로 나누시오.
throwable: 이름은 able로 끝나지만 클래스.
- Exception클래스와 그 자손들</br>
  사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외. 예외 처리 필수. 컴파일러가 예외처리를 확인하는 Exception 클래스들을 checked 예외라고 부른다.
- RuntimeException클래스와 그 자손들</br>
  프로그래머의 실수로 발생하는 예외. 예외 처리 선택. 컴파일러가 예외처리를 확인하지 않는 RuntimeException 클래스들은 unchecked 예외라고 부른다.

### 1.3 예외처리하기 - try-catch문
#### 예외처리의 정의와 목적
예외처리란 프로그램 실행 시 발생할 수 있는 예기치 못한 예외의 발생에 대비한 코드를 작성하는 것이다.</br>
예외처리의 목적은 예외의 발생으로 인한 실행 중인 프로그램의 갑작스런 비정상 종료를 막고, 정상적인 실행상태를 유지할 수 있도록 하는 것이다.

#### try-catch문 작성 방법
```java
try {
	// 예외가 발생할 가능성이 있는 문장
} catch (Exception1 e1) {
	Exception1이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
}  catch (Exception1 e2) {
	Exception2가 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
}  catch (ExceptionN eN) {
	ExceptionN가 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
} 	// 발생한 예외의 종류와 일치하는 단 한 개의 catch블럭만 수행된다.
```
### 1.4 try-catch문에서의 흐름
#### try블럭 내에서 예외가 발생한 경우
발생한 예외와 일치하는 catch블럭이 있는지 확인</br>
일치하는 catch블럭을 찾게 되면 catch블럭 내의 문장들을 수행하고 전체 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행한다. 만일 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못한다.

#### try 블럭 내에서 예외가 발생하지 않은 경우
catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.

### 1.5 예외의 발생과 catch블럭
catch블럭은 괄호( )와 블럭{ } 두 부분으로 나눠져 있는데, 괄호( ) 내에는 처리하고자 하는 예외와 같은 타입의 참조변수 하나를 선언해야 한다.

#### printStackTrace( )와 getMessage( )
예외가 발생했을 때 생성되는 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가 담겨 있다.
- printStackTrace( ): 예외발생 당시의 호출스택에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
- getMessage( ): 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻는다..

#### 멀티 catch블럭
여러 catch블럭을 ‘ | ‘ 기호를 이용해서, 하나의 catch블럭으로 합칠 수 있게 되었다.
```java
try {
…
} catch (ExceptionA | ExceptionB e) { 
	e.printStackTrace();
}
```

##### 멀티 catch블럭에서 에러가 발생하는 경우
- 만약 멀티 catch블럭의 ‘|’ 기호로 연결된 예외클래스가 조상과 자손의 관계에 있다면 컴파일 에러가 발생한다.
- 참조변수 e로 멀티 catch블럭에 '|' 기호로 연결된 예외 클래스들의 공통 분모인 조상 예외 클래스에 선언된 멤버만 사용할 수 있다.</br>멀티 catch는 하나의 catch블럭으로 여러 예외를 처리하는 것이기 때문에, 발생한 예외를 멀티 catch블럭으로 처리하면, 멀티 catch블럭 내에서는 실제로 어떤 예외가 발생한 것인지 알 수 없다.

### 1.6 예외 발생시키기
1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만들고
2. 키워드 throw를 이용해서 예외를 발생시킨다.
```java
Exception e = new Exception(“고의로 발생시켰음");
throw e;
// throw new Exception(“고의로 발생시켰음");	// 한 줄로 줄일 수 있다.
```
#### checked 예외, unchecked 예외
- checked예외: 컴파일러가 예외 처리 여부를 체크(예외 처리 필수)
- unchecked 예외: 컴파일러가 예외 처리 여부를 체크 안 함(예외 처리 선택)

오류
1. 컴파일 에러
2. 런타임 에러
   1. error: 심각
   2. exception: 덜 심각
      1. Exception과 그 자손: checked 예외(try-catch 필수)
      2. RuntimeException과 그 자손: unchecked 예외(try-catch 선택)
3. 논리적 에러

### 1.7 메서드에 예외 선언하기
- 예외를 처리하는 방법: 
  1. 직접 처리: try-catch문
  2. 예외 떠넘기기: 예외 선언하기
  3. 은폐,  덮기(빈 catch)
- 메서드를 호출할 때 발생할 수 있는 예외를 호출하는 쪽에 알리는 것이다.
```java
void method() throws Exception, Exception2, … ExceptionN
{	// 메서드의 내용 	}
```

아래의 오류 코드를 해석하시오.
```java
java.lang.Exception
	at ExceptionEx12.method2(ExceptionEx12.java:11)
	at ExceptionEx12.method1(ExceptionEx12.java:7)
	at ExceptionEx12.main(ExceptionEx12.java:3)
```
- 예외가 발생했을 때, 모두 3개의 메서드(main, method1, method2)가 호출 스택에 있었으며
- 예외가 발생한 곳은 제일 윗줄에 있는 method2( )이다.
- main메서드가 method1( )을, 그리고 method1( )은 method2( )를 호출했다.

### 1.8 finally 블럭
finally블럭은 예외의 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 시용된다.
```java
try - catch - finally의 순서로 구성된다.
try {
	// 예외가 발생할 가능성이 있는 문장들을 넣는다.
} catch (Exception1 e1) {
	// 예외처리를 위한 문장을 적는다.
} finally {
	// 예외의 발생여부에 관계없이 항상 수행되어야 하는 문장을 넣는다.
	// finally 블럭은 try-catch문의 맨 마지막에 위치해야 한다.
}
```

try블럭에서 return 문이 실행되는 경우에도 finally블록의 문장들이 먼저 실행된 후에, 현재 실행 중인 메서드를 종료한다.

### 1.9 자동 자원 반환 
try-with-resource문

### 1.10 사용자 정의 예외 만들기
기존의 예외 클래스를 상속받아서 새로운 예외 클래스를 정의할 수 있다. 

사용자 정의 예외 만드는 순서
1. 조상은 Exception과 RuntimeException 중에서 선택하면 된다.
2. 사용자 정의 예외 클래스도 메시지를 저장할 수 있으려면 String을 매개변수로 받는 생성자를 추가해주어야 한다.

### 1.11 예외 되던지기(exception re-throwing)
- 예외를 처리한 후에 다시 예외를 생성해서 호출한 메서드로 전달하는 것
- 예외가 발생한 메서드와 호출한 메서드, 양쪽에서 예외를 처리해야 하는 경우에 사용. 

### 1.12 연결된 예외(chained exception)
한 예외가 다른 예외를 발생시킬 수도 있다. 예외 A가 예외 B를 발생시켰다면, A를 B의 ‘원인 예외'라고 한다.
두 예외를 포함관계로 맺어주는 것이다.

#### 예외를 원인 예외로 등록해서 다시 예외를 발생시키는 이유
1. 여러 예외를 하나의 큰 분류의 예외로 묶어서 다루기 위해서이다. 이를 통해 예외가 원인 예외를 포함할 수 있게 하였다. 
2. check예외(필수 예외)를 unchecked 예외(선택 예외)로 바꿀 수 있도록 하기 위해서이다. checked 예외를 uncheck예외로 바꾸면 예외처리가 선택적이 되므로 억지로 예외처리를 하지 않아도 된다.

#### 연결된 예외의 장점
1. 예외를 단순화하기
2. 필수예외 → 선택예외