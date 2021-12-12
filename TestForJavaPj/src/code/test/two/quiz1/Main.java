package code.test.two.quiz1;

import java.util.Scanner;

public class Main {
    /**
     * 1. 큰 수 출력하기
     * 설명
     * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
     * (첫 번째 수는 무조건 출력한다)
     * 입력
     * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
     * 출력
     * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
     */
    public static String solution(Integer len, Integer [] next) {
        StringBuffer sb = new StringBuffer();
        sb.append(next[0]);
        for (int i = 1; i < len; i++) {
            if (next[i] > next[i-1]) {
                sb.append(" ");
                sb.append(next[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer i = sc.nextInt();
        Integer [] intarray = new Integer[i];
        for (int j = 0; j < i; j++) {
            intarray[j] = sc.nextInt();
        }
        System.out.print(solution(i, intarray));
    }
}
