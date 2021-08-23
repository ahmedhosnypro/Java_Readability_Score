import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        BigInteger M = new BigInteger(s);

        BigInteger n = BigInteger.ONE;
        BigInteger r = BigInteger.ONE;
        while (r.compareTo(M) <= 0 && r.compareTo(M) != 0) {
            r = n.multiply(r);
            n = n.add(BigInteger.ONE);
        }
        n = n.subtract(BigInteger.ONE);
        System.out.println(n);
    }
}