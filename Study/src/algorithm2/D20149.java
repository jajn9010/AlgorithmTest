package algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20149 {
	static class Point implements Comparable<Point> {
		public long x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return x == o.x ? Long.compare(y, o.y) : Long.compare(x, o.x);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());

		Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point p4 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		Point temp;
		if (p1.compareTo(p2) > 0) {
			temp = p1;
			p1 = p2;
			p2 = temp;
		}

		if (p3.compareTo(p4) > 0) {
			temp = p3;
			p3 = p4;
			p4 = temp;
		}

		int point1 = check(p1, p2, p3) * check(p1, p2, p4);
		int point2 = check(p3, p4, p1) * check(p3, p4, p2);

		boolean cross;

		if (point1 == 0 && point2 == 0) {
			cross = p1.compareTo(p4) <= 0 && p2.compareTo(p3) >= 0;
		} else {
			cross = point1 <= 0 && point2 <= 0;
		}

		StringBuilder sb = new StringBuilder();

		double div = (p1.x - p2.x) * (p3.y - p4.y) - (p1.y - p2.y) * (p3.x - p4.x);
		
		if (cross) {
			sb.append(1).append("\n");
			if (div != 0) {
				sb.append(1.0 * ((p1.x * p2.y - p1.y * p2.x) * (p3.x - p4.x) - (p3.x * p4.y - p3.y * p4.x) * (p1.x - p2.x)) / div).append(" ").append(1.0 * ((p1.x * p2.y - p1.y * p2.x) * (p3.y - p4.y) - (p3.x * p4.y - p3.y * p4.x) * (p1.y - p2.y)) / div).append("\n");
			} else if (p1.compareTo(p4) == 0 && p3.compareTo(p1) <= 0) {
				sb.append(p1.x).append(" ").append(p1.y).append("\n");
			} else if (p2.compareTo(p3) == 0 && p1.compareTo(p3) <= 0) {
				sb.append(p2.x).append(" ").append(p2.y).append("\n");
			}
		}else {
    		sb.append(0).append("\n");
    	}
		System.out.println(sb);
	}

	private static int check(Point p1, Point p2, Point p3) {
		long result = (p3.x - p1.x) * (p1.y - p2.y) - (p1.x - p2.x) * (p3.y - p1.y);
		return Long.compare(result, 0);
	}
}
