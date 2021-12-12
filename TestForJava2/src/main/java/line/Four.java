package line;

import java.util.ArrayList;
import java.util.List;

public class Four {
    public int solution(int[] A){
//        Arrays.sort(A);

        if (A.length < 3) return -1;

        List<Integer> numList = new ArrayList<>();
        for (int i : A) numList.add(i);

        int max1 = getMaxNum(numList);
        int max2 = getMaxNum(numList);
        int max3 = getMaxNum(numList);

        return max1 * max2 * max3;
    }

    public Integer getMaxNum(List<Integer> numList){
        int pos = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) > max){
                max = numList.get(i);
                pos = i;
            }
        }
        numList.remove(pos);

        return max;
    }

    public static void main(String[] args) {
        Four four = new Four();
        int [] a = new int []{-1,0,-3,4,5};
        System.out.println(four.solution(a));
    }
}
