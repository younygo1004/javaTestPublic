package normal.literaltest;

public class TestHashcode {

    public static void main(String[] args) {

        String s = "TEST";
        String s1 = "TEST";
        printHashCode(s, s1, "s", "s1");

        String ns = new String("TEST");
        String ns1 = new String("TEST");
        printHashCode(ns, ns1, "ns", "ns1");

        String vs = String.valueOf(Integer.MAX_VALUE);
        String vs1 = String.valueOf(Integer.MAX_VALUE);
        printHashCode(vs, vs1, "vs", "vs1");

        String svs = "2147483647";
        String svs1 = "2147483647";
        printHashCode(svs, svs1, "svs", "svs1");

    }

    private static void printHashCode(String s1, String s2, String s1Name, String s2Name) {

        System.out.println("--------------------");
        System.out.println(s1Name + ".hashCode() : " + s1.hashCode());
        System.out.println(s2Name + ".hashCode() : " + s2.hashCode());
        System.out.println(s1.hashCode() - s2.hashCode() == 0);
        System.out.println("--------------------");
        System.out.println("System.identityHashCode(" + s1Name + ") : " + System.identityHashCode(s1));
        System.out.println("System.identityHashCode(" + s2Name + ") : " + System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s1) - System.identityHashCode(s2) == 0);
        System.out.println();

    }

}
