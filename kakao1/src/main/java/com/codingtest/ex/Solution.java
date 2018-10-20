package com.codingtest.ex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Solution {

	public int solution(String[] lines) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		Date[] date = new Date[lines.length];
		long[] processMillTime = new long[lines.length];
		int[] count = new int[lines.length];
		StringTokenizer token;
		String temp;
		int answer = -1;
		
		for (int i=0; i<lines.length; i++) {
			token = new StringTokenizer(lines[i], " ");
			token.nextToken();
			try {
				date[i] = sdf.parse(token.nextToken());
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			temp = token.nextToken();
			temp = temp.substring(0, temp.length()-1);
			processMillTime[i] = (long)(Double.parseDouble(temp)* 1000);			
		}
		
		long p, q;
		
		for (int i=0; i< date.length; i++) {
			p = date[i].getTime();
			for(int j= i; j< date.length; j++) {
				q= date[j].getTime();
				if(	(q - processMillTime[j]+1 > p + 999) ) {
					continue;
				} else {
					count[i]++;
				}
			}
		}
		
		for (int i=0; i< count.length; i++) {
			if (count[i] > answer) {
				answer = count[i];
			}
		}
		
		return answer;
	  }
}
