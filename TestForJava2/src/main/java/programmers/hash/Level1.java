package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Level1 {

    public static void main(String[] args) {
//        String [] participant = {"leo", "kiki", "eden"};
//        String [] completion = {"eden", "kiki"};

//        String [] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String [] completion = {"josipa", "filipa", "marina", "nikola"};

        String [] participant = {"mislav", "stanko", "mislav", "ana"};
        String [] completion = {"stanko", "ana", "mislav"};

        String solution = solution(participant, completion);
        System.out.println(solution);
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> partMap = new HashMap<>();
        for (String parti : participant) {
            partMap.put(parti, partMap.getOrDefault(parti, 0) + 1);
        }

        String answer = "";
        for (String compl : completion) {
            Integer i = partMap.get(compl);
            if (i == null) {
                return compl;
            }

            partMap.put(compl, partMap.get(compl) - 1);
        }

        for (String xMan : partMap.keySet()) {
            Integer i = partMap.get(xMan);
            if (i > 0){
                return xMan;
            }
        }

        return answer;
    }
}