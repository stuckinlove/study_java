package code.test.one.quiz5;

import java.util.*;

public class Main {
    /**
     * 5. 특정 문자 뒤집기
     * 설명
     * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * 출력
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     */
    public static String solution(String str) {
        char [] chars = str.toCharArray();
        int len = chars.length;
        int i = 0;

        char tmpLt = 0;
        char tmpRt = 0;
        boolean startFlg = true;
        while (i < len) {
            tmpLt = chars[i];
            tmpRt = chars[len - 1];

            if (Character.isAlphabetic(tmpLt) && Character.isAlphabetic(tmpRt)){
                chars[len - 1] = tmpLt;
                chars[i] = tmpRt;
                i++;
                len--;
            }
            else if (Character.isAlphabetic(tmpLt) && !Character.isAlphabetic(tmpRt)){
                len--;
            }
            else if (!Character.isAlphabetic(tmpLt) && Character.isAlphabetic(tmpRt)){
                i++;
            }
            else {
                i++;
                len--;
            }

        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(solution(str));
    }
}
