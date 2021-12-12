package code.test.two.quiz3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    /**
     * 설명
     * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
     * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
     * 예를 들어 N=5이면
     * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * 출력
     * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
     */
    public static void solution(Integer cnt, Integer [] a, Integer [] b) {
        Iterator<Integer> aIter = Arrays.asList(a).iterator();
        Iterator<Integer> bIter = Arrays.asList(b).iterator();

        StringBuffer sb = new StringBuffer();
        while (aIter.hasNext() && bIter.hasNext()){
            System.out.println(getGameResult(aIter.next(), bIter.next()));
        }
    }

    private static String getGameResult(Integer a, Integer b){
        String result = null;
        if (a.intValue() == b.intValue()){
            return "D";
        }

        switch (a.intValue()) {
            case 1: // 가위
                if (b.intValue()==2){ // 바
                    result = "B";
                }else {
                    result = "A";
                }
                break;

            case 2: // 바위
                if (b.intValue()==3){ //
                    result = "B";
                }else {
                    result = "A";
                }
                break;

            case 3: //
                if (b.intValue()==1){ // 가
                    result = "B";
                }else {
                    result = "A";
                }
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer cnt = sc.nextInt();
        Integer [] a = new Integer[cnt];
        Integer [] b = new Integer[cnt];
        for (int i = 0; i < cnt; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            b[i] = sc.nextInt();
        }
        solution(cnt, a, b);
    }
}
