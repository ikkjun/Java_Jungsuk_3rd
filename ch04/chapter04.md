# Chapter 4. 조건문과 반복문(if, switch, for, while statement)
## 1. 조건문 - if, switch
프로그램의 흐름(flow)을 바꾸는 역할을 하는 문장들을 제어문이라고 한다. 제어문에는 ‘조건문과 반복문’이 있다.

조건문은 조건식과 문장을 포함하는 블럭 { }으로 구성된다.

처리할 경우의 수가 많을 때는 if문보다 switch문이 효율적이지만, switch문은 if문보다 제약이 많다.

모든 switch문은 if문으로 변경이 가능하지만, if문은 switch문으로 변경 할 수 없는 경우가 많다. 

### 1.1 if문
```java
if(조건식) { /*조건식이 참(true)일 때 수행될 문장들*/ }
```
만일(if) 조건식이 참이면 괄호{ }안의 문장들을 수행하라

#### 조건식
```java
‘A’<=ch && ch<=’Z’;
‘a’<=ch && ch<=’z’;
‘0’<=ch && ch<=’9’;
str.equals(“yes”);
str.equalsIgnoreCase(“yes”)
```

#### 블럭(block) { }
만일 블럭 내의 문장이 하나뿐 일 때는 괄호 { }를 생략 가능.

### 1.2 if - else 문
```java
if ( ) {
    // 조건식이 참(true)일 때 수행될 문장들을 적는다.
} else {
    // 조건식이 거짓(false)일 때 수행될 문장들을 적는다.
}
```

### 1.3 if - else if 문
```java
if ( ) {
} else if ( ) { 
} else if ( ) { 
} else {
}
```

### 1.4 중첩 if문
if문의 블럭 내에 또 다른 if문을 포함시키는 것이 가능하고, 중첩의 횟수에는 거의 제한이 없다.

중첩 if 문에서는 괄호 { }의 생략에 더욱 조심해야 한다. 괄호가 생략되었을 때 else블럭은 가까운 if문에 속한 것으로 간주되기 때문이다.

### 1.5 switch문
```java
switch ( 조건식 ) {
	case 값1:
		// 조건식의 결과가 값1과 같으면 수행될 문장
		break;
	case 값2:
		// 조건식의 결과가 값1과 같으면 수행될 문장
		break;
	default:
		// 조건식의 결과와 일치하는 case문이 없을 때 수행
}
```

switch문에서 break문은 각 case문의 영역을 구분하는 역할을 하는데. 만일 break문을 생략하면 case문 사이의 구분이 없어지므로 다른 break문을 만나거나 switch문 블럭{ }의 끝을 만날 때까지 나오는 모든 문장들을 수행한다.

#### switch문의 제약조건
1. if문의 조건식과 달리, switch문의 조건식 결과는 정수 또는 문자열이어야 한다.
2. case문의 값은 정수 상수만 가능, 중복되지 않아야 한다. </br>변수는 사용하지 못 한다. 문자는 정수로 저장된다.

#### Math.random()
난수(임의의 수)를 얻기 위해서는 Math.random()을 사용해야 하는데, 이 메서드는 0.0과 1.0사이의 범위에 속하는 하나의 double값을 반환한다.</br> 
1~3 사이의 임의의 정수를 얻는 식 만들기</br>
0.0 <= Math.random() < 1.0</br>
0.0 * 3 <= Math.random() * 3 < 1.0 * 3</br>
(int) 0.0 * 3 <= (int) Math.random() * 3 < (int) 1.0 * 3</br>
0 + 1 <= (int) Math.random() * 3 + 1 < 3 + 1</br>
원하는 개별값의 개수를 곱하면 된다.</br>

## 2. 반복문 - for, while, do - while
for문과 while문은 구조와 기능이 유사하여 어느 경우에나 서로 변환이 가능하다.

### 2.1 for 문
for문은 반복 횟수를 알고 있을 때 적합하다. 

#### for문의 구조와 수행순서
```java
for(초기화 ; 조건식 ; 증감식) {
// 조건식이 true일 때 수행될 문장
}
for(int i; i<= 5 ; i++) {
	System.out.println(“I can do it.”)
}
```

#### 중첩 for문
ex. 별찍기

#### 향상된 for문
```java
for(타입 변수명 : 배열 또는 컬렉션) { /*반복할 문장*/ }
```
타입은 배열 또는 컬렉션의 타입이어야 한다.
```java
for(int i=0;i<arr.length;i++){
	System.out.println(arr[i]);
}
for(int tmp : arr) {
	System.out.println(arr[tmp]);
}
```
while 문
if문처럼 조건식과 블럭 { } 만으로 이루어져 있다. 다만 if문과 달리 while문은 조건식이 참(true)인 동안, 즉 조건식이 거짓이 될 때 까지 블럭 { } 내의 문장을 반복한다.

for문과 while문의 차이점
while문의 조건식은 생략할 수 없다. 그래서 while문의 조건식이 항상 참이 되도록 하려면 반드시 true를 넣어야 한다.
while(true) = for(;;) → 무한 반복문

do - while문
for문이나 while문은 조건식의 결과에 따라 블럭 { }이 한 번도 수행되지 않을 수 있지만 do-while문에 속한 문장은 무조건 최소한 한 번은 수행될 것을 보장된다.

do {
	// 조건식의 연산결과가 참일 때 수행될 문장들
} while (조건식);		// 끝에 ;를 잊지 않도록 주의

break 문
break문은 자신이 포함된 가장 가까운 반복문을 벗어난다. 주로 if문과 함께 사용되어 특정 조건을 만족하면 반복문을 벗어나도록 한다.

continue 문
continue 문은 반복문 내에서만 사용될 수 있으며. 반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복으로 넘어간다. for문의 경우 증감식으로 이 동하며. while문과 do―while문의 경우 조건식으로 이동한다.






break문과 continue문의 차이점
continue문은 반복문 전체를 벗어나지 않고 다음 반복을 계속 수행한다는 접이 break; 문과 다르다. 주로 if문과 함께 사용되어 특정 조건을 만족하는 경우에 continue문 이후의 문장들을 수행하지 않고 다음 반복으로 넘어가서 계속 진행하도록 한다.

이름 붙은 반복문
break 문은 근접한 단 하냐의 반복문만 벗어날 수 있기 때문에, 중첩 반복문 앞에 이름을 붙이고 break문과 continue문에 이름을 지정해 줌으로써 하나 이상의 반복문 을 벗어나거나 반복을 건너뛸 수 있다.

