package code.test.two.quiz12;

import java.util.Scanner;

public class Main {
    public static void solution(int num, Integer[][] numAray) {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Integer[][] numAray = new Integer[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                numAray[i][j] = sc.nextInt();
            }
        }

        solution(num, numAray);

    }
}
