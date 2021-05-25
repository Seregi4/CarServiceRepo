public class Main {
    public static void main(String[] args) {

        int a =1;
        int b =2;

        String t1 = "TQ";
        String t2 = "TQ";
        getText(t1, t2);




    }

    private static void getText(String t1, String t2) {
        String getText = t1 + t2;
        System.out.println(getText);
    }

    public  int getSum (int a, int b) {
        int i = a + b;
        System.out.println(i);
        return i;
    }
}
