package line;

import java.util.HashMap;
import java.util.Map;

public class One {
    public int solution(String S){
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        if(S.length() < 2) return answer;

        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (char c : map.keySet()){
            if (map.get(c) > 1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        One one = new One();
        String str = "sfdsfdafsadfdfsadfsadasfdsafdsafdasfdasfasdfasd";
        System.out.println(one.solution(str));

    }
}
