package com.codingtest.ex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
	private HashMap<String, Integer> map = new HashMap<String, Integer>();  // key : genres, value: totalPlays
	
	public int[] solution(String[] genres, int[] plays) {
		// TODO Auto-generated method stub
		int[] answer;
	
		for (int i=0; i< genres.length; i++) {
			if (this.map.containsKey(genres[i])) {
				this.map.put(genres[i], this.map.get(genres[i])+ plays[i]);
			} else {
				this.map.put(genres[i], plays[i]);
			}
		}
		String[] genre = Arrays.asList(this.map.keySet().toArray()).toArray(new String[map.size()]);
		this.quickSort(genre, 0, genre.length);

		LinkedList<Integer> list = new LinkedList<Integer>();
		String g;
		for (int i= genre.length-1; i>=0 ; i--) {
			int first = -1, second = -1, fp= -1, sp = -1;
			g = genre[i];
			for (int j =0; j< genres.length; j++) {
				if(genres[j].equals(g)) {
					if (plays[j] > sp) {
						if (plays[j] > fp) {
							second = first;
							sp = fp;
							first = j;
							fp = plays[j];
						} else {
							second = j;
							sp = plays[j];
						}
					}
				}
			}
			list.addLast(first);
			if(second >= 0) {
				list.addLast(second);
			}
		}
		answer = new int[list.size()];
		for (int i=0; i< answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
	
	public void quickSort(String[] a, int p, int q) {
		if( q - p < 2) {
			return;
		}
		int pivot = partition(a, p, q);
		quickSort(a, p, pivot);
		quickSort(a, pivot + 1, q);
	}

	private int partition(String[] a, int p, int q) {
		// TODO Auto-generated method stub
		String pivot = a[p];
		int i = p, j = q;
		while (i < j) {
			while(j > i && this.map.get(a[--j]) >= this.map.get(pivot)) ;
			if (i < j) {
				a[i] = a[j];
			}
			while ( i< j && this.map.get(a[++i]) <= this.map.get(pivot)) ;
			if( i < j) {
				a[j] = a[i];
			}
		}
		
		a[j] = pivot;
		return j;
	}
}
