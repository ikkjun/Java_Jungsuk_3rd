1. 날짜와 시간
1.1 Calendar와 Date
Date는 날짜와 시간을 다룰 목적으로 JDK1.0부터 제공되어온 클래스이다. 
Date클래스는 기능이 부족했기 때문에, Calendar 클래스를 JDK1.1 부터 제공하기 시작했다. Calendar는 Date보다는 훨씬 나았지만 몇 가지 단점들이 발견 되었다. (날짜와 시간을 항상 같이 다루는 것)
JDK1.8부터 'java.time패키지’로 기존의 단점들을 개선한 새로운 클래스들이 추가되었다.

Calendar와 GregorianCalendar
Calendar는 추상클래스이기 때문에 직접 객체를 생성할 수 없고, getInstance() 메서드를 통해서 완전히 구현된 클래스의 인스턴스를 얻어야 한다.

Calendar cal = new Calendar( ); 
// 에러. 추상클래스는 인스턴스를 생성할 수 없다. 
Calendar cal = Calendar.getInstance( );

메서드를 통해 인스턴스 반환받는 이유
최소한의 변경으로 프로그램이 동작할 수 있도록 하기 위한 것이다. 특정 인스턴스를 생성하도록 프로그램이 작성되어 있다면, 다른 종류의 인스턴스를 필요로 하는 경우에 클래스를 변경해야 하는데 비해 아래와 같이 메서드를 통해서 인스턴스를 얻어오도록 하면 클래스를 변경하지 않아도 된다.

getInstance( )메서드가 static인 이유?
메서드 내의 코드에서 인스턴스 변수를 사용하거나 인스턴스 메서드를 호출하지 않기 때문이다. 그리고 getInstance( )가 static이 아니라면 객체를 생성한 다음에 호출해야 하는데 Calendar는 추상클래스이기 때문에 객체를 생성할 수 없기 때문이다.

Date와 Calendar간의 변환
Calendar를 Date로 변환Calendar cal = Calendar.getInstance( );Date d = new Date(cal.getTimeInMillis( ));
Date를 Calendar로 변환Date d = new Date( );Calendar cal = Calendar.getInstance( );cal.setTime(d);

Calendar의 주요 메서드
get( )
int get(int field)를 통해서 원하는 필드(날짜 또는 시간)의 값을 가져올 수 있다. 

한 가지 주의해야할 것은 get(Calendar.MONTH)로 얻어오는 값의 범위가 1~ 12가 아닌 0~ 11이라는 것이다. 그래서 get(Calendar.MONTH)로 얻어오는 값이 0이면 1월을 의미 하고, 11이면 12월을 의미한다. 왜냐하면 MONTH는 배열에 저장되어 있기 때문이다.

set( )
날짜와 시간을 원하는 값으로 변경하려면 set메서드를 사용하면 된다.

Clear( )
clear( )와 clear(int field)로 Calendar의 객체를 초기화 할 수 있다. clear( )는 Calendar 객체의 모든 필드를 초기화 하고 clear(int field)는 Calendar 객체의 특정 필드를 초기화한다. MilliSeconds로 계산하는 값이 필요한 것이 아니라면 객체 생성후 date1.clear( )해야 정확한 값이 나온다.

add( )와 roll( )
‘add(int field, int amount)’를 사용하면 지정한 필드의 값을 원하는 만큼 증가 또는 감소시킬 수 있다.
‘roll(int field, int amount)'도 지정한 필드의 값을 증가 또는 감소시킬 수 있다.

add메서드와 roll메서드의 차이점
add 메서드는 다른 필드에 영향을 미치지만, roll 메서드는 다른 필드에 영향을 미치지 않는다는 것이다

2. 형식화 클래스
2.1 DecimalFormat
형식화 클래스 중에서 숫자를 형식화 하는데 사용되는 것이 DecimalFormat이다. 

lnteger.parselnt메서드는 콤마(,)가 포함된 문자열을 숫자로 변환하지 못한다. parse(String source)는 DecimalFormat의 조상인 NumberFormat에 정의된 메서드다. Number클래스는 Integer, Double 같은 숫자를 저장하는 래퍼 클래스의 조상.

2.2 SimpleDateFormat
날짜 형식화
날짜와 시간을 다양한 형식으로 출력할 수 있게 해준다.

SimpleDateFormat을 사용하는 방법
먼저 원하는 출력형식의 패턴을 작성 하여 SimpleDateFormat인스턴스를 생성한 다음 출력하고자 하는 Date인스턴스를 가지 고 format(Date d)를 호출하면 지정한 출력형식에 맞게 변환된 문자열을 얻게 된다.

2.3 ChoiceFormat
ChoiceFormat은 특정 범위에 속하는 값을 문자열로 변환한다.

두 개의 배열이 사용되었는데 하나(limits)는 범위의 경계값을 저장하는데 사용하였고, 또 하나(grade)는 범위에 포함된 값을 치환할 문자열을 저장하는데 시용되었다. 경계값은 double형으로 반드시 모두 오름차순으로 정렬되어 있어야 하며, 치환될 문자 열의 개수는 경계값에 의해 정의된 범위의 개수와 일치해야한다. 그렇지 않으면 IllegalArgumentException이 발생한다.

두 개의 배열은 패턴으로 변경할 수 있다. 패턴은 구분자로 ‘#’와 ‘〈 '두 가지를 제공하는데 ‘limit#value'의 형태로 사용한다. ‘#’는 경계값을 범위에 포함시키지만, ‘〈 ‘는 포함시키지 않는다.

double[] limits = {60, 70, 80, 90};
String[] grades = {"D", "C", "B", “A"};

String pattern = "60#D|70#C|80<B|90#A";
2.4 MessageFormat
MessageFormat은 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다. 그리고 SimpleDateFormat의 parse처럼 MessageFormat의 parse를 이용하면 특정 형식을 가진 문자열에서 필요한 데이터만을 손쉽게 추출해 낼 수 있다. 

MessageFormat에 사용할 양식인 문자열 msg를 작성할 때 
‘{숫자}’로 표시된 부분이 데이터가 출력될 자리이다.

3. java.time 패키지
Date와 Calendar가 가지고 있던 단점들을 해소하기 위해 JDK1.8부터 ‘java.time’패키지가 추가되었다. 이 패키지는 다음과 같이 4개의 하위 패키지를 가지고 있다.


패키지들에 속한 클래스들의 가장 큰 특징은 String클래스처럼 ‘불변(immutable)’이라는 것이다. 그래서 날짜나 시간을 변경하는 메서드들은 기존의 객 체를 변경하는 대신 항상 변경된 새로운 객체를 반환한다. 기존 Calendar 클래스는 변경 가능하므로, 멀티 쓰레드 환경에서 안전하지 못하다. 멀티 쓰레드 환경에서는 동시에 여러 쓰레드가 같은 객체에 접근할 수 있기 때문에, 변 경 가능한 객체는 데이터가 잘못될 가능성이 있으며. 이를 쓰레드에 안전(thread-safe)하지 않다고 한다.

3.1 java.time 패키지의 핵심 클래스
날짜와 시간을 하나로 표현하는 Calendar 클레스와 달리java.time 패키지에서는 날짜와 시간을 별도의 클래스로 분리했다. 시간을 표현할 때는 LocalTime클래스를 사용하고, 날짜를 표현할 때는 LocalDate 클래스를 사용한다. 그리고 날짜와 시간이 모두 필요할 때는 LocalDateTime클래스를 사용하면 된다. 여기에 시간대(time-zone)까지 다뤄야 한다면 ZonedDateTime클래스를 사용하면 된다.

Period와 Duration
Period는 두 날짜간의 차이를 표현하기 위한 것이고, Duration은 시간의 차이를 표현하기 위한 것이다.
날짜 - 날짜 = Period
시간 - 시간 = Duration




객체 생성하기 - now( ), of( )
java.time패키지에 속한 클래스의 객체를 생성하는 가장 기본적인 방법은 now( )와 of( )를 사용하는 것이다. 둘 다 static 메서드이다.

now( )는 현재 날짜와 시간을 저장하는 객체를 생성한다.
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();

of( )는 해당 필드의 값을 순서대로 지정해 주기만 하면 된다.
LocalDate date = LocalDate.of(2023, 10, 24);
LocalTime time = LocalTime.of(19, 56, 30);

Temporal과 TemporalAmount
LocalDate, LocalTime. LocalDateTime, ZonedDateTime등 날짜와 시간을 표현하기 위한 클래스들은 모두 Temporal, TemporalAccessor, TemporalAdjuster인터페이스를 구현했고, Duration과 Period는 TemporalAmount인터페이스를 구현하였다. Temporal로 시작하는 인터페이스들은 매개변수 타입으로 많이 사용되며, TemporalAmount인지 아닌지만 확인하면 된다.

TemporalUnit과 TemporalField
날짜와 시간의 단위를 정의해 놓은 것이 TemporalUnit인터페이스이고, 이 인터페이스를 구현한 것이 열거형 ChronoUnit이다. 그리고 TemporalField는 년, 월, 일등 날짜와 시간의 필드를 정의해 놓은 것으로. 열거형 ChronoField가 이 인터페이스를 구현하였다.

3.2 LocalDate와 LocalTime
LocalDate와 LocalTime은 java.time패키지의 가장 기본이 되는 클래스이다. 객체를 생성하는 방법은 현재의 날짜와 시간을 반환하는 now( )와 특정한 날짜와 시간을 지정할 때 사용하는 of( ) 가 있다. 일 단위나 초 단위로도 지정할 수 있다(1일은 24*60*60=86400초). 또는 parse( )를 이용하면 문자열을 날짜와 시간으로 변환할 수도 있다.

특정 필드의 값 가져오기 - get( ), getXXX( )
주의할 점은 Calendar와 달리 월(month) 의 범위가 1~ 12이고, 요일은 월요일이 1, 화요일이 2, ... 일요일은 7이라는 것이다. Calendar는 1월을 0으로 표현하고, 일요일은 1, 월요일은 2, … , 토요일은 7로 표현한다.

대부분의 필드는 int타입의 범위에 속하지만. 몇몇 필드는 int타입의 범위를 넘을 수 있다 그럴 때 get( )대신 getLong( )을 사용해야 한다. 











필드의 값 변경하기 - with( ), plus( ), minus( )
날짜와 시간에서 특정 필드 값을 변경하려면, with로 시작하는 메서드를 사용하면 된다. 필드를 변경하는 메서드들은 항상 새로운 객체를 생성해서 반환하므로 대입 연산자를 같이 사용해야 한다.
date = date.withYear(2000);	// 년도를 2000년으로 변경

특정 필드에 값을 더하거나 빼는 plus( )와 minus( )가 있다.

LocalTime의 truncatedTo( )는 지정된 것보다 작은 단위의 필드를 0으로 만든다. LocalTime과 달리 LocalDate에는truncatedTo( )가 없는데, 그 이유는 LocalDate의 필드인 년, 월, 일은 0이 될 수 없기 때문이다.

날짜와 시간 비교-isAfter(), isBefore(), isEqual()
LocalDate와 LocalTime도 compareTo( )가 오버라이딩되어 있어서, compareTo( )로 비교할 수 있다. 그런데도 보다 편리하게 비교할 수 있는 isAfter( ), isBefore( ), isEqual( )와 같은 메서드들이 추가로 제공된다.

equals( )가 있는데도, isEqual( )을 제공하는 이유는 연표(chronology)가 다른 두 날짜를 비교하기 위해서이다. 모든 필드가 일치해야 하는 equals()와 달리 isEqual()은 오직 날짜만 비교한다. 그래서 대부분의 경우 equals()와 isEqual()의 결과는 같다. 따라서 대부분의 경우 isEqual() 대신 equals()를 사용해도 된다.

3.3 Instant
Instant는 에포크 타임(EP()CH TIME, 1970 - 01 - 01 00:00:00 UTC)부터 경과된 시간을 나노초 단위로 표현한다. 단일 진법으로만 다루기 때문에 계산하기 쉽다. 사람이 사용하는 날짜와 시간은 여러 진법이 섞여있어서 계산하기 어렵다.
Instant를 생성할 때는 now()와 ofEpochSecond()를 사용한다. 
Long epochSec = now.getEpochSecond();

오라클 데이터베이스의 타임스탬프(timestamp)처럼 밀리초 단위의 EPOCH TIME을 필요로 하는 경우를 위해 toEpochMilli( )가 정의되어 있다. UTC는 'Coordinated Universal Time'의 약어로 ‘세계 협정시’이라고 한다.

Instant와 Date간의 변환
Instant는 기존의 java.util.Date를 대체하기 위한 것이며, JDK.1 .8부터 Date에 instant로 변환할 수 있는 새로운 메서드가 추가되었다.
static Date from(Instant instant)	// Instant → Date
Instant       toInstant()			// Date → Instant


3.4 LocalDateTime과 ZonedDateTime
LocalDate와 LocalTime을 합쳐 놓은 것이 LocalDateTime이고, LocalDateTime에 시간대(tirne zone)를 추가한 것이 ZonedDateTime이다.

LocalDate와 LocalTime으로 LocalDateTime만들기
LocalDate와 LocalTime으로 합쳐서 하나의 LocalDateTime을 만들 수 있다. LocalDateTime에도 날짜와 시간을 직접 지정할 수 있는 다양한 버젼의 of() 와 now( )가 정의되어 있다.

LocalDate date = LocalDate.of(2015, 12, 31);
LocalTime time = LocalTime.of(12, 34, 56);
LocalDateTime dt = LocalDateTime.of(date, time);

LocalDateTime의 변환
LocalDateTime dt = LocalDateTime.of(2015,12,31,12,34,56); 
LocalDate date = dt.LocalDate();
LocalTime time = dt.LocalTime();

LocalDateTime으로 ZonedDateTime 만들기
LocalDateTime에 시간대(time-zone)를 추가하면, ZonedDateTime이 된다. LocalDateTime에 atZone( )으로 시간대 정보를 추가하면, ZonedDateTime을 얻을 수 있다. 사용 가능한 Zoneld의 목록은 Zoneld.getAvailableZorields()로 얻을 수 있다.

ZoneOffset
UTC로부터 얼마만큼 떨어져 있는지를 ZoneOffset으로 표현한다.  서울은 ‘+9’이다. 즉 UTC보다 9시간(32400초=60 x 60 x 9초)이 빠르다.

OffsetDateTime 
ZoneDateTime은 Zoneld로 구역을 표현하는데, Zoneld가 아닌 ZoneOffset을 사용하는 것이 OffsetDateTime이다. 서로 다른 시간대에 존재하는 컴퓨터간의 통신에는 OffsetDateTime이 필요하다.

ZoneDateTime의 변환 
GregorianCalendar와 ZonedDateTime간의 변환방법
// ZonedDateTime → GregorianCalendar
GregorianCalendar from(ZonedDateTime zdt)
// GregorianCalendar → ZonedDateTime
ZonedDateTime toZonedDateTime()

3.5 TemporalAdjusters
plus( ), minus( )로 계산하기에 복잡한 날짜계산을 도와주는 것이 TemporalAdjusters 클래스이다.

3.6 Period와 Duration
Period는 날짜의 차이를, Duration은 시간의 차이룰 계산하기 위한 것이다.

between( )
두 날짜 또는 시간의 차이를 구할 때는 between( )을 사용한다. Period, Duration에서 특정 필드의 값을 얻을 때는 get( )을 사용한다. 그런데 Period와 달리 Duration에는 getHours( ), getMinites( ) 같은 메서드가 없다. 시분초를 구할 때는 Duration을 LocalTime으로 변환한 다음에, LocalTime이 가지고 있는 get메서드들을 사용하는 것이 더 편리하다.

between( )과 until( ) 
until( )은 between( )과 거의 같은 일을 한다. between( )은 static메서드이고, until( )은 인스턴스 메서드라는 차이가 있다.

Period는 년월일을 분리해서 저장하기 때문에, D-day를 구하려는 경우에는 두 개의 매개변수를 받는 until( )을 사용하는 것이 낫다. 날짜가 아닌 시간에도 until( )을 사용할 수 있지만 Duration을 반환하는 until( )은 없다.

of( ), with( )
Period pd = Period.of(1, 12, 31);
pe = pe.withYears(2);

사칙연산, 비교연산, 기타 메서드
plus( ), minus( )외에 곱셈과 나눗셈을 위한 메서드도 있다.
pe = pe.minusYears(1).multipliedBy(2);
du = du.plusHours(1).divideBy(60);

Period에 나눗셈을 위한 메서드가 없는데. Period는 날짜의 기간을 표현하기 위한 것이므로 나눗셈을 위한 메서드가 별로 유용하지 않기 때문에 넣지 않은 것이다. 그리고 음수인지 확인하는 isNegative( )와 0인지 확인하는 isZero( )가 있다. 두 날짜 또는 시간을 비교할 때, 사용하면 어느 쪽이 앞인지 또는 같은지 알아낼 수 있다.

다른 단위로 변환 - toTotalMonths( ), toDays( ), toHours( ), toMinutes( ) 
이름이 ‘to’로 시작하는 메서드들이 있는데, 이 들은 Period와 Duration을 다른 단위의 값으로 변환하는데 사용된다.

3.7 파싱과 포맷 
형식화(formatting)와 관련된 클래스들은 java.time.format패키지에 들어있는데, 이 중에서 DateTimeFormatter가 핵심이다. DateTimeFormatter의 format( )을 이용해서 날짜와 시간을 형식화한다.

로케일에 종속된 형식화
DateTimeFormatter의 static 메서드 ofLocalizedDate( ) . ofLocalizedTime( ) . ofLocalized DateTime( ) 은 로케일(locale)에 종속적인 포맷터를 생성한다.

FormatStyle의 종류에 따른 출력 형태


출력형식 직접 정의하기 
DateTimeFormatter의 ofPattern( ) 으로 원하는 출력형식을 직접 작성할 수도 있다.

문자열을 날짜와 시간으로 파싱하기 
문자열을 날짜 또는 시간으로 변환하려면 static메서드 parse()를 사용하면 된다. 자주 사용되는 기본적인 형식의 문자열은 ISO_LOCAL_DATE와 같은 형식화 상수를 사용하지 않고도 파싱이 가능하다. ofPattern( )을 이용해서 파싱을 할 수도 있다.

