# 배열
## 1. 배열(Array)
### 배열(Array)이란?
- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것.
- 많은 양의 값(데이터)을 다룰 때 유용하다.
- 배열의 각 요소는 서로 연속적이다. 

### 배열의 선언과 생성
원하는 타입의 변수를 선언하고 변수 또는 타입에 배 열임을 의미하는 대괄호 [ ] 를 붙이면 된다.

### 배열의 생성
배열을 선언한 다음에는 배열을 생성해야한다. 배열을 선언하는 것은 단지 생성된 배열을 다루기 위한 참조변수를 위한 공간이 만들어질 뿐이고, 배열을 생성해야만 비로소 값을 저장할 수 있는 공간이 만들어지는 것이다. 
```java
타입[ ] 변수이름 = new 타입[길이];
int[ ] score = new int[5];
```
① int형 배열 참조변수 score 선언
② 연산자 ‘new’에 의해서 메모리의 빈 공간에 5개의 int형 데이터를 저장할 수 있는 공간이 마련된다.
③ 각 배열요소는 자동적으로 int의 기본값 0으로 초기화된다.
④ 대입연산자 ‘=’에 의해 배열의 주소(0x100)가 int형 배열 참조변수 score에 저장된다.

배열의 길이와 인덱스
인덱스(index)는 배열의 요소마다 붙여진 일련번호
인덱스(index)의 범위는 0부터 ‘배열길이 - 1'까지

배열의 특징
모든 요소가 연속적이다.
모든 요소의 타입이 같다.
생성 후 길이 변경 불가 → 더 큰 배열 생성

배열이름.length
배열은 한번 생성하면 길이를 변경할 수 없기 때문에, 이미 생성된 배열의 길이는 변하지 않는다. 따라서 ‘배열이름.length' 는 상수다. 즉, 값을 읽을수만 있을 뿐 변경할 수 없다.

배열의 길이를 늘릴 수 없는 이유는?
늘리려고 하는 옆의 저장공간이 비어있는지 모른다.

배열의 길이를 변경하는 방법
더 큰 배열을 새로 생성한다.
기존 배열의 내용을 새로운 배열에 복사한다.

### 1.4 배열의 초기화
생성된 배열의 각 요소에 처음으로 값을 저장하는 것
int[ ] score = new int[ ] {50,60,70,80,90};
int [] score;
score = new int[ ]  {50,60,70,80,90}; // OK
score =  {50,60,70,80,90};	
// 에러. 배열의 선언과 생성을 따로 하면 new 타입 생략 불가.

1.5 배열의 복사
for문을 이용한 배열의 복사
int[] arr = new int [5];
int[] tmp = new int[arr.length*2];
for(int i=0; i<arr.length; i++)
	tmp[i] = arr[i];
arr = tmp;

System.arraycopy()를 이용한 배열의 복사
배열의 복사는 for문보다 System.arraycopy()를 사용하는 것이 효율적이다.
System.arraycopy(num, 0, newNum, 0, num.length);
num[0]에서 newNum[0]으로 num.length개의 데이터 복사

1.6 배열의 활용
총합과 평균
최대값과 최소값
섞기(shuffle)
임의의 값으로 배열 채우기
정렬하기(sort)
빈도 수 구하기

2. String 배열
2.1 String 배열의 선언과 생성
String[ ] name = new String[3];
참조형 변수 기본값은 null이므로 각 요소의 값은 null로 초기화

타입에 따른 변수의 기본값
자료형
기본값
boolean
false
char
‘\u0000’
byte, short, int
0
long
0L
float
0.0f
double
0.0d 또는 0.0
참조형 변수
null


2.2 String 배열의 초기화
String[ ] name = new String[3];
name[0] = “Kim”;
name[1] = “Kim”;
name[2] = “Kim”;
// String[ ] name = new String[ ] {“Kim”, “Park”, “Yi”};

기본형 배열이 아닌 경우, 즉. 참조형 배열의 경우 배열에 저장되는 것은 실제 객체가 아닌 객체의 주소이다.
2.3 char 배열과 String 클래스
String클래스는 char배열에 기능(메서드)을 추가한 것이다.

char배열과 String클래스의 중요한 차이점
String 객체(문자열)는 읽을수만 있을 뿐 내용을 변경할 수 없다는 것이다.

String str = “Java”;
str = str + “8”;		
// “Java8”이라는 새로운 문자열이 str에 저장
System.out.println(str);
// “Java8”
위의 문장에서 문자열 str의 내용이 변경되는 것 같지만, 문자열은 변경할 수 없으므로 새 로운 내용의 문자열이 생성된다.

char배열과 String클래스의 변환
char[ ] chArr = {‘A’, ‘B’, ‘C’};
String str = new String(chArr);		//char배열→String
char[ ] tmp = str.toCharArray();	//String→char배열


2.4 커맨드 라인을 통해 입력받기

3. 다차원 배열
3.1 2차원 배열의 선언과 인덱스
타입[ ][ ] 변수 이름 = new int [ ][ ];	
// int[ ][ ] score = new int[4][3];

3.2 2차원 배열의 초기화
int[ ][ ] arr = 	{
		{1,2,3},
		{4,5,6}
		};

for(int i=0;i<score.length;i++) {
	for(int j = 0; score[i].length;j++) {
		System.out.printf(“score[%d][%d]
=%d%n”, i, j, score[i][j]);

평균구할 때 분모를 float로 형변환하기

3.3 가변 배열
int[ ][ ] score = new int[5][ ];	
// 두 번째 차원의 길이는 지정하지 않는다.
score[0] = new int[3];
score[1] = new int[3];
score[2] = new int[3];
score[3] = new int[3];
score[4] = new int[3];
// 직사각형 테이블 형태의 고정적인 배열만 생성할 수 있다. 

int[ ][ ] score = new int[5][ ];	
score[0] = new int[4];
score[1] = new int[3];
score[2] = new int[2];
score[3] = new int[2];
score[4] = new int[3];
// 각 행마다 다른 길이의 배열 생성

3.4 다차원 배열의 활용
좌표에 X표하기
빙고
행렬의 곱셈
단어 맞추기

