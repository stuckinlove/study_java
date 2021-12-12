package code.test.two.quiz10;

import java.util.Scanner;

public class Main {
    /**
     * 10. 봉우리
     * 설명
     * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
     * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
     * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
     * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
     * 입력
     * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     * 출력
     * 봉우리의 개수를 출력하세요.
     */
    public static void solution(int num, Integer [][] numAray) {
        int result = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                int base = numAray[i][j];
                int up = i-1 > -1 ? numAray[i-1][j] : 0;
                int down = i+1 < num ? numAray[i+1][j] : 0;
                int left = j-1 > -1 ? numAray[i][j-1] : 0;
                int right = j+1 < num ? numAray[i][j+1] : 0;

                int max = Math.max(up, down);
                max = Math.max(max, left);
                max = Math.max(max, right);
                if (base > max) {
                    result ++;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Integer [][] numAray = new Integer[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                numAray[i][j] = sc.nextInt();
            }
        }

        solution(num, numAray);
    }
}
