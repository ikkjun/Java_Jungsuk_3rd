## 1. 변수와 상수
변수란?</br>
단 하나의 값을 저장할 수 있는 메모리 공간.</br>
메모리 주소에 이름을 붙인 것

변수의 선언
int 		age;
변수타입	변수 이름
변수를 선언하면. 메모리의 반공간에 ‘변수타입’에 알맞은 크기의 저장공간이 확보되고, 앞으로 이 저장공간은 ‘변수이름'을 통해 사용할 수 있게 된다.

변수의 초기화(initialization)
변수를 사용하기 전에 처음으로 값을 저장하는 것.
변수를 선언한 이후부터는 변수를 사용할 수 있으나, 그 전에 반드시 변수를 초기화해야 한다.
int age = 27; // 변수 age를 선언하고 27로 초기화한다.

### 변수의 명명규칙
1. 대소문자가 구분되며 길이에 제한이 없다.
   - True와 true는 서로 다른 것으로 간주된다. 
2. 예약어를 사용해서는 안 된다. 
   - true는 예약어 → 사용불가, True는 가능. 
3. 숫자로 시작해서는 안 된다.
   - top10은 허용. 7up은 허용되지 않는다. 
4. 특수문자는 ‘_’와 '$'만을 허용한다.
   - $harp은 허용, S#arp은 허용되지 않는다.

## 2. 변수의 타입
모든 값에는 type이 있고, Type을 모르면 해석할 수 없다.
자료형(data type)과 타입(type)의 차이는?
기본형은 저장할 값(data)의 종류에 따라 구분되므로 기본형의 종류를 얘기할 때는 ‘자료형(data type)'이라는 용어를 쓴다. 그러나 참조형은 항상 ‘객체의 주소(4 byte 정수)’를 저장하므로 값(data)이 아닌, ‘타입(type)'이라는 용어를 사용한다.

### 2.1 기본형(primitive type)
계산을 위한 실제 값을 저장한다. 
기본형에는 모두 8개의 타입(자료형)이 있으며, 논리형(boolean), 문자형(char), 정수형(byte, short, int, long), 실수형(float, double)으로 구분된다.
종류 크기
1byte
2byte
4byte
8byte
논리형
boolean






문자형


char




정수형
byte
short
int
long
실수형




float
double


### 2.2 상수와 리터럴(constant & literal)
상수: 값을 한 번 저장하면 변경할 수 없는 저장공간</br>
리터럴: 그자체로 값을 의미하는 것.</br>
final int age(상수) = 27(리터럴); </br>

#### 상수가 필요한 이유
상수는 리터럴에 '의미 있는 이름'을 붙여서 코드의 이해와 수정을 쉽게 만든다.

#### 리터럴의 타입과 접미사
정수형과 실수형에는 여러 타입이 존재하므로, 리터럴에 접미사를 붙여서 타입을 구분한다. 
정수형의 경우. long타입의 리터럴에 접미사 ‘l’또는 ‘L’을 붙이고. 접미사가 없으면 int타입의 리터럴이다.
실수형에서는 float타입의 리터럴에 'f'를, double 타입 리터럴에는 'd'를 붙인다. 실수형에서는 double이 기본 자료형이라서 접미사'd'는 생략이 가능하다. 

#### 타입의 불일치
리터럴의 타입은 저장될 변수의 타입과 일치하는 것이 보통이지만, 타입이 달라도 저장 범위가 넓은 타입에 좁은 타입의 값을 저장하는 것은 허용된다. 그러나 리터럴의 값이 변수의 타입의 범위를 넘어서거나, 리터럴의 타입이 변수의 타입보다 저장범위가 넓으면 컴파일 에러가 발생한다.

#### 문자 리터럴과 문자열 리터럴
'A'와 같이 작은따옴표로 문자 하나를 감싼 것을 '문자 리터럴’이라고 한다. 두 문자 이상은 큰따옴표로 감싸야 하며 ‘문자열 리터럴이라고 한다.
덧셈 연산자(+)는 피연산자 중 어느 한 쪽이 String이면 나머지 한 쪽을 먼저 String으로 변환한 다음 두 String을 결합한다.

### 2.3 형식화된 출력 - printf()

| 지시자    | 설명                              |
|--------|---------------------------------|
| %b     | 불리언(boolean) 형식으로 출력            |
| %d     | 10진(decimal) 정수의 형식으로 출력        |
| %o     | 8진(octal) 정수의 형식으로 출력           |
| %x, %X | 16진(hexa-decimal)정수의 형식으로 출력    |
| %f     | 부동 소수점(floating-point)의 형식으로 출력 |
| %e, %E | 지수(exponent) 표현식의 형식으로 출력       |
| %c     | 문자(character)로 출력               |
| %s     | 문자열(string)로 출력                 | 

```java
System.out.printf("[%5d]%n", 10);   // [      10]
System.out.printf("[%-5d]%n", 10) ; // [10      ]	
System.out.printf("[%05d]%n", 10);  // [00010]
```

### 2.4 화면에서 입력받기 - Scanner
```java
import java.util .*; 
/ / Scanner 클래스를 사용하기 위해 추가
Scanner scanner = new Scanner (System. in) ; 
// Scanner 클래스의 객체를 생성
String input = scanner.nextLine () ; 
// 입력받은 내용을 input에 저장 
int num = Integer .parseint(input); 
// 입력받은 내용을 int 타입의 값으로 변환
```

## 3. 진법
### 3.1 10진법과 2진법
컴퓨터는 2진수(0과 1) 밖에 모르기 때문에 10진수의 숫자를 2진수로 바꾸어 저장한다.

### 3.2 비트(bit)와 바이트(byte)
한 자리의 2진수를 ‘비트(bit. binary digit)'라고 하며. 1 비트는 컴퓨터가 값을 저장할 수 있는 최소단위이다. 그러나 1 비트는 너무 작은 단위이기 때문에 1비트 8개를 묶어서 ‘바이트(byte)' 라는 단위로 정의해서 데이터의 기본 단위로 사용한다.

### 3.3 8진법과 16진법
8진수는 2진수 3자리를, 16진수는 2진수 4자리를 각각 한 자리로 표현할 수 있기 때문에 자리수가 짧아져서 알아 보기 쉽고 서로 간의 변환방법 또한 매우 간단하다.
1010101100(2) = 1254(8) = 2AC(8)

### 3.4 정수의 진법 변환
#### 10진수를 n진수로 변환
10진수를 다른 진수로 변환하려면, 해당 진수로 나누고 나머지 값을 옆에 적는 것을 더 이상 나눌 수 없을 때까지 반복한 다음 마지막 몫과 나머지를 아래부터 위로 순서대로 적으면 된다.

#### n진수를 10진수로 변환
각 자리의 수에 해당 단위의 값을 곱해서 모두 더하면 된다.

### 3.5 실수의 진법변환
#### 10 소수점수를 2진 소수점수로 변환하는 방법
1. 10진 소수에 2를 곱한다
2. 위의 결과에서 소수부분만 가져와서 다시 2를 곱한다.
3. 1과 2의 과정을 소수부가 0이 될 때까지 반복한다.
4. 위의 결과에서 정수부분만 위에서 아래로 순서대로 적고 0을 앞에 붙이면 된다.

### 3.6 음수의 2진 표현 - 2의 보수법
#### 어떤 수의 'n의 보수’는 더했을 때 n이 되는 수
0101(2) → 1011(2)  
2의 보수 = 1의 보수 + 1

#### 음수의 2진 표현을 구하는 방법
음수의 절대값을 2진수로 변환한다.
(1)에서 구한 2진수의 1을 0으로 0은 1로 바꾼다.
(1의 보수 구하기)
(2)의 결과에 1을 더한다.(2의 보수, 1의 보수 + 1)

## 4. 기본형(primitive type)
### 4.1 논리형 - boolean
기본값은 false이다. boolean형은 true와 false, 두 가지의 값만을 표현하면 되므로 1 bit만으로도 충분하지만, 자바에서는 데이터를 다루는 최소단위가 byte이기 때문에, boolean의 크기가 1byte이다. 

### 4.2 문자형 - char
```java
char ch = ‘A’;	// 문자 ‘A’를 char타입의 변수 ch에 저장
```
위의 문장은 변수에 '문자'가 저장되는 것 같지만, 사실은 문자가 아닌 '문자의 유니코드(정수)'가 저장된다. 문자'A'의 유니코드는 65이므로, 변수 ch에는 65가 저장된다.

### 4.3 정수형 - byte, short, int, long
#### 정수형의 표현형식과 범위
n비트로 표현될 수 있는 정수의 개수: 2<sup>n</sup>개</br>
n비트로 표현할 수 있는 부호있는 정수의 범위: -2<sup>n-1</sup>~2<sup>n-1</sup>-1</br>
위의 범위의 최대값에서 1을 빼는 이유는 범위에 0이 포함되기 때문이다.

#### 정수형의 오버플로우
타입이 표현할 수 있는 값의 범위를 넘어서는 것을 오 버플로우(overflow)라고 한다.</br>
최대값 + 1 → 최소값</br>
최소값 - 1 → 최대값</br>

### 4.4 실수형 - float, double
#### 실수형의 범위와 정밀도
float 정밀도: 7자리
double 정밀도: 15자리

## 5. 형변환
### 형변환(캐스팅, casting)이란?
변수 또는 상수의 타입을 다른 타입으로 변환하는 것

### 형변환 방법
(타입) 피연산자
피연산자 변수의 값은 형변환후에도 아무런 변화가 없다.

'2' → 2 : - '0'</br>
2 → '2' : + '0'

"2" → 2 : Integer.parseInt("2") </br>
2 → "2" : + ""(빈 문자열)

#### 자동 형변환의 규칙
형변환을 생략하면 컴파일러는 기존의 값을 최대한 보존할 수 있는 타입으로 자동 형변환한다.
1. boolean을 제외한 나머지 7개의 기본형은 서로 형변환이 가능하다. 
2. 기본형과 참조형은 서로 형변환할 수 없다. 
3. 서로 다른 타입의 변수간의 연산은 형변환을 하는 것이 원칙이지만, 값의 범위가 작은 타입에서 큰 타입으로의 형변환은 생략할 수 있다.