# Chapter 15. 입출력 I/O
## 1. 자바에서의 입출력
### 1.1 입출력이란?
입출력(I/O)란 입력(Input)과 출력(Output)을 줄여 부르는 말이다. 
입출력은 컴퓨터 내부 또는 외부의 장치와 프로그램간의 데이터를 주고받는 것을 말한다.

### 1.2 스트림(stream)
- 스트림이란 데이터를 운반(입출력)하는 데 사용되는 연결통로이다.
- 연속적인 데이터의 흐름을 물에 비유해서 붙여진 이름이다.
- 스트림은 단방향 통신만 가능하기 때문에 하나의 스트림으로 입력과 출력을 동시에 처리할 수 없다.
- 그래서 입력과 출력을 동시에 수행하려면 입력을 위한 입력스트림(input stream)과 출력을 위한 출력스트림(output stream) 두 개의 스트림이 필요하다.

### 1.3 바이트기반 스트림 - InputStream, OutputStream
스트림은 바이트 단위로 데이터를 주고 받는다.</br>
InputStream의 read()메서드는 반드시 구현되어야 하는 메서드이고, read()없이는 read(byte[] b, int off, int len)와 read(byte[] b)는 의미가 없다는 것을 확인할 수 있다.

### 1.4 보조스트림
보조스트림은 실제 데이터를 주고 받는 스트림이 아니기 때문에 독립적으로 데이터를 입출력할 수 있는 기능은 없지만, 
스트림의 기능을 향상시키거나 새로운 기능을 추가하기 위해 사용된다.

### 1.5  문자기반 스트림 - Reader, Writer
지금까지 알아본 스트림은 모두 입출력의 단위가 1byte인 바이트 기반의 스트림이었다.
문자를 처리하는 데 어려움이 있다는 점에서 입출력 단위가 문자(char, 2byte)인 문자기반의 스트림이 제공된다.
InputStream → Reader
OutputStream → Writer

## 2. 바이트기반 스트림
### 2.1 InputStream과 OutputStream
InputStream과 OutputStream은 모든 바이트기반의 스트림의 조상이다.
- 스트림을 사용해서 모든 작업을 마치고 난 후에는 close()를 호출해서 반드시 닫아 주어야 한다.
- 그러나 메모리를 사용하는 스트림(ByteArrayInputStream)과 표준 입출력 스트림(System.in, System.out)은 닫아 주지 않아도 된다.

### 2.2 ByteArrayInputStream과 ByteArrayOutputStream
ByteArrayInputStream과 ByteArrayOutputStream은 바이트배열에 데이터를 입출력하는데 사용되는 스트림이다. 
바이트 배열은 사용하는 자원이 메모리 밖에 없으므로 가비지컬렉터에 의해 자동적으로 자원을 반환하므로 close()를 이용해서 스트림을 닫지 않아도 된다.</br>
보다 나은 성능을 위해 바이트 배열에 담긴 내용을 지우고 쓰는 것이 아니라 기존의 내용 위에 덮어 쓴다. 원하는 결과를 얻기 위해서는 읽어 온 byte의 수를 저장하는 변수를 새로 선언해서 읽어 온 만큼만 출력하도록 변경해야 한다.

### 2.3 FileInputStream과 FileOutputStream
파일에 데이터를 입출력하는 바이트기반 스트림

## 3. 바이트 기반의 보조스트림
### 3.1 FilterInputStream과 FilterOutputStream
FilterInputStream과 FilterOutputStream은 InputStream과 OutputStream의 자손이면서 모든 보조스트림의 조상이다. 
보조스트림은 자체적으로 입출력을 수행할 수 없기 때문에 기반스트림을 필요로 한다.
FilterInputStream과 FilterOutputStream은 상속을 통해 원하는 작업을 수행하도록 읽고 쓰는 메서드를 오버라이딩 해야 한다.

#### FilterInputStream의 이상한 점? 
상속과 포함을 동시에 하는 Decorator Pattern을 이용해 클래스를 작성하였다. 
원래는 포함 관계로도 충분한데 다형성을 위해 부모를 대신할 수 있어야 한다.
InputStream is = new FilterStream();

### 3.2 BufferedInputStream과 BufferedOutputStream
BufferedInputStream과 BufferedOutputStream은 스틀미의 입출력 효율을 높이기 위해 버퍼를 사용하는 보조 스트림이다.

#### 특징
버퍼가 가득차면 그 때 버퍼의 모든 내용을 출력 소스에 출력한다. 버퍼가 가득 찼을 때문 출력소스에 출력을 하기 때문에 마지막 출력부분이 출력 소스에 쓰이지 못하고 BufferedOutputStream의 버퍼에 남아있는 채로 프로그램이 종료될 수 있다.
그래서 프로그램에서 모든 출력작업을 마친 후 BufferedOutputStream에 close()나 flush()를 호출해서 마지막에 비어있는 모든 내용이 출력 소스에 출력되도록 해야 한다.

보조스트림을 사용한 경우에는 기반 스트림의 close()나 flush()를 호출할 필요 없이 단순히 보조스트림의 close()를 호출하기만 하면 된다.
#### 단점
성능은 좋지만 첫 번째로 들어온 데이터는 오래 기다려야 한다.

### 3.3 DataInputStream과 DataOutputStream
DataInputStream과 DataOutputStream은 데이터를 읽고 쓰는 데 있어서 byte단위가 아닌, 8가지 기본 자료형의 단위로 읽고 쓸 수 있다는 장점이 있다.</br>
여러 가지 종류의 자료형으로 출력한 경우, 읽을 때는 반드시 쓰인 순서대로 읽어야 한다.

### 3.4 SequenceInputStream
여러 개의 입력 스트림을 연속적으로 연결해서 하나의 스트림으로부터 데이터를 읽는 것과 같이 처리할 수 있도록 도와준다.

### 3.5 PrintStream
데이터를 다양한 형식의 문자로 출력하는 기능을 제공하는 보조스트림이다.

## 4. 문자기반 스트림
### 4.1 Reader와 Writer
Reader는 문자기반 입력 스트림의 최고 조상이며,
Writer는 문자기반 출력 스트림의 최고 조상이다.

문자기반 스트림, 즉 Reader와 Writer 그리고 그 자손들은 여러 종류의 인코딩과 자바에서 사용하는 유니코드(UTF-16)간의 변환을 자동적으로 처리해준다. 
Reader는 특정 인코딩을 읽어서 유니코드로 변환하고 Writer는 유니코드를 특정 인코딩으로 변환하여 저장한다.

### 4.2 FileReader와 FileWriter
FileReader와 FileWriter는 파일로부터 텍스트데이터를 읽고, 파일에 쓰는데 사용된다.

### 4.3 PipedReader와 PipedWriter
PipedReader와 PipedWriter는 쓰레드 간에 데이터를 주고받을 때 사용된다. 
입력과 출력스트림을 하나의 스트림으로 연결(connect)해서 데이터를 주고받는다. 스트림을 생성한 다음에 어느 한쪽 쓰레드에서 connect( )를 호출해서 입력스트림과 출력스트림을 연결한다. 입출력을 마친 후에는 어느 한쪽 스트림만 닫아도 나머지 스트림은 자동으로 닫힌다.

### 4.4 StringReader와 StringWriter
StringReader/StringWriter는 CharArrayReader/CharArrayWriter와 같이 입출력 대상이 메모리인 스트림이다. 
StringWriter에 출력되는 데이터는 내부의 StringBuffer에 저장된다.

## 5. 문자기반의 보조스트림
### 5.1 BufferedReader와 BufferedWriter
BufferedReader와 BufferedWriter는 버퍼를 이용해서 입출력의 효율을 높일 수 있도록 해주는 역할을 한다. 
라인 단위의 입출력이 편리하다.


### 5.2 InputStreamReader와 OutputStreamWriter
InputStreamReader와 OutputStreamWriter는 바이트 기반 스트림을 문자기반 스트림으로 연결시켜 문자기반 스트림처럼 쓸 수 있게 해준다. 
그리고 바이트기반 스트림의 데이터를 지정된 인코딩의 문자데이터로 변환하는 작업을 수행한다.

## 6. 표준입출력과 File
### 6.1 표준입출력 - System.in, System.out, System.err
표준입출력은 콘솔(console, 도스창)을 통한 데이터 입력과 콘솔로의 데이터 출력을 의미한다. 
자바에서는 표준 입출력(standard I/O)을 위해 3가지 입출력 스트림 System.in, System.out, System.err을 제공하는데, 
이 들은 자바 어플리케이션의 실행과 동시에 사용할 수 있게 자동적으로 생성된다.

System.in    콘솔로부터 데이터를 입력받는 데 사용
System.out 콘솔로 데이터를 출력하는 데 사용
System.err   콘솔로 데이터를 출력하는 데 사용

##### Enter키를 누르면 다음 줄의 첫 번째 칼럼으로 커서가 이동하는 이유는?
Enter키를 누르면 두 개의 특수문자 ‘\r’과 ‘\n’이 입력된 것으로 간주된다. ‘\r’은 캐리지리턴(carriage return), 
즉 커서를 현재 라인의 첫 번째 컬럼으로 이동시키고 ‘\n’은 커서를 다음 줄로 이동시키는 줄바꿈(new line)을 한다.

### 6.2 표준입출력의 대상변경 - setOut(), setErr(), setIn()
초기에는 System.in, System.out, System.err의 입출력대상이 콘솔화면이지만, setln() , setOut() , setErr()를 사용하면 입출력을 콘솔 이외에 다른 입출력 대상으로 변경하는 것이 가능하다.

### 6.3 RandomAccessFile
RandomAccessFile은 하나의 클래스로 파일에 대한 입력과 출력을 모두 할 수 있는 스트림이다. 다른 스트림과 달리 Object의 자손이다.
RandomAccessFile클래스의 가장 큰 장점은 파일의 어느 위치에나 읽기/ 쓰기가 가능하다는 것이다. 이것을 가능하게 하기 위해서 내부적으로 파일 포인터를 사용한다.
현재 작업 중인 파일에서 파일 포인터의 위치를 알고 싶으면 getFilePointer()를 사용 하면 되고, 파일 포인터의 위치를 옮기기 위해서는 seek (long pos)나 skipBytes(int n)를 사용하면 된다.

### 6.4 File
File클래스는 파일과 디렉토리를 다루는데 사용되는 클래스이다.

File인스턴스를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다. 
새로운 파일을 생성하기 위해서는 File인스턴스를 생성한 다음, 출력스트림을 생성하거나 createNewFile()을 호출해야 한다.
```java
File f = new File("/Users/…/eclipse-workspace/ch15/예제/FileEx1.java");
f.createNewFile();	// 새로운 파일이 생성된다.
```

## 7. 직렬화
### 7.1 직렬화란?
- 직렬화(serialization)란 객체에 저장된 데이터를 스트림에 쓰기(write)위해 연속적인(serial) 데이터로 변환하는 것을 말한다. 반대로 스트림으로부터 데이터를 읽어서 객체를 만드는 것을 역직렬화(deserialization) 라고 한다. 
- 객체는 오직 인스턴스변수들로만 구성되어 있다. 
- 객체를 저장하기 위해서는 객체를 직렬화 해야 한다. 
- 객체를 저장한다는 것은 객체의 모든 인스턴스변수의 값을 저장한다는 것이다.

### 7.2 ObjectInputStream과 ObjectOutputStream
ObjectInputStream과 ObjectOutputStream은 각각 InputStream과 OutputStream을 직접 상속받지만 기반스트림을 필요로 하는 보조스트림이다.
직렬화(스트림에 객체를 출력)에는 ObjectOutputStream을 사용하고 역직렬화(스트림으로부터 객체를 입력)에는 ObjectinputStream을 사용한다.

객체를 직렬화하여 입력할 수 있게 해주는 보조스트림
ObjectInputStream(InputStream in)
ObjectOutputStream(OutputStream out)

객체를 파일에 저장하는 방법
FileOutputStream fos = new FileOutputStream(“objectfile.ser”);
ObjectOutputStream out = new ObjectOutputStream(fos);
out.writeObject(new Userinfo());

파일에 저장된 객체를 다시 읽어오는 방법
FileInputStream fis = new FileInputStream(“objectfile.ser”);
ObjectInputStream in = new ObjectInputStream(fis);
UserInfo info = (UserInfo)in.readObject();

7.3 직렬화가 가능한 클래스 만들기 - Serializable, transient
직렬화가 가능한 클래스를 만드는 방법은 직렬화하고자 하는 클래스가 java.io.Serializable 인터페이스를 구현하도록 하면 된다.

Serializable을 구현한 클래스를 상속받는다면 Serializable을 구현하지 않아도 인스턴스 변수와 함께 직렬화가 가능하다. 그러나 조상클래스가 Serializable을 구현하지 않았다면 자손클래스를 직렬화할 때 조상클래스에 정의된 인스턴스변수 name과 password는 직렬화 대상에서 제외된다.

직렬화하고자 하는 객체의 클래스에 직렬화가 안 되는 객체에 대한 참조를 포함하고 있다면, 제어자 transient를 붙여서 직렬화 대상에서 제외되도록 할 수 있다. 또는 password와 같이 보안상 직렬화되면 안 되는 값에 대해서 transient를 사용하면 transient가 붙은 인스턴스변수의 값은 그 타입의 기본값(null)으로 직렬화된다고볼 수 있다.

객체를 역직렬화 할 때는 직렬화할 때의 순서와 일치해야 한다.

7.4 직렬화가 가능한 클래스의 버전 관리
직렬화된 객체를 역직렬화할 때는 직렬화 했을 때와 같은 클래스를 사용해야 함.

객체가 직렬화될 때 클래스에 정의된 멤버들의 정보를 이용해서 serialVersionUID라는 클래스의 버전을 자동생성해서 직렬화 내용에 포함한다.
그래서 역직렬화 할 때 클래스의 버전을 비교함으로써 직렬화할 때의 클래스의 버전과 일치하는지 확인할 수 있는 것이다. 그러나 static변수나 상수 또는 transient가 붙은 인스턴스변수가 추가되는 경우에는 직렬화에 영향을 미치지 않기 때문에 클래스의 버전을 다르게 인식하도록 할 필요는 없다.

클래스의 버전을 수동으로 관리하려면 serialVersionUID를 추가로 정의해야 함

serialVersionUID의 값은 정수값이면 어떠한 값으로도 지정할 수 있지만 서로 다른 클래스 간에 같은 값을 갖지 않도록 serialver.exe를 사용해서 생성된 값을 사용하는 것이 보통이다.  serialver.exe 는 클래스에 serialVersionUID가 정의되어 있으면 그 값을 출력하고 정의되어 있지 않으면 자동 생성한 값을 출력한다.


