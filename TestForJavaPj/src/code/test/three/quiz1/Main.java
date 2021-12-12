package code.test.three.quiz1;

import java.util.*;

public class Main {
    /**
     * 1. 두 배열 합치기
     * 설명
     * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
     * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
     * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
     * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
     * 출력
     * 오름차순으로 정렬된 배열을 출력합니다.
     */
    public static String solution(int num1, Integer[] nums1, int num2, Integer[] nums2) {
        StringBuffer sb = new StringBuffer();
        int one = 0;
        int two = 0;
        while (one < num1 && two < num2){
            if (nums1[one] < nums2[two]){
                sb.append(nums1[one++]);
            }else{
                sb.append(nums2[two++]);
            }
        }

        while (one < num1) sb.append(nums1[one++]);
        while (two < num1) sb.append(nums2[two++]);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        Integer [] nums1 = new Integer[num1];
        for (int i = 0; i < num1; i++) {
            nums1[i] = sc.nextInt();
        }
        int num2 = sc.nextInt();
        Integer [] nums2 = new Integer[num1];
        for (int i = 0; i < num1; i++) {
            nums2[i] = sc.nextInt();
        }

        System.out.println(solution(num1, nums1, num2, nums2));
    }
}
