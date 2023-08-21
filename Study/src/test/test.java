package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int num = Integer.parseInt(br.readLine());

			System.out.println("무슨 메뉴를 선택하시겠습니까?");
			System.out.println("1. HashMap, 2.List, 3.EXIT");
			switch (num) {
				case 1: {	
	
				}
				case 2: {
	
				}
				case 3: {
					System.out.println("시스템이 종료되었습니다.");
					System.exit(0);
				}
			}
		}
	}
}
