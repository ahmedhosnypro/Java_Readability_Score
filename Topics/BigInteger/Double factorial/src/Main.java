import java.math.BigInteger;
import java.util.Scanner;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger mult;
        int i;
        if (n % 2 == 0) {
            mult = two;
            i = 2;
        } else {
            mult = BigInteger.ONE;
            i = 1;
        }

        while (i <= n) {
            result = result.multiply(mult);
            mult = mult.add(two);
            i += 2;
        }
        return result;
    }
//    public  static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println(calcDoubleFactorial(n));
//    }
}


