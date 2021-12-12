import java.util.HashMap;
import java.util.Map;

public class Exam {

    static <T> T create(Class<T> clazz) throws  Exception{
        return clazz.newInstance();
    }

    public static void main(String[] args) throws  Exception{
        // 1.
        // genericクラス生成
        // どんなタイプのクラスでも作成できる。
        Generic<String> s = new Generic<String>();
        s.value = "String class";

        Generic<Integer> i = new Generic<>();
        i.value = 123; // CK/AHN
        // ahn dae young update
        // Bad Code abc123
//        Object o = "String";
//        Integer inte = (Integer)o;
//        System.out.println(inte);
//        ClassCastException発生 : Compileは問題なし、ただruntime時にエラー発生する。castingはできるかぎり使用禁止

        // Bad Code
//        map.put("1", 1);
//        map.put("String", 2);
//        Integer k = map.get("string"); // runtime時にerror発生

        // Good (Type Token)
        TypeSafeMap t = new TypeSafeMap();
        t.put(Integer.class, 1);
//        t.put(Integer.class, "string"); // Compile時にエラー発生なので、typesafe コードを作成できる
//        String str = t.get(Integer.class); // Compile時にエラー発生なので、typesafe コードを作成できる
        Integer inte = t.get(Integer.class);



    }

    // Type Token
    static class TypeSafeMap {
        Map<Class<?>, Object> map = new HashMap<>();
        // genericであるTを入れることでタイプを一致させることができる。
        <T> void put(Class<T> clazz, T value){
            map.put(clazz, value);
        }

        <T> T get(Class<T> clazz){
            return clazz.cast(map.get(clazz));
        }
    }

    // genericクラス
    static class Generic<T> { // genericTYPE<T>を指定
        T value;
        void setValue(T value){ }
        T getValue() { return value;}
    }
}
