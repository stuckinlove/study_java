import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public int solution(int[] A) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // min, max
        for (int aNum : A) {
            min = Math.min(min, aNum);
            max = Math.max(max, aNum);
            if (min < 0) return 1;
        }

        int size = A.length;
        Set<Integer> aSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            aSet.add(A[i]);
        }

        for (int i = min; i < max; i++) {
            if (!aSet.contains(i)) return answer = i;
        }

        if (answer == 0) answer = max + 1;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Hello java");
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int [] a = new int[c];
        for (int i = 0; i < c; i++) {
             a[i] = sc.nextInt();
        }
        System.out.println(m.solution(a));
    }
}
