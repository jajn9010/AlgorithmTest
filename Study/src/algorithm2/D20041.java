package algorithm2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D20041 {
	static int n, x, y;
	static int[][] police;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		police = new int[n][2];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			police[i][0] = Integer.parseInt(st.nextToken());
			police[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		boolean result = false;
		for (int i = 0; i < 4; i++) {
			result = find(i);
			if (result == true)
				break;
		}

		if (result == true)
			bw.write("YES");
		else
			bw.write("NO");

		bw.flush();
		bw.close();
	}

	private static boolean find(int run) {
		for(int i=0;i<n;i++) {
			if(run==0) { //위로
				if(police[i][1]<=y) //탈출가능
					continue;
				int temp=police[i][0]>x?police[i][0]-x:x-police[i][0];
				if((police[i][1]-y)>=temp) //잡힘
					return false;
			}
			else if(run==1) {//아래
				if(police[i][1]>=y)
					continue;
				int temp=police[i][0]>x?police[i][0]-x:x-police[i][0];
				if((y-police[i][1])>=temp)
					return false;
			}
			else if(run==2) { //왼쪽
				if(police[i][0]>=x)
					continue;
				int temp=police[i][1]>y?police[i][1]-y:y-police[i][1];
				if((x-police[i][0])>=temp)
					return false;
			}
			else if(run==3){//오른쪽
				if(police[i][0]<=x)
					continue;
				int temp=police[i][1]>y?police[i][1]-y:y-police[i][1];
				if((police[i][0]-x)>=temp)
					return false;
			}
		}
		return true;
	}
}
