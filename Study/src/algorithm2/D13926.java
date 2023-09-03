package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class D13926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long ans = n;

        if (n == 1) {
            System.out.println(1);
        } else {
            Set<Long> s = new HashSet<>();
            while (n > 1) {
                long div = pollardRho(n);
                s.add(div);
                n = n / div;
            }
            for (long i : s) {
                ans /= i;
                ans *= (i - 1);
            }
            System.out.println(ans);
        }
    }

    private static long pollardRho(long n) {
        if (isPrime(n)) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return 2;
        }
        long x = getRandomNumberInRange(2, n);
        long y = x;
        long c = getRandomNumberInRange(1, n);
        long d = 1;

        while (d == 1) {
            x = (power(x, 2, n) + c) % n;
            y = (power(y, 2, n) + c) % n;
            y = (power(y, 2, n) + c) % n;
            d = gcd(Math.abs(x - y), n);
            if (d == n) {
                return pollardRho(n);
            }
        }

        if (isPrime(d)) {
            return d;
        } else {
            return pollardRho(d);
        }
    }

    private static boolean isPrime(long num) {
        long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

        if (num == 1 || (num != 2 && num % 2 == 0)) {
            return false;
        }

        for (long prime : primes) {
            if (num == prime) {
                return true;
            }
            if (!millerRabin(num, prime)) {
                return false;
            }
        }
        return true;
    }

    private static boolean millerRabin(long num, long prime) {
        long r = 0;
        long d = num - 1;

        while (d % 2 == 0) {
            r++;
            d = d / 2;
        }

        long x = power(prime, d, num);

        if (x == 1 || x == num - 1) {
            return true;
        }

        for (int i = 0; i < r - 1; i++) {
            x = power(x, 2, num);
            if (x == num - 1) {
                return true;
            }
        }

        return false;
    }

    private static long gcd(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    private static long getRandomNumberInRange(long min, long max) {
        Random random = new Random();
        return random.nextInt((int) ((max - min) + 1)) + min;
    }
}
