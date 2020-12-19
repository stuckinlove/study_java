# DataType - reference type
参照
* https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
* https://www.w3schools.com/java/java_data_types.asp

#### 目標
>データタイプに何があるか調べる。<br>
>データタイプの中で参照型のデータタイプを中心に勉強する。 <br>
>参照型のデータのメモリー使用領域について勉強する。

## 1. Javaのデータタイプの分類
データタイプは以下の２種類で分けられている。 <br>
* Primitive data types（基本データ型） - byte, short, int, long, float, double, boolean and char
* Non-primitive(reference、参照型) data types - String, Arrays, Interface and Classes

#### 1-1. Primitive data types（基本データ型）
| データタイプ  | Bit  |              範囲                |   デフォルト     |
| :-------: | :--: | :-----------------------------: | :-----------: |
|   byte    |  8   |           -128 ~ 127            |       0       |
|   short   |  16  |        -32,768 ~ 32,767         |       0       |
|    int    |  32  |        -2^31^~ 2^31^- 1         |       0       |
|   long    |  64  |       -2^63^ ~ 2^63^ - 1        |      0L       |
|   float   |  32  |  3.4 * 10^-38^ ~ 3.4 * 10^38^   |     0.0f      |
|  double   |  64  | 1.7 * 10^-308^ ~ 1.7 * 10^308^  |     0.0d      |
|   char    |  16  | '\u0000'(0) ~ '\uffff' (65,535) |   '\u0000'    |
|  boolean  |  1   |           true/false            |     false     |

#### 1-2. Non-primitive data types（参照型）
「Non-primitive data types」は参照型と呼ばれている。（オブジェクトをメモリの番地で参照いるため）

#### 1-3. primitive vs Non-primitive（参照型）
基本データ型と参照型の違いは以下である。 <br>

* Primitive types are predefined (already defined) in Java. Non-primitive types are created by the programmer and is not defined by Java (except for String).
* Non-primitive types can be used to call methods to perform certain operations, while primitive types cannot.
* A primitive type has always a value, while non-primitive types can be null.
* A primitive type starts with a lowercase letter, while non-primitive types starts with an uppercase letter.
* The size of a primitive type depends on the data type, while non-primitive types have all the same size. <br>
Examples of non-primitive types are Strings, Arrays, Classes, Interface, etc.

기본 타입으로 선언된 변수와 참조 타입으로 선언된 변수의 차이점은 저장되는 값이 무엇이냐이다. 기본 타입의 경우 실제 값을 변수에 저장하지만
참조타입의 경우 변수에 메모리의 번지값을 갖는다. 번지를 통해 객체를 참조한다는 뜻에서 참조타입이라고 부른다.

## 2. 메모리 사용 영역 (jvm architecture - Runtime Data Area)
TODO img

jvm이 시작되면(java.exe) jvm은 운영체에서 할당받은 메모리 영을 다음과 같이 세부 영역으로 나누어 구분해서 사용한다. 

#### 2-1. method area
클래스(~.class)파일들을 클래스 로더로 읽어 클래스별로 런타임상수풀, 필드 데이터, 메소드 데이터, 메소드 코드, 생성자 코드 등을 분류해서 저장한다.
(static변수, final class 변수 등) 
메소드 영역은 jvm이 시작할 때 생성되고 모든 스레드가 공유한다.

#### 2-2. heap
객체와 배열이 생성되는 영역이다. (new 키워드로 생성된 객체) <br>
힙 영역에 생성된 객체와 배열은 stack영의 변수나 다른 객체의 필드에서 참조한다 <br>
참조하는 변수나 객체가 없다면 gc가 실행된다. (즉, gc가 활동하는 영역이다.)

메소 영역에서 로드된 클래스만 생성 가능하다.

#### 2-3. stack
jvm 스택 영역은 각 스레드마다 하나씩 존재하며 스레드가 시작될 때 할당 된다. 
스택은 메소드를 호출할 때마다 프레임(frame)을 추가(push)하고 메소드가 종료되면 해당 프레임을 제거(pop)하는 동작을 수행한다.

즉, 메소드 내 정의된 지역 변수, 파라미터, 리턴 값, 연산에 사용되는 임시 등이 생성되는 영역이다.
예를 들어, Student stu = new Student(); 가 있다면,
Student stu 는 스택영역에, new로 생성된 Student클래스의 인스턴스는 heap영역에 생성된다.
그리고 stu값으로 힙 영역의 주소값을 갖고 있다.

#### 2-4. PC Register
thread가 생성될 때마다 생성되는 영역으로 현재 thread가 실행되는 부분의 주소와 명령을 저장하고 있는 영역이다.

#### 2-5. Native method stack
자바 외의 언어로 작성된 네이티브 코드를 위한 메모리 영역이다.

## 3. etc

#### 3.1 ==, =!의 연산
기본 타입 변수의 == =!의 경우, 변수의 값을 비교하지만 참조타입의 경우 주소값을 비교한다.

#### 3.2 String
Stringも参照型であるため、
値そのものが変数に格納されるわけではない。heap領域で生成されstackにその変数が生成され、変数にはメモリー番地が格納される。

String a = "java";
String b = "java";
if(a==b) -> true

String c = new String("java");
if(a==c) -> false

#### 3.3 call by reference vs call by value (but String type)

#### 3.4 null, NullPointerException
참조 타입은 힙 영역의 객체를 참조하고 있지 않다는 의미로 null의 값을 가질 수 있다. <br>
null값도 초기값으로 사용할 수 있기 때문에 null로 초기화된 변수는 stack에 생성된다.
例）longにはNUllの設定ができないが、Longの場合、クラスであるためNullの初期値の設定ができる。

nullPointerException는 null인 참조타입변수를 사용한 경우 발생한다.

#### 3.5 stackOverFlow vs Out of Memory(OOM)









