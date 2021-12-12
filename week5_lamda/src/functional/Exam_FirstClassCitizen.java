package functional;

import java.util.ArrayList;
import java.util.List;

/**
 * basic example (케빈tv - modern java)
 *
 * 함수형 프로그래밍의 조건으로 first class citizen에 만족해야함.(First Class Function을 지원하는 언어라고 말함.)
 * 1. 함수를 메소드 파라미터로 넘길 수 있어야 한다.
 * 2. 함수를 메소드의 결과값으로 받을 수 있어야 한다.
 * 3. 데이터 구조. 예를 들어 리스트 안에 함수를 넣을 수 있어야 한다. (저장 또는 viriable에 assign할 수 있어야 한다.)
 */
public class Exam_FirstClassCitizen {

    public static void main(String[] args) {
        Service s = new Service();

        // 파라메터에 함수를 넣음
        s.calculate((num1, num2) -> num1 + num2, 2,2);
        s.calculate((num1, num2) -> num1 - num2, 6,2);
        s.calculate((num1, num2) -> num1 * num2, 2,2);
        s.calculate((num1, num2) -> num1 / num2, 8,2);

        // 리턴값으로 함수를 받음
        Calculator customAdd = (num1, num2) -> (num1 + num2) * 2;
        s.calculate(customAdd, 2,2);

        // 객체에 함수를 넣음
        List<Calculator> c = new ArrayList<>();
        c.add((num1, num2)->num1+num2);
    }

    interface Calculator {
        abstract int calculate(int num1, int num2);
    }

    static class Service{
        int calculate(Calculator calculator, int num1, int num2){
            int result = calculator.calculate(num1, num2);
            System.out.println(result);
            return result;
        }
    }

}
