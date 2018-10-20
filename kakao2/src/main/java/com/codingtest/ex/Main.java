/**
 * 기능개발
 */

package com.codingtest.ex;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Solution s = ctx.getBean("solution", Solution.class);

		for( int j =0; j< 10; j++) {
			int numOfJob = (int)(Math.random()*10) + 1;
			int[] progresses = new int[numOfJob];
			int[] speeds = new int[numOfJob];
			
			for(int i=0; i< numOfJob; i++) {
				progresses[i] = (int)(Math.random()*99) +1;
				speeds[i] = (int)(Math.random()*100) + 1;
			}
			System.out.println(j + "번째 테스트");
			System.out.println("numOfJob	: " + numOfJob);
			System.out.println("progresses	: " + Arrays.toString(progresses));
			System.out.println("speeds		: " + Arrays.toString(speeds));
			System.out.println("result		: " + Arrays.toString(s.solution(progresses.clone(), speeds)));			
			System.out.println("numOfJob	: " + numOfJob);
			System.out.println("progresses	: " + Arrays.toString(progresses));
			System.out.println("speeds		: " + Arrays.toString(speeds));
			System.out.println("result2		: " + Arrays.toString(s.solution2(progresses.clone(), speeds)));			

			System.out.println("");
		}
		
		ctx.close();
		
	}
}
