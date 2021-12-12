package code.test.two.quiz9;

import java.util.Scanner;

public class Main {
    /**
     * 9. 격자판 최대합
     * 설명
     * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
     * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
     * 입력
     * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     * 출력
     * 최대합을 출력합니다.
     */
    public static void solution(int num, int [][] checkNums) {
        int resultMax = 0;
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        for (int i = 0; i < num; i++) {
            int widthMax = 0;
            int heightMax = 0;

            for (int j = 0; j < num; j++) {
                widthMax = widthMax + checkNums[i][j];
                heightMax = heightMax + checkNums[j][i];
                if (i == j) leftDiagonal = leftDiagonal + checkNums[i][j];
                if (i+j == num - 1) rightDiagonal = rightDiagonal + checkNums[i][j];
            }

            if (widthMax > resultMax) resultMax = widthMax;
            if (heightMax > resultMax) resultMax = heightMax;
        }
        if (leftDiagonal > resultMax) resultMax = leftDiagonal;
        if (rightDiagonal > resultMax) resultMax = rightDiagonal;
        System.out.println(resultMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [][] checkNums = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                checkNums[i][j] = sc.nextInt();
            }
        }
        solution(num, checkNums);
    }
}
