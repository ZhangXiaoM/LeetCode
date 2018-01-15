public class Main {

    public static void main(String[] args) {

        String s = ", , , ,        a, eaefa";

        System.out.println(countSegments(s));
    }

    public static int countSegments(String s) {
        if (s.length() <= 0) return 0;

        String[] arr = s.split(" ");

        int cnt = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (!arr[i].equals("")) {
                cnt ++;
            }
        }

        return cnt;
    }
}
