package code.test.two.quiz4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    /**
     * 4. 피보나치 수열
     * 설명
     * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
     * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
     * 입력
     * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
     * 출력
     * 첫 줄에 피보나치 수열을 출력합니다.
     */
    public static void solution(Integer num) {
        Integer startNum = 1;
        Integer tmpNum = 0;
        Integer [] tmpArray = new Integer[num];
        tmpArray[0] = 1;
        tmpArray[1] = 1;
        for (int i = 2; i < num; i++) {
            tmpArray[i] = tmpArray[i - 2] + tmpArray[i - 1];
        }
        String result = Arrays.asList(tmpArray).stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" "));
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.nextInt());
    }
}
