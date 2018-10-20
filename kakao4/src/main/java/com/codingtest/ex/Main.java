/**
 * 셔틀버스
 */
package com.codingtest.ex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Solution s = ctx.getBean("solution", Solution.class);
		
		long temp;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		int n = 9, t = 34, m = 9;
		String[] timetable = {"08:18", "10:50", "00:57", "18:53", "08:25", "15:55", "11:43", "14:30", "12:13", "07:43"};
//		String[] timetable = new String[10];
		/**
		for (int i =0; i< 10; i++) {
			try {
				n = (int)(Math.random()*10) + 1;
				t = (int)(Math.random()*60) + 1;
				m = (int)(Math.random()*10) + 1;
				temp = sdf.parse("23:59").getTime() - sdf.parse("00:00").getTime();
				for (int j=0; j< 10; j++) {
					timetable[j] = sdf.format(((long)(Math.random()*temp) +1)).toString();
				}
				System.out.println((i+1)+"번째 테스트");
				System.out.println("n : " + n + ", t : " + t + ", m : " + m);
				System.out.println(Arrays.toString(timetable));
				System.out.println("result : " + s.solution(n,t,m,timetable));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		System.out.println(s.solution(n,t,m,timetable));
		
		ctx.close();
	}
}
