package code.test.three.quiz2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * 2. 공통원소 구하기
     * 설명
     * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
     * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
     * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
     * 출력
     * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
     * 5
     * 1 3 9 5 2
     * 5
     * 3 2 5 7 8
     */
    public static String solution(int num1, Integer[] nums1, int num2, Integer[] nums2) {
//        List<Integer> answer = new ArrayList<>(num1 + num2);
//        List<Integer> nums2List = new ArrayList<>(Arrays.asList(nums2));
//        for (Integer n1 : nums1) {
//            if(nums2List.contains(n1)) {
//                answer.add(n1);
//            }
//        }
//        return answer.stream().sorted().map(s -> String.valueOf(s)).collect(Collectors.joining(" "));

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        List<String> answer = new ArrayList<>();
        while (p1 < num1 && p2 < num2){
            if (nums1[p1] < nums2[p2]){
                p1 ++;
                continue;
            }else if (nums1[p1] == nums2[p2]){
                answer.add(String.valueOf(nums1[p1]));
                p1++;
                p2++;
                continue;
            }else{
                p2++;
                continue;
            }
        }

        return answer.stream().collect(Collectors.joining(" "));
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
