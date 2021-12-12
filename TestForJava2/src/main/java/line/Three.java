package line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LineTestMap{
    int limit; // 経過時間
    String key;
    String value;

    public LineTestMap(String key, String value) {
        this.key = key;
        this.value = value;
        this.limit = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return "LineTestMap{" +
                "limit=" + limit +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

class LineTestExec {
    Map<String, LineTestMap> map = new HashMap<>();

    void add(String key, String value) {
        LineTestMap l = null;
        if (map.containsKey(key)){
            l = map.get(key);
            l.value = value;
            l.limit--;
        }else{
            l = new LineTestMap(key, value);
        }
        map.put(key, l);
    }

    String get(String key) {
        if (map.containsKey(key)) {
            map.get(key).limit-=1;
            return map.get(key).value;
        }
        else return "-1";
    }

    String remove(String key) {
        String result = "-1";
        if (map.containsKey(key)) {
            result = map.remove(key).value;
        }
        return result;
    }

    void evict() {
        int maxLimit = Integer.MIN_VALUE;
        String maxLimitKey = null;
        for (Map.Entry<String, LineTestMap> m : map.entrySet()) {
            if (maxLimit < m.getValue().limit) {
                maxLimit = m.getValue().limit;
                maxLimitKey = m.getValue().key;
            }
        }

        if (maxLimit != 0) {
            map.remove(maxLimitKey);
        }
    }

}

public class Three {
    public int [] solution(String[] A) {
        List<String> tmpList = new ArrayList<>();
        LineTestExec exec = new LineTestExec();

        for (String proc : A) {
            String [] proArray = proc.split(" ");
            switch (proArray[0]){
                case "add":
                    exec.add(proArray[1], proArray[2]);
                    break;

                case "get":
                    tmpList.add(exec.get(proArray[1]));
                    break;

                case "remove":
                    tmpList.add(exec.remove(proArray[1]));
                    break;

                case "evict":
                    exec.evict();
                    break;

                default: // exit
                    break;
            }
        }

        int [] result = new int[tmpList.size()];
        for (int i = 0; i < tmpList.size(); i++) {
            result[i] = Integer.parseInt(tmpList.get(i));
        }

//        System.out.println(tmpList.stream().collect(Collectors.joining(" ")));
        for (int i : result) {
            System.out.print(i + " ");
        }
        return result;
    }

    public static void main(String[] args) {
        Three th = new Three();
        String [] strArray = new String[]{"add 5 3", "add 1 2", "get 5", "evict", "get 1", "remove 5", "exit"};
        th.solution(strArray);
    }
}
