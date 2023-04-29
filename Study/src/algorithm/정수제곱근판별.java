package algorithm;

public class 정수제곱근판별 {
	public static void main(String[] args) {
		long answer = 0;
		
		long n = 121;
		
		answer = (n % Math.sqrt(n) == 0) ? (long) Math.pow(Math.sqrt(n)+1, 2) : -1;
		
		System.out.println(answer);
		
	}
}
