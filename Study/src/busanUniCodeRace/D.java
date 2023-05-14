package busanUniCodeRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int tr = Integer.parseInt(st.nextToken());
		int we = Integer.parseInt(st.nextToken());
		ArrayList<Integer> before = new ArrayList<>();
		int ans = 0;
		
		while(tr-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < we; i++) {
				map.put(i, Integer.parseInt(st.nextToken()));
			}
			
			int minKey = map.keySet().stream()
							.min(Comparator.comparing(map::get))
							.orElse(null);
			
			for (int i = 0; i < before.size(); i++) {
				if(before.get(i) == minKey) {
					map.remove(before.get(i));
					minKey = map.keySet().stream()
							.min(Comparator.comparing(map::get))
							.orElse(null);
				}
			}
			
			before.add(minKey);
			ans += map.get(minKey);
		}
		
		System.out.println(ans);
	}
}
