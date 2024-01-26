# 컬렉션 프레임웍(Collection Framework)
## 1. 컬렉션 프레임웍(Collection Framework)
컬렉션: 여러 객체(데이터)를 모아 놓은 것을 의미</br>
프레임웍(framework): 표준화, 정형화된 프로그램 방식</br>

컬렉션 프레임웍이란?</br>
컬렉션(다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식</br>
컬렉션 클래스: 다수의 데이터를 저장할 수 있는 클래스 

### 1.1 컬렉션 프레임웍의 핵심 인터페이스
|인터페이스|특징|구현 클래스|
|---|---|---|
|List|순서가 있는 데이터의 집합. 데이터의 중복을 허용한다.(순서 O, 중복 O)|Vector(old), Stack, ArrayList(new), LinkedList|
|Set|순서를 유지하지 않는 데이터의 집합. 데이터의 중복을 허용하지 않는다. (List와 정반대; 순서 X, 중복 X)|HashSet, Treeset|
|Map|키(key)와 값(value)이 쌍(pair)으로 이루어진 데이터의 집합. 순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다.(순서 X, 중복: 키 X / 값 O)|Hashtable(old), HashMap(new), LinkedHashMap(순서 o), SortedMap, Treemap|

인터페이스 List, Set을 구현한 컬렉션 클래스는 많은 공통부분이 있어서 공통된 부분을 뽑아 Collection인터페이스를 정의할 수 있었지만 Map인터페이스는 전혀 다른 형태로 컬렉션을 다루기 때문에 같은 상속계층도에 포함되지 못한다.

#### Map.Entry 인터페이스
Map.Entry 인터페이스는 Map인터페이스의 내부 인터페이스이다. Map에 저장되는 key-value쌍을 다루기 위해 내부적으로 Entry인터페이스를 정의했다.

### 1.2 ArrayList - List 인터페이스를 구현
- ArrayList는 기존의 Vector를 개선한 것으로 Vector와 구현원리와 기능적으로 동일하다. 
- ArrayList는 List 인터페이스를 구현하기 때문에 데이터의 저장순서가 유지되고 중복을 허용한다.
- ArrayList와 달리 Vector는 자체적으로 동기화 처리가 되어 있다. 
- ArrayList는 Object 배열을 이용해서 데이터(객체만)를 순차적으로 저장한다. 
- 저장된 마지막 객체부터 삭제해야 빠르다(배열복사가 발생하지 않기 때문).

#### 데이터를 삽입, 삭제하는 방법
1. 전체를 이동시키는 방법
2. 비어진 목록을 관리하는 방법(DB 방식)

#### ArrayList에 있는 값을 삭제하는 방법
변수 i를 증가시키면서 삭제하면, 한 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 자리이동을 하기 때문에 올바른 결과를 얻을 수 없다. 그래서 제어변수를 감소시키면서 삭제를 해야 자리이동의 영향을 받지 않는다.

#### 배열(ArrayList, Vector)의 장단점
장점: 구조가 간단, 데이터를 읽는데 걸리는 시간(접근 시간)이 가장 빠르다. </br>
단점1: 크기를 변경할 수 없다. (① 더 큰 배열을 생성, ② 복사, ③ 참조 변경)</br>
단점2: 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸린다. </br>
- 차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는 것은 빠르지만, 배열의 중간에 데이터를 추가하려면, 빈자리를 만들기 위해 다른 데이터들을 복사해서 이동해야 한다.

### 1.3 LinkedList - 배열의 단점을 보완
- 배열과 달리 LinkedList는 불연속적으로 존재하는 데이터를 연결(link).
- LinkedList의 각 요소(node)들은 자신과 연결된 다음 요소에 대한 참조(주소값)와 데이터로 구성되어 있다.
- 데이터의 추가: 한 번의 Node객체 생성과 두 번의 참조 변경만으로 가능
- 데이터의 삭제: 단 한 번의 참조 변경만으로 가능

#### LinkedList의 장단점
- 장점: 유연하고, 변경이 쉽다.
- 단점1: 연결 리스트이므로 데이터 접근성(accessibility)이 낮다. (첫 번째 요소는 두 번째 요소에 대해서만 알고 있을 뿐, 세 번째 요소는 모르기 때문)
- 단점2: 이동방향이 단방향이기 때문에 다음 요소에 대한 접근은 쉽지만 이전요소에 대한 접근은 어렵다(→ 이중 연결 리스트 나옴).

#### 더블리 링크드 리스트(doubly linked list) - 단방향으로 이동하는 LinkedList의 단점 해결
링크드 리스트에 참조변수를 하나 더 추가하여 다음 요소에 대한 참조뿐 아니라 이전 요소에 대한 참조가 가능하도록 하면서 접근성이 향상되었다. 

#### doubly circular linked list(이중 원형 연결리스트)
더블 링크드 리스트의 첫 번째 요소와 마지막 요소를 서로 연결시킨 것이다.

#### ArrayList(배열기반) vs. LinkedList(연결기반) - 성능 비교

| |ArrayList| LinkedList|
|---|---|---|
|순차적으로 추가/삭제|빠름|느림|
|비순차적으로 데이터를 추가/삭제|느림|빠름|
|접근시간|빠름|느림|
|비고|순차적인 추가, 삭제는 빠르나 비효율적으로 메모리를 사용한다.|데이터가 많을수록 접근성이 떨어진다.|

#### 배열기반과 연결기반의 차이점
배열기반은 연속적이지만 연결기반은 불연속적이다.

#### 데이터의 주소 구하는 방법
인덱스가 n인 데이터의 주소 = 배열의 주소 + n * 데이터 타입의 크기
Object배열 arr[2]에 저장된 값을 읽으려면 n은 2, 모든 참조형 변수의 크기는 4byte이고 생성된 배열의 주소는 0x100이므로 0x100 + 2 * 4 = 0x108이다.

### 1.4 Stack과 Queue

| |Stack(스택)|Queue(큐)|
|---|---|---|
|구조|LIFO 구조. 마지막에 저장된 것을 제일 먼저 꺼낸다. | FIFO 구조. 제일 먼저 저장한 것을 제일 먼저 꺼낸다.|
|저장과 추출|push / pop|offer / poll|
|유리한 분야|배열에 유리|링크드 리스트에 유리|
|활용 예시|수식계산, 수식 괄호 검사, undo / redo, 웹브라우저의 뒤로, 앞으로|최근 사용 문서, 인쇄 작업 대기 목록, 버퍼(buffer)|

#### 스택과 큐의 차이점
스택은 Stack 클래스로 구현하여 제공하고 있지만, 큐는 Queue인터페이스로만 정의해 놓았을 뿐 별도의 클래스를 제공하고 있지 않다. 그러므로 Queue를 직접 구현하거나, Queue를 구현한 클래스를 사용해야 한다.
```java
Stack s = new Stack( );  /* 가능 */ 
Queue q = new Queue( ); /* 불가능 */
Queue q = new LinkedList( )
```

#### Queue의 변형
##### PriorityQueue
- 저장한 순서에 관계없이 우선순위(priority)가 높은 것부터 꺼내게 된다. 
- null은 저장할 수 없다. null을 저장하면 NullPointerException이 발생한다. 
- 저장공간으로 배열을 사용, 각 요소를 힙(heap) 자료구조의 형태로 저장한다. 

##### Deque(Double - Ended Queue)
Queue의 변형으로, 한 쪽 끝으로만 추가/삭제할 수 있는 Queue와 달리, Deque은 양쪽 끝에 추가/삭제가 가능하다. Deque의 조상은 Queue이며. 구현체로는ArrayDeque과 LinkedList 등이 있다.

### 1.5 Iterator, ListIterator, Enumeration		
- 컬렉션에 저장된 데이터를 접근하는데 사용되는 인터페이스
Enumeration: Iterator의 구버전</br>
ListIterator: Iterator의 접근성을 향상시킨 것 (단방향 → 양방향) 

#### Iterator
컬렉션에 iterator( )를 호출해서 Iterator(일회용)를 얻은 다음, 주로 while문을 사용해서 컬렉션 클래스의 요소들을 읽어올 수 있다.
```java
Collection c = new ArrayList( ); // 다른 컬렉션으로 변경시 이 부분만 고치기.
Iterator it = c.iterator( );
while(it.hasNext( )) { // ① boolean 읽어 올 요소가 남아 있는지 확인
	System.out.println(it.next( ));	 // ② 다음 요소 읽어오기
}
```
Iterator의 remove( )는 단독으로 쓰일 수 없고, next()와 같이 써야 한다. 특정위치의 요소를 삭제히는 것이 아니라 읽어 온 것을 삭제한다. next( )의 호출없이 remove()를 호출하면, IllegalStateException이 발생한다. 

#### Map과 Iterator
Map인터페이스를 구현한 컬렉션 클래스는 키(key)와 값(value)을 쌍(pair)으로 저장하고 있기 때문에 iterator( )를 직접 호출할 수 없다. 그 대신 keySet( )와 entrySet( )과 같은 메서드를 통해서 키와 값을 각각 따로 Set의 형태로 얻어 온 후에 다시 iterator()를 호출해야 Iterator를 얻을 수 있다.
```java
Iterator it = map.entrySet( ).iterator( );
//	    Set인스턴스.iterator( );//map.entrySet( )실행결과가 Set이므로
```

### 1.6 Arrays - 배열을 다루기 편리한 static 메서드 제공(Math)
1. 배열의 출력 - toString()
2. 배열의 복사 - copyOf( ), copyOfRange( )(새로운 배열 생성해서 반환)
3. 배열 채우기 - fill( ), setAll( )
4. 배열의 정렬과 검색 - sort( ), binarySearch( )
- 순차 검색(linear search): 배열의 첫 번째 요소부터 순서대로 하나씩 검색하는 것.</br>
배열이 정렬되어 있을 필요는 없지만 배열의 요소를 하나씩 비교하기 때문에 시간이 많이 걸린다.
- 이진 검색(binary search): 배열의 검색할 범위를 반복적으로 절반씩 줄여가면서 검색하기 때문에 검색 속도가 상당히 빠르다.</br>
단, 배열이 정렬이 되어 있는 경우에만 사용할 수 있다는 단점이 있다.
5. 배열의 비교와 출력 - equals(), toString()</br>
다차원 배열의 출력 - deepToString( )</br>
다차원 배열의 비교 - deepEquals( )</br>
6. 배열을 List로 변환 - asList(Object… a) // 가변 매개변수 </br>
asList( )가 반환한 List의 크기를 변경할 수 없다. 왜냐하면 asList( ) 가 반환한 것을 읽기만 할지 읽고 쓸지 모르기 때문에 빨리 전달할 수 있는 얕은 복사를 통해 List의 크기를 변경할 수 없게 한다.
7. 람다와 스트림 관련 - parrelXXX( ), spliterator( ), stream( )

### 1.7 Comparator와 Comparable
객체 정렬에 필요한 메서드(정렬 기준 제공)를 정의한 인터페이스
- Comparable: 기본 정렬 기준(사전순, 오름차순)을 구현하는 데 사용
- Comparator: 기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용

정렬 과정 ① 두 대상 비교 ② 자리 바꿈 / 정렬하려면 ① 대상 ② 비교기준 필요

#### Comparable과 Comparator의 차이점
- 공통점
compare( )와 compareTo( )는 두 객체의 비교결과를 반환하도록 작성.</br> 
같으면 0, 오른쪽이 크면 음수(-), 오른쪽이 작으면 양수(+)</br>
비교가 뺄셈보다 성능이 좋다(모든 자릿수를 계산할 필요가 없기 때문) → 삼항 연산자 활용
- Comparator의 compare메서드는 두 객체를 비교하지만 Comparable의 compareTo는 객체를 자신과 비교한다.

#### equals( )와 compareTo( )의 차이점
equals: x == x && y == y. 즉 둘 다 일치해야 true이다.</br>
compareTo: x를 기준으로 할지 y를 기준으로 할지 정해야 한다. 순서를 알려줌 

### 1.8 HashSet - 순서x, 중복x
- Set인터페이스를 구현한 가장 대표적인 컬렉션 클래스
- 순서를 유지하려면 LinkedHashSet클래스를 사용하면 된다.
HashSet은 객체를 저장하기 전에 기존에 같은 객체가 있는지 확인한다.
같은 객체가 없으면 저장하고 있으면 저장하지 않는다.
HashSet의 add메서드(boolean add(Object o))는 새로운 객체를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기 위해 추가하려는 객체의 equals( )와 hashCode( )를 호출해서 (iv를 비교하도록) equals( )와 hashCode( )가 오버라이딩 되어 있어야 한다. 

#### 오버라이딩으로 작성된 hashCode( )가 만족해야 할 조건
실행중인 애플리케이션 내의 동일한 객체에 대해서 여러 번 hashCode(  )를 호출해도 동일한 int값을 반환해야 한다.
equals메서드를 이용한 비교에 의해서 true를 얻은 두 객체에 대해 각각 hashCode( )를 호출해서 얻은 결과는 반드시 같아야 한다.
equals메서드를 호출할 때 false를 반환하는 두 객체는 hashCode( ) 호출에 대해 같은 int값을 반환해도 괜찮지만, 해싱을 사용하는 컬렉션의 성능을 향상시키려면 다른 int값을 반환하는 것이 좋다.

### 1.9 TreeSet
- HashSet보다 데이터 추가, 삭제에 시간이 더 걸린다.
- 이진 검색 트리(binary search tree)라는 자료구조의 형태로 데이터를 저장
- 범위검색(range search)과 정렬에 높은 성능을 보이는 자료구조.
- Set인터페이스를 구현했으므로 중복된 데이터의 저장을 허용하지 않으며 정렬된 위치에 저장하므로 저장순서를 유지하지도 않는다.

이진 트리(binary tree)
링크드리스트처럼 여러 개의 노드(node)가 나무(tree)형태로 연결 서로 연결된 구조로 각 노드에 최대 2개(0~2개)의 하위노드를 연결할 수 있으며 루트(root)라고 불리는 하나의 노드에서부터 시작해서 계속 확장해 나갈 수 있다.

이진 검색 트리(Binary search tree)
부모노드의 왼쪽에는 부모노드의 값보다 작은 값의 자식노드를 오른쪽에는 큰 값의 자식노드를 저장하는 이진 트리이다.
첫 번째로 저장되는 값이 루트가 된다.
단점: 데이터가 많아질수록 추가, 삭제에 많은 시간이 더 걸림(비교 횟수 증가)
노드의 추가 삭제에 시간이 걸린다(순차적으로 저장하지 않으므로).
중복된 값을 저장하지 못한다.
HashSet과 TreeSet의 비교
HashSet은 equals( )와 hashCode( )로 비교한다.
TreeSet은 compare( )를 호출해서 비교한다.

### 1.10 HashMap과 Hashtable: 순서x, 중복(키x, 값o)
HashMap(동기화x)은 Hashtable(동기화o)의 신버전
순서를 유지하려면 LinkedHashMap클래스를 사용하면 된다.

HashMap은 Map인터페이스를 구현했으므로 키와 값을 묶어서 하나의 데이터(entry)로 저장한다는 특징을 갖는다. 
해싱을 사용하기 때문에 많은 양의 데이터를 검색하는 데 있어서 뛰어난 성능.

키(key): 컬렉션 내의 키 중에서 유일해야 한다.
값(value): 키와 달리 데이터의 중복을 허용한다.

HashMap은 Entry라는 내부 클래스를 정의하고, 다시 Entry타입의 배열을 선언하는 이유는?
키와 값(value)은 별개의 값이 아니라 서로 관련된 값이기 때문에 각각의 배열로 선언하기 보다는 하나의 클래스로 정의해서 하나의 배열로 다루는 것이 데이터의 무결성(integrity)적인 측면에서 더 바람직하기 때문이다.

해싱(Hashing)과 해시함수
해싱이란 해시함수(hash function)을 이용해서 데이터를 해시테이블(hash table)에 저장하고 검색하는 기법이다. ex) HashSet, HashMap, Hashtable
해싱에서 사용하는 자료구조는 배열과 링크드 리스트의 조합으로 되어 있다.

해싱을 통해 데이터를 검색하는 과정
검색하고자 하는 값의 키로 해시함수를 호출한다.
해시함수의 계산결과(해시코드)로 해당 값이 저장되어 있는 링크드 리스트를 찾는다.
링크드 리스트에서 검색한 키와 일치하는 데이터를 찾는다.
해시함수는 같은 키에 대해 항상 같은 해시코드를 반환해야 한다. 
서로 다른 키일지라도 같은 값의 해시코드를 반환할 수도 있다.

### 1.11 TreeMap
이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장한다.
HashMap보다 데이터 추가, 삭제에 시간이 더 걸린다(비교해서 저장하기 때문)
검색에 관한한 대부분의 경우에서 HashMap이 TreeMap보다 더 뛰어나다. 다만, 범위검색이나 정렬이 필요한 경우에는 TreeMap을 사용하는 것이 좋다.

### 1.12 Properties 
Properties는 Hashtable을 상속받아 구현한 것으로, Map의 특성상 저장순서를 유지하지 않는다. 
Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 Properties는 (String, String)의 형태로 저장.
주로 애플리케이션의 환경설정과 관련된 속성(property)을 저장하는데 사용되며 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다. 

### 1.13 Collections
컬렉션과 관련된 메서드(static)를 제공
Collection은 인터페이스이지만, Collections는 클래스이다.
컬렉션 채우기, 복사, 정렬, 검색 - fill(), copy(), sort(), binarySearch() 등
컬렉션의 동기화 - synchronizedXXX();
변경불가(readOnly) 컬렉션 만들기 - unmodifiableXXX( )
싱글톤 컬렉션 만들기 - singletonXXX( )
객체 1개만 저장
한 종류의 객체만 저장하는 컬렉션 만들기 - checkedXXX( )
지네릭스: 한 종류 저장 컬렉션



컬렉션
특징
ArrayList
배열기반. 데이터의 추가와 삭제에 불리. 순차적인 추가삭제는 제일 빠름. 
임의의 요소에 대한 접근성(accessibility)이 뛰어남.
LinkedList
연결기반. 데이터의 추가와 삭제에 유리. 임의의 요소에 대한 접근성이 좋지 않다.
HashMap
배열과 연결이 결합된 형태. 추가, 삭제, 검색, 접근성이 모두 뛰어남. 검색에는 최고성능을 보인다.
TreeMap
연결기반. 정렬과 검색(특히 범위검색)에 적합. 검색성능은 HashMap보다 떨어짐.
Stack
Vector를 상속받아 구현
Queue
LinkedList가 Queue인터페이스를 구현
Properties
Hashtable을 상속받아 구현
HashSet
HashMap을 이용해서 구현
TreeSet
TreeMap을 이용해서 구현
LinkedHashMap
LinkedHashSet
HashMap과 HashSet에 저장 순서 유지 기능을 추가

<img src="interface.png">
