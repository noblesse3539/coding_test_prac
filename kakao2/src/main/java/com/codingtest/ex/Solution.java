package com.codingtest.ex;

import java.util.LinkedList;

public class Solution {
	
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer;
        int day = 1;
        int temp;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i< progresses.length; i++) {
        	progresses[i] += day*speeds[i];
        	if(progresses[i] >= 100) {
        		if(list.isEmpty()) {
        			list.add(1);
        		} else {
        			temp = list.removeLast()+1;
        			list.addLast(temp);        			
        		}
        		continue;
        	}
        	while(progresses[i] <= 100) {	// 작으면이 아니라 작거나 같으면으로 해야 성공하는데 왜그런지 모르겠다.
        		day++;
        		progresses[i] += speeds[i];
        	}
        	list.addLast(1);
        }
        answer = new int[list.size()];
        for(int i=0; i< answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	public int[] solution2(int[] progresses, int[] speeds) {
		int[] answer;
        int day = 1;
        int temp;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i< progresses.length; i++) {
        	progresses[i] += day*speeds[i];
        	if(progresses[i] >= 100) {
        		if(list.isEmpty()) {
        			list.add(1);
        		} else {
        			temp = list.removeLast()+1;
        			list.addLast(temp);        			
        		}
        		continue;
        	}
        	while(progresses[i] < 100) {
        		day++;
        		progresses[i] += speeds[i];
        	}
        	list.addLast(1);
        }
        answer = new int[list.size()];
        for(int i=0; i< answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
