package code.test.one.quiz11;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * 11. 문자열 압축
     * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
     * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     * 단 반복횟수가 1인 경우 생략합니다.
     * 입력
     * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     * 출력
     * 첫 줄에 압축된 문자열을 출력한다.
     */
    public static String solution(String next) {
        StringBuffer sb = new StringBuffer();

        List<String> strList = Arrays.asList(next.split(""));
        String tmp = "";
        int cnt = 0;
        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).equals(tmp)){
                cnt++;
            }else {
                if (!sb.toString().isEmpty() && cnt > 1) {
                    sb.append(cnt);
                }
                cnt=0;
                tmp = strList.get(i);
                sb.append(strList.get(i));
                cnt++;
            }

            if (i+1 == strList.size() && cnt > 1){
                sb.append(cnt);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println(solution(next));
    }
}
