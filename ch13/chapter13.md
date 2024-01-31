# 쓰레드(Thread)
## 1. 프로세스와 쓰레드
#### 프로세스(process)란?
실행 중인 프로그램(실행 가능한 파일; pro + gram = text)
#### 쓰레드란?
프로세스 내에서 프로세스의 자원을 이용해서 실제로 작업을 수행하는 것</br>
모든 프로세스에는 최소한 하나 이상의 쓰레드가 존재하며, 둘 이상의 쓰레드를 가진 프로세스를 ‘멀티쓰레드 프로세스(multi - threaded process)’라고 한다.

#### 싱글쓰레드와 멀티쓰레드
싱글쓰레드 = 자원 + 쓰레드
멀티쓰레드 = 자원 + 쓰레드 + 쓰레드 + …

### 멀티태스킹과 멀티쓰레딩
#### 멀티 태스킹
동시에 여러 프로세스를 실행시키는 것

#### 멀티쓰레딩
- 하나의 프로세스 내에 동시에 여러 쓰레드를 실행시키는 것
- 하나의 새로운 프로세스를 생성하는 것보다 하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다.
- 같은 프로세스 내의 쓰레드들은 서로 자원을 공유한다.
- 대부분의 프로그램이 멀티쓰레드로 작성되어 있다.

### 멀티쓰레딩의 장단점
#### 멀티쓰레딩의 장점 ★
- CPU의 사용률을 향상시킨다. 
- 시스템 자원을 보다 효율적으로 사용할 수 있다. 
- 사용자에 대한 응답성이 향상된다. 
- 작업이 분리되어 코드가 간결해진다.

#### 멀티쓰레딩의 단점
- 여러 쓰레드가 같은 프로세스 내에서 자원을 공유하면서 작업하면서 문제 발생
- 동기화(synchronization)에 주의해야 한다.
- 교착상태(deadlock)가 발생하지 않도록 주의해야 한다.
- 기아(starvation) 현상이 발생하지 않도록 각 쓰레드가 효율적으로 고르게 실행될 수 있어야 한다.

## 2. 쓰레드의 구현과 실행
쓰레드를 구현하는 방법은 Thread클래스를 상속받는 방법과 Runnable 인터페이스를 구현하는 방법 두 가지가 있다.
Thread클래스를 상속받으면 다중상속이 불가능하기 때문에 다른 클래스를 상속받을 수 없어서, Runnable인터페이스를 구현하는 방법이 일반적이다.
```java
class MyThread extends Thread {
    public void run() {/*작업 내용*/}
}

class MyThread implements Runnable {
    public void run() { /* 작업 내용 */ }
}
```

Thread 클래스를 상속받으면, 자손 클래스에서 조상인 Thread클래스의 메서드를 직접 호출할 수 있지만, Runnable을 구현하면 Thread클래스의 static메서드인 currentThread()를 호출하여 쓰레드에 대한 참조를 얻어와야만 호출이 가능하다.
그래서 Thread를 상속받은 클래스에서는 간단히 getName()을 호출하면 되지만, Runnable을 구현한 클래스의 멤버는 run() 밖에 없기 때문에 Thread클래스의 getName()을 호출하려면 Thread.currentThread().getName()와 같이 해야 한다.
```java
static Thread currentThread()
String getName( )
```
### 쓰레드의 실행 - start()
쓰레드를 생성했다고 해서 자동으로 실행되는 것은 아니다. start()를 호출해야만 쓰레드가 실행된다.
그러나 사실 start()가 호출되었다고 해서 바로 실행되는 것이 아니라, 일단 실행대기 상태에 있다가 자신의 차례가 되어야 실행된다. 쓰레드의 실행순서는 OS의 스케줄러가 작성한 스케줄에 의해 결정된다.

## 3. start( )와 run( )
#### run( )
main메서드에서 run()을 호출하는 것은 생성된 쓰레드를 실행시키는 것이 아니라 단순히 클래스에 선언된 메서드를 호출하는 것일 뿐이다.

#### start( )
반면에 start( )는 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택(call stack)을 생성한 다음에 run()을 호출해서 생성된 호출스택에 run()이 첫 번째로 올라가게 한다.
모든 쓰레드는 독립적인 작업을 수행하기 위해 자신만의 호출스택을 필요로 하기 때문에, 새로운 쓰레드를 생성하고 실행시킬 때마다 새로운 호출스택이 생성되고 쓰레드가 종료되면 작업에 시용된 호출스택은 소멸된다.

#### main쓰레드
- main메서드의 작업을 수행하는 쓰레드
- 실행 중인 사용자 쓰레드가 하나도 없을 때 프로그램은 종료된다.
- 쓰레드는 사용자 쓰레드(user thread)와 데몬 쓰레드(daemon thread)가 있다

## 4. 싱글쓰레드와 멀티쓰레드
하나의 쓰레드로 두개의 작업을 수행한 시간과 두개의 쓰레드로 두 개의 작업을 수행한 시간을 비교해보면 멀티쓰레드로 작업 한 시간이 싱글쓰레드로 작업한 시간보다 더 걸리게 된다. 왜냐하면 쓰레드간의 작업 전환(context switching)에 시간이 걸리기 때문이다.
프로세스 또는 쓰레드 간의 작업 전환을 '컨텍스트 스위칭(context switching)'이라고 한다.

#### 자바가 OS(플랫폼) 독립적이라고 하지만 OS종속적인 부분은?
실행중인 프로세스가 OS의 프로세스 스케줄러의 영향을 받기 때문이다.

#### 멀티쓰레드의 장점
두 쓰레드가 서로 다른 자원을 사용하는 작업의 경우, 싱글쓰레드 프로세스보다 멀티 쓰레드 프로세스가 더 효율적이다.
만일 사용자로 부터 입력받는 작업과 화면에 출력하는 작업을 하나의 쓰레드로 처리한다면 사용자가 입력을 마칠 때까지 아무 일도 하지 못하고 기다려야 한다. 그러나 두 개의 쓰레드로 처리한다면 사용자의 입력을 기다리는 동안 다른 쓰레드가 작업을 처리할 수 있기 때문에 효율적인 CPU의 사용이 가능하다.

## 5. 쓰레드의 우선순위
쓰레드가 수행하는 작업의 중요도에 따라 쓰레드의 우선순위를 서로 다르게 지정하여 특정 쓰레드가 더 많은 작업시간을 갖도록 할 수 있다.

#### 쓰레드의 우선순위와 관련된 메서드와 상수 (희망사항: 확률 ↑)
```java
void setPriority(int newPriority)
int getPriority()
```
쓰레드가 가질 수 있는 우선순위의 범위는 1~ 10이며 숫자가 높을수록 우선순위가 높다. 쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속받는다. main메서드를 수행하는 쓰레드는 우선순위가 5이다.

## 6. 쓰레드 그룹(thread group)
- (보안상의 이유로) 서로 관련된 쓰레드를 그룹으로 다루기 위한 것이다. 
- 모든 쓰레드는 반드시 하나의 쓰레드 그룹에 포함되어 있어야 하기 때문에, 쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 자동적으로 main쓰레드 그룹에 속하게 된다. 
- 자신을 생성한 쓰레드(부모 쓰레드)의 그룹과 우선순위를 상속받는다.

## 7. 데몬 쓰레드(daemon thread)
- 데몬 쓰레드는 일반 쓰레드(데몬 쓰레드가 아닌 쓰레드)의 작업을 돕는 보조적인 역할을 수행하는 쓰레드이다. 
- 일반 쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 자동 종료된다. 
- 데몬 쓰레드는 무한루프와 조건문을 이용해서 실행 후 대기하고 있다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.

#### 데몬 쓰레드의 예
가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등

#### 데몬 쓰레드 작성방법과 실행방법
```java
boolean isDaemon()
void setDaemon(boolean on)  // on을 true로 지정하면 데몬 스레드가 된다.
```
setDaemon메서드는 반드시 start( )를 호출하기 전에 실행되어야 한다. 그렇지 않으면 IllegalThreadStateException이 발생한다.

## 8. 쓰레드의 실행 제어
쓰레드의 실행을 제어(스케줄링)할 수 있는 메서드가 제공된다.

쓰레드의 상태


쓰레드의 상태 변화

1. 쓰레드를 생성하고 start( )를 호출하면 바로 실행되는 것이 아니라 실행대기열에 저장되어 자신의 차례가 될 때까지 기다려야 한다. 실행대기열은 큐(queue)와 같은 구조로 먼저 실행대기열에 들어온 쓰레드가 먼저 실행된다. 
2. 실행대기상태에 있다가 자신의 차례가 되면 실행상태가 된다. 
3. 주어진 실행시간이 다되거나 yield( )를 만나연 다시 실행대기상태가 되고 다음 차례의 쓰레드가 실행상태가 된다. 
4. 실행 중에 suspend( ), sleep( ), wait( ), join( ), I/O block에 의해 일시정지 상태가 될 수 있다. I/O block은 입출력작업에서 발생하는 지연상태를 말한다. 사용자의 입력을 기다리는 경우를 예로 들 수 있는데 이런 경우 일시정지 상태에 있다가 사용자가 입력을 마치면 다시 실행대기 상태가 된다. 
5. 지정된 일시정지시간이 다 되거나(time-out), notify( ), resume( ), interrupt( )가 호출되면 일시 정지상태를 벗어나 다시 실행대기열에 저장되어 자신의 차례를 기다린다. 
6. 실행을 모두 마치거나 stop( )이 호출되면 쓰레드는 소멸.

### 쓰레드의 실행제어 메서드
#### sleep( )
sleep( )은 현재 쓰레드를 지정된 시간동안 쓰레드를 멈추게 한다.
sleep( )에 의해 일시정지 상태가 된 쓰레드는 지정된 시간이 다 되거나 interrupt( )가 호출되면(InterruptedException 발생), 잠에서 깨어나 실행대기 상태가 된다.
그래서 sleep( )을 호출할 때는 항상 try - catch문으로 예외를 처리해야 한다.
특정 쓰레드를 지정해서 멈추게 하는 것은 불가능하다.

sleep( )의 호출 방법
sleep()이 항상 현재 실행 중인 쓰레드에 대해 작동하기 때문에 th1.sleep(2000)과 같이 호출하였어도 실제로 영향을 받는 것은 main메서드를 실행하는 main쓰레드이다. 그래서 sleep( )은 static으로 선언되어 였으며 참조변수를 이용해서 호출하기 보다는 Thread.sleep(2000);과 같이 해야 한다.

interrupt( )와 interrupted( ) - 쓰레드의 작업을 취소한다.
쓰레드가 sleep( ), wait( ), join ( )에 의해 일시정지 상태(WAITING)에 있을 때, 해당 쓰레드에 대해 interrupt( )를 호출하면, sleep( ), wait( ), join( )에서 Interruptedexception이 발생하고 쓰레드는 '실행대기 상태(RUNNABLE)'로 바뀐다. 즉, 멈춰있던 쓰레드를 깨워서 실행가능한 상태로 만드는 것이다.

suspend( ), resume( ), stop( )
suspend( )는 sleep( ) 처럼 쓰레드를 멈추게 한다. suspend( )에 의해 정지된 쓰레드는 resume( )을 호출해야 다시 실행대기 상태가 된다. stop( )은 호출되는 즉시 쓰레드가 종료된다.
suspend( ), resume( ). stop( )은 교착상태(deadlock)를 일으키기 쉽게 작성되어서 이 메서드들은 모두 'deprecated'되었으므로 직접 구현해야 한다.

yield( )
yield( )는 쓰레드 자신에게 주어진 실행시간을 다음 차례의 쓰레드에게 양보하고, 자신(현재 쓰레드)은 실행대기한다.
yield( )와 interrupt( )를 적절히 사용하면, 프로그램의 응답성을 높이고 보다 효율적인 실행이 가능하게 할 수 있다.

yield( )가 효율적인 상황
메서드가 바쁜 대기상태(busy - waiting)에 빠져서 잠시 실행을 멈추고 쓰레드는 주어진 실행시간을 while문을 의미없이 돌면서 낭비하게 될 것이다.
그래서  yield( )를 호출해서 남은 실행시간을 while문에서 낭비하지 않고 다른 쓰레드에게 양보(yield)하게 되므로 더 효율적이다.

join( )
지정된 시간동안 특정 쓰레드가 작업하는 것을 기다린다.

join( )과 sleep( )의 공통점과 차이점
join()도 sleep()처럼 interrupt( )에 의해 대기상태에서 벗어날 수 있고, join()이 호출되는 부분을 try-catch문으로 감싸야 한다. 그러나 join()은 현재 쓰레드가 아닌 특정 쓰레드에 대해 동작하므로 static메서드가 아니다.

9. 쓰레드의 동기화
   멀티쓰레드 프로세스의 경우 여러 쓰 레드가 같은 프로세스 내의 자원을 공유해서 작업하기 때문에 서로의 작업에 영향을 주게 된다.
   임계 영역은 lock을 획득한 단 하나의 쓰레드만 이 영역 내의 코드를 수행할 수 있게 한다(객체 1개에 lock 1개).

한 쓰레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것을 ‘쓰레드의 동기화(synchronization)’라고 한다.

9.1 synchronized를 이용한 동기화
한 번에 하나의 쓰레드만 객체에 접근할 수 있도록 객체에 락(lock)을 걸어서 데이터의 일관성을 유지하는 것.

임계 영역을 설정하는 방법
1.      메서드 전체를 임계 영역으로 지정(자제)
public synchronized void calcSum( ) {
// …
}
2.      특정한 영역을 임계 영역으로 지정 
synchronized(객체의 참조변수) {
// …
}
읽고 쓰는 객체에 모두 동기화 필요

9.2 wait( )과 notify( )
동기화의 효율을 높이기 위해 wait( )과 notify( )를 사용한다.

wait( ), notify( ), notifyAll( )
특정 객체에 대한 것이므로 Object에 정의되어 있다.
동기화 블록(synchronized 블록)내에서만 사용할 수 있다.
보다 효율적인 동기화를 가능하게 한다.

wait( )
실행중이던 쓰레드는 해당 객체의 waiting pool(대기실)에서 통지를 기다린다.
notify( )
해당 객체의 waiting pool에 있던 모든 쓰레드 중 임의의 쓰레드만 통지 받는다
notifyAll( )
기다리고 있는 모든 쓰레드에게 통보를 하지만, 그래도 lock을 얻을 수 있는 것은 하나의 쓰레드일 뿐이고 나머지 스레드는 통보를 받긴 했지만, lock을 얻지 못하면 다시 lock을 기다리는 신세가 된다.

기아 현상과 경쟁상태
계속 통지를 받지 못하고 오랫동안 기다리는 것을 ‘기아(starvation) 현상’ 이라고 한다. 이 현상을 막으려면, notify( )대신 notifyAll( )을 사용해야 한다.
notifyAll( )로 쓰레드의 기아현상은 막았지만, 여러 쓰레드가 lock을 얻기 위해 서로 경쟁하는 ‘경쟁 상태(race condition)’를 개선하기 위해 Lock과 Condition을 이용해야 한다.



9.3 Lock과 Condition을 이용한 동기화
synchronized블록으로 동기화를 하면 같은 메서드 내에서만 lock을 걸 수 있다는 제약이 불편하다. 그럴 때 lock클래스를 사용한다.

lock클래스의 종류
ReentrantLock
재진입이 가능한 lock. 가장 일반적인 배타적인 lock.

ReentrantReadWriteLock
읽기에는 공유적이고, 쓰기에는 배타적인 lock

StampedLock
ReentrantReadWriteLock에 낙관적인 lock의 기능을 추가.
읽기 lock이 걸려있으면, 쓰기 lock을 얻기 위해서는 읽기 lock이 풀릴 때까지 기다려야 하지만, ‘낙관적 읽기 lock’은 쓰기 lock에 의해 바로 풀린다. 무조건 읽기 lock을 걸지 않고. 쓰기와 읽기가 충돌할 때만 쓰기가 끝난 후에 읽기 lock을 거는 것이다.

ReentrantLock의 생성자
ReentrantLock()
ReentrantLock(boolean fair)

void lock( )
void unlock( )
boolean isLocked( )

임계 영역 내에서 예외가 발생하거나 return문으로 빠져 나가게 되면 lock이 풀리지 않을 수 있으므로 unlock( )은 try - finally문으로 감싸야 한다.
class X {
private final ReentrantLock lock = new ReentrantLock();
// ...

public void m() {
lock.lock();  // block until condition holds
try {
// ... method body
} finally {
lock.unlock()
}
}
}

ReentrantLock과 Condition
Condition은 이미 생성된 lock으로부터 newCondition()을 호출해서 생성한다. 그 다음 wait( )과 notify( )대신 Condition의 await( )과 signal( )을 사용하면 된다.

생성 방법
final Lock lock = new ReentrantLock();
final Condition notFull  = lock.newCondition();
final Condition notEmpty = lock.newCondition();




9.4 volatile
성능 향상을 위해 코어는 메모리에서 읽어온 값을 캐시에 저장하고 캐시에서 값을 읽어서 작업한다. 다시 같은 값을 읽어올 때는 먼저 캐시에 있는지 확인하고 없을 때만 메모리에서 읽어온다. 그러다보니 도중에 메모리에 저장된 변수의 값이 변경되었는데도 캐시에 저장된 값이 갱신되지 않아서 메모리에 저장된 값이 다른 경우가 발생한다. 그러나 변수 앞에 volatile을 붙이면, 코어가 변수의 값을 읽어올 때 캐시가 아닌 메모리에서 읽어오기 때문에 캐시와 메모리간의 값의 불일치가 해결된다.

volatile로 long과 double을 원자화
JVM은 데이터를 4byte(=32bit)단위로 처리하기 때문에. int와 int보다 작은 타입들은 단 하나의 명령어로 읽거나 쓰기가 가능하다. 즉, 작업의 중간에 다른 쓰레드가 끼어들 틈이 없다. 그러나, 크기가 8 byte인 long과 double타입의 변수는 하나의 명령어로 값을 읽거나 쓸 수 없기 때문에, 변수의 값을 읽는 과정에 다른 쓰레드가 끼어들 여지가 있다. 다른 쓰레 드가 끼어들지 못하게 하려고 변수를 선언할 때 volatile을 붙이는 것이다.
volatile long            sharedVal;
volatile double        sharedVal;

9.5 fork & join 프레임웍
‘fork & join 프레임웍’ 프레임웍은 하나의 작업을 작은단위로 나눠서 여러 쓰레드가 동시에 처리하는것을 쉽게 만들어 준다. 먼저 수행할 작업에 따라 RecursiveAction과 Recursivetask 두 클래스 중에서 하나를 상속받아 구현해야 한다.

RecursiveAction      반환값이 없는 작업을 구현할 때 사용
RucursiveTask          반환값이 있는 작업을 구현할 때 사용

두 클래스 모두 가지고 있는 추상 메서드인 compute( )를 상속을 통해 구현해야 한다. 그 다음에는 쓰레드풀과 수행할 작업을 생성하고. invoke( )로 작업을 시작한다.

ForkJoinPool pool = new ForkJoinPool( );           // 쓰레드 풀을 생성
SumTask task = new SumTask(from, to);            // 수행할 작업을 생성
Long result = pool.invoke(task);            // invoke( )를 호출해서 작업 시작

compute( )의 구현
compute( )를 구현할 때는 수행할 작업을 어떻게 나눌 것인지 정해야 한다. compute( )의 구조는 일반적인 재귀호출 메서드와 동일하다.

작업 훔쳐오기(work stealing)란?
fork( )가 호출되어 작업 큐에 추가된 작업도 compute( )에 의해 더 이상 나눌 수 없을 때까지 반복해서 나뉘고 자신의 작업 큐가 비어있는 쓰레드는 다른 쓰레드의 작업 큐에서 작업을 가져와서 수행한다.

fork( )와 join( )
작업과정
compute( )로 나누고 fork( )로 작업 큐에 넣는 작업이 계속해서 반복된다. 그리고 나눠진 작업은 각 쓰레드가 골고루 나눠서 처리하고. 작업의 결과는 join( )을 호출해서 얻을 수 있다.

차이점
fork( )는 해당 작업을 쓰레드 풀의 작업 큐에 넣는 비동기 메서드이다. 하지만 join( )은 해당 작업의 수행이 끝날 때까지 기다렸다고, 수행이 끝나면 그 결과를 반환하는 동기 메서드이다.

1. 람다식
   1.1 람다식(Lambda expression)이란?
   메서드를 하나의 ‘식(expression)’으로 표현한 것이다.
   메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로. 람다식을 ‘익명 함수(anonymous function)’라고도 한다.

함수와 메서드의 차이
근본적으로 함수와 메서드는 동일하다. 다만 함수는 일반적 용어이고, 메서드는 객체지향개념의 용어이다. 즉, 함수는 클래스에 독립적이고, 메서드는 클래스에 종속적이다.

1.2 람다식 작성하기
1. 메서드의 이름과 반환타입 제거, 매개변수 선언부와 몸통{ } 사이에 -> 추가
   int max(int a, int b) {return a > b ? a : b;}
   → int max(int a, int b) -> {return a > b ? a : b;}
2. 반환값이 있는 메서드의 경우. return문을 식이나 값으로 대신할 수 있다.
   문장이 아닌 식이므로 끝에 ‘;’을 붙이지 않는다.
   (int a, int b) -> {return a > b ? a : b;}
   → (int a, int b) -> a> b ? a : b
3. 람다식에 선언된 매개변수의 타입은 추론이 가능한 경우는 생략할 수 있다.
   대부분의 경우에 생략할 수 있다.
   (int a, int b) -> a> b ? a : b
   → (a, b) -> a > b ? a : b

매개변수가 하나뿐인 경우에는 괄호( )를 생략할 수 있다. 단 매개변수의 타입이 있으면 괄호( )를 생략할 수 없다.
(a)             -> a * a → a           -> a * a  // OK
(int a)      -> a * a → int a    -> a * a  // 에러

괄호{ } 안의 문장이 하나일때는 괄호{ }를 생략할 수 있다. 끝에 ‘;’을 안 붙인다.
(String name, int i) -> {System.out.println(name + “=” + i);}
→ (String name, int i) -> System.out.println(name + “=” + i)

그러나 괄호{ } 안의 문장이 return문일 경우 괄호{ }를 생략할 수 없다.
(int a, int b) -> {return a > b ? a : b;}                // OK
(int a, int b) -> return a > b ? a : b // 에러

1.3 함수형 인터페이스(Functional Interface)
1.4 java.util.function 패키지
1.5 Function의 합성과 Predicate의 결합
1.6 메서드 참조

2. 스트림(stream)
   2.1 스트림이란?
   2.2 스트림 만들기
   2.3 스트림의 중간연산
   2.4 Optional<T>와 OptionalInt
   2.5 스트림의 최종 연선
   2.6 collect()
   2.7 Collector 구현하기
   2.8 스트림의 변환
