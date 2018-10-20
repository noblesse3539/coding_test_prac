package com.codingtest.ex;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Solution {
	public SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	public String[] table;
	
	public String solution(int n, int t, int m, String[] timetable) {
		// TODO Auto-generated method stub
		
		this.table = timetable;
		long shuttleTime =0, initTime;
		int arrIndex = 0;
		int[][] arr = new int[n][m];
		long arrivalTime;
		// arr -1로 초기화
		for (int i =0; i< n; i++) {
			for (int j=0; j< m; j++) {
				arr[i][j] = -1;
			}
		}
		
		int[] soltingArr = new int[timetable.length];
		for (int i=0; i< soltingArr.length; i++) {
			soltingArr[i] = i;
		}
		this.quicksolt(soltingArr, 0, soltingArr.length);
		try {
			initTime = sdf.parse("09:00").getTime();
//			System.out.println(shuttleTime.toString());
			for (int i =0; i< n; i++) {
				shuttleTime = initTime+ (i*t*60000);
				for (int j=0; j< m; j++) {
					if ( arrIndex < soltingArr.length) {
						arrivalTime= sdf.parse(timetable[soltingArr[arrIndex]]).getTime();
						if( arrivalTime <= shuttleTime) {
							arr[i][j] = soltingArr[arrIndex++];
							continue;
						} else {
							break;
						}
					}
					
				}
			}
			
			for (int i =0; i< n; i++) {
				for (int j=0; j< m; j++) {
					System.out.print(arr[i][j]+ " ");
				}
				System.out.println("");
			}
			
			if(arr[n-1][m-1] < 0) { 
				return sdf.format(shuttleTime).toString();
			} else {
				long temp = sdf.parse(table[arr[n-1][m-1]]).getTime()-60000;
				return sdf.format(temp).toString();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void quicksolt(int[] arr, int p, int q) {
		// TODO Auto-generated method stub
		if (q - p < 2) {
			return;
		}
		
		int pivot;
		try {
			pivot = this.partition(arr, p, q);
			this.quicksolt(arr, p, pivot);
			this.quicksolt(arr, pivot +1, q);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private int partition(int[] arr, int p, int q) throws ParseException {
		// TODO Auto-generated method stub
		int i = p, j = q;
		int pivotIndex = arr[p];
		long pivot = this.sdf.parse(this.table[arr[p]]).getTime();
		while (i < j) {
			while(i < j && this.sdf.parse(this.table[arr[--j]]).getTime() >= pivot);
			if(i < j) {
				arr[i] = arr[j];
			}
			while(i < j && this.sdf.parse(this.table[arr[++i]]).getTime() <= pivot);
			if(i < j) {
				arr[j] = arr[i];
			}
		}
		arr[j] = pivotIndex;
		return j;
	}
}
