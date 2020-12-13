# DataType - reference type
参照
* https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
* https://www.w3schools.com/java/java_data_types.asp

####目標
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

#### 1-3. primitive vs Non-primitive(参照型)
基本データ型と参照型の違いは以下である。 <br>

* Primitive types are predefined (already defined) in Java. Non-primitive types are created by the programmer and is not defined by Java (except for String).
* Non-primitive types can be used to call methods to perform certain operations, while primitive types cannot.
* A primitive type has always a value, while non-primitive types can be null.
* A primitive type starts with a lowercase letter, while non-primitive types starts with an uppercase letter.
* The size of a primitive type depends on the data type, while non-primitive types have all the same size. <br>
Examples of non-primitive types are Strings, Arrays, Classes, Interface, etc.




