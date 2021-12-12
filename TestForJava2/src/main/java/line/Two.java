package line;

public class Two {
    public String solution(String S){
        String answer = null;

        // 0: 整数、 1: 少数点以下
        String [] numArray = S.split("\\.");
        char [] numCharArray = numArray[0].toCharArray();
        StringBuffer sb = new StringBuffer();

        int cnt = 0;

        for (int i = numCharArray.length-1; i >= 0; i--) {
            if (numCharArray[i] == '-') {
                sb.append(numCharArray[i]);
                break;
            }

            if (cnt != 0 && cnt % 3 == 0) sb.append(",");
            sb.append(numCharArray[i]);
            cnt++;
        }

        answer = sb.reverse().toString();

        if (numArray.length == 2) answer = answer + "." + numArray[1];

        return answer;
    }

    public static void main(String[] args) {
        Two two = new Two();
        String s = "-1234.0";
        System.out.println(two.solution(s));
    }
}
