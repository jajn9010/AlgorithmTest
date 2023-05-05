//*
package test;

import java.util.regex.PatternSyntaxException;

public class regexTest {
	public static void main(String[] args) {
//		// 개행 문자가 들어간 비교할 문자열
//        String txt = "this\nis\ntest\n";
//
//        // . 기호는 모든 문자를 포함하지만 개행 문자는 포함하지 않기 때문에 일치하는 검색 결과가 없음
//        Matcher matcher1 = Pattern.compile("(^.*$)").matcher(txt);
//        System.out.println(matcher1.find()); // false
//
//
//        // . 기호가 개행 문자까지 포함하도록
//        Matcher matcher2 = Pattern.compile("(?s)(^.*$)").matcher(txt);
//        while (matcher2.find()) {
//            System.out.println(matcher2.group()); // this, is, test
//        }
//
//
//        // 다중 행 모드로 각 행마다 정규식 검사
//        Matcher matcher3 = Pattern.compile("(?m)(^.*$)").matcher(txt);
//        while (matcher3.find()) {
//            System.out.println(matcher3.group()); // this, is, test
//        }
//
//
//        // 대소문자 구분 X
//        Matcher matcher4 = Pattern.compile("(?i)([a-z]+)").matcher("HelloWorld"); // 정규식 기호로 전달
//        Matcher matcher5 = Pattern.compile("(^.*$)", Pattern.CASE_INSENSITIVE).matcher("HelloWorld"); // 상수로 전달
//        while (matcher5.find()) {
//            System.out.println(matcher5.group()); // HelloWorld
//        }
        
        try {
            String txt = "power987*-;";
            String[] splitStr = txt.split("+"); // 오류 문법
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
	}
}
//*/

/*
package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {
	public static void main(String[] args) {
		String source = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
		String pattern = "백두산";

		Matcher matcher = Pattern.compile(pattern).matcher(source);

		while (matcher.find()) {
			// start()와 end()로 일치하는 부분의 위치를 알아낼 수 있다.
			System.out.println("매칭되는 문자열 위치 : " + matcher.start() + " ~ " + matcher.end());
		}
	}
}
//*/

/*
package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {
	public static void main(String[] args) {
		String source = "011-4632-1290, 02-889-7661";
        String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

        Matcher matcher = Pattern.compile(pattern).matcher(source); // 한방에 매처 객체 반환

        System.out.println("그룹의 개수 : " + matcher.groupCount());    //그룹화된 개수가 몇개인지 출력

        int i = 0;
        while (matcher.find()) {
            System.out.println(++i + ": " + matcher.group() + " -> " + matcher.group(1) + " 와 " + matcher.group(2) + " 와 " + matcher.group(3));
        }
	}
}
//*/
/*
package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {
	public static void main(String[] args) {
		 String something = "hello987*-;hi66"; 

	        Pattern pattern = Pattern.compile("[a-z]+[0-9]+"); 
	        Matcher matcher = pattern.matcher(something);

	        while (matcher.find()) {
	            System.out.println(matcher.group());
	            // 루프 1번 : hello987
	            // 루프 2번 : hi66
	        }
	}
}
//*/
/*
package test;

import java.util.regex.Pattern;

public class regexTest {
	public static void main(String[] args) {
		// 문자열 형태의 정규표현식 문법을 정규식 패턴으로 변환
		String patternString = "^[0-9]*$";
		Pattern pattern = Pattern.compile(patternString);
		
		// 샘플 문자열
		String txt1 = "123123";
		String txt2 = "123이것은숫자입니다00";

		// 첫번째 매개값은 정규표현식이고 두번째 매개값은 검증 대상 문자열
		boolean result = Pattern.matches("^[0-9]*$", txt1); 
		System.out.println(result); // true

		boolean result2 = Pattern.matches("^[0-9]*$", txt2);
		System.out.println(result2); // false
	}
}
//*/
/*
package test;

import java.util.Arrays;

public class regexTest {
	public static void main(String[] args) {
		String txt = "jaejin";
		boolean result1 = txt.matches("[a-z]+"); // 영어 소문자로 이루어져 있는지
		System.out.println(result1); // true 
		
		// replaceAll (정규표현식과 일치하는 모든 값 치환)
		String txt2 = "power987*-;";
		String result2 = txt2.replaceAll("[^a-z0-9]","0"); // 영문자와 숫자를 제외한 문자를 모두 0으로 치환
		System.out.println(result2); // power987000
		
		// split (정규표현식과 일치하는 값 기준으로 나누기)
		String txt3 = "power987*-;";
		String[] txts = txt3.split("[0-9]+"); // 숫자부분을 기준으로 분할
		System.out.println(Arrays.toString(txts));
	}
}
//*/

/*
package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {
	public static void main(String[] args) {
		String[] test = {
				"나는 재진입니다.",
				"나는 규창입니다.",
				"나는 영회입니다.",
				"나는 준열입니다.",
				"나는 코끼리입니다.",
				"나는 바다표범입니다.",
				"나는 새입니다.",
				"나는 이것도될지모르겠네요입니다.",
		};
		
		for(String s : test) {
			System.out.println(s);
			Pattern p = Pattern.compile("나는 (.*)입니다.");
			Matcher m = p.matcher(s);

			 if(m.matches() ) {
				 System.out.println("group 0 : " + m.group(0));
				 System.out.println("group 1 : " + m.group(1));
			 } else {
				 System.out.println("일치 안함");
			 }
		}
		
	}
}
//*/