package 포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s1 = br.readLine();

		String[] x = s1.split(" ");
		int a = Integer.parseInt(x[0]);
		int b = Integer.parseInt(x[1]);
		int i = 1;

		Map<Object, Object> m = new HashMap<>();
		String[] y = new String[a + 1];

		while (i < a + 1) {
			String name = br.readLine();
			m.put(name, i);
			y[i] = name;
			i++;
		}

		while (b-- > 0) {
			String find = br.readLine();
			try {
				int index = Integer.parseInt(find);
				sb.append(y[index] + "\n");
			} catch (NumberFormatException  e) {
				sb.append(m.get(find) + "\n");
			}
		}
		
		System.out.println(sb);
	}
}