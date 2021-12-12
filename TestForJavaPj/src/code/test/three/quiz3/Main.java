package code.test.three.quiz3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     *3. 최대 매출
     * 설명
     * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
     * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
     * 12 1511 20 2510 20 19 13 15
     * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
     * 여러분이 현수를 도와주세요.
     * 입력
     * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
     * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
     * 출력
     * 첫 줄에 최대 매출액을 출력합니다.
     */
    public static Integer solution(int num1, int num2, Integer[] nums1) {
//        int max = 0;
//        for (int i = 0; i < num1; i++) {
//            int tmp = 0;
//            for (int j = i; j < i + num2; j++) {
//                if (j < num1) tmp += nums1[j];
//            }
//            if (tmp > max) max = tmp;
//        }
//        return String.valueOf(max);

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < num2; i++) {
            sum = sum + nums1[i];
        }
        answer = sum;

        for (int j = num2; j < num1; j++) {
             sum = sum + nums1[j] - nums1[j-num2];
             answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        Integer [] nums1 = new Integer[num1];
        for (int i = 0; i < num1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.println(solution(num1, num2,nums1));
    }
}
