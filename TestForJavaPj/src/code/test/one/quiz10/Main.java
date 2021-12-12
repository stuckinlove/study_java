package code.test.one.quiz10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * 10. 가장 짧은 문자거리
     * 설명
     * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     * 문자열의 길이는 100을 넘지 않는다.
     * 출력
     * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     */
    public static String solution(String next) {
        //
        StringBuffer result = new StringBuffer();

        // teachermode e
        String [] strArray = next.split(" ");
        String str = strArray[0];
        String key = strArray[1];
        char [] chars = str.toCharArray();

        // get key Position
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < chars.length ; i++) {
            char c = chars[i];
            if (String.valueOf(c).equals(key)){
                keys.add(i);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            int r = chars.length; // max
            if (String.valueOf(chars[i]).equals(key)) {
                result.append(0);result.append(" ");
                continue;
            }

            for (int k : keys) {
                r = (r > Math.abs(k - i)) ? Math.abs(k - i) : r;
            }
            result.append(r);result.append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        System.out.println(solution(next));
    }
}
