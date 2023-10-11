import java.math.BigInteger;

public class FibCalc {
    public static BigInteger calFib(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger next = prev.add(current);
            prev = current;
            current = next;
        }
        return current;
    }
}
