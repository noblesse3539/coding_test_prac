package kakaoexam1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	public String[] solution(String[] record) {
		// TODO Auto-generated method stub
		
        HashMap<String, String> map = new HashMap<>(); // key : uid,	value : nickname
        ArrayList<String> idList = new ArrayList<String>();
        ArrayList<Integer> textList = new ArrayList<Integer>();
        StringTokenizer token;
        String act, uid, nick;
        
        String[] text = {"님이 들어왔습니다.","님이 나갔습니다."};
        
        for (int i=0; i< record.length; i++) {
        	token = new StringTokenizer(record[i]);
        	act = token.nextToken();
        	
        	switch(act) {
        	case "Enter" :
        		uid = token.nextToken();
        		nick = token.nextToken();
        		if (map.containsKey(uid)) {
        			map.replace(uid, nick);
        		} else {
        			map.put(uid, nick);
        		}
        	
        		idList.add(uid);
        		textList.add(0);
        		break;
        		
        	case "Leave" :
        		uid = token.nextToken();
        		idList.add(uid);
        		textList.add(1);
        		break;
        		
        	case "Change" :
        		uid = token.nextToken();
        		nick = token.nextToken();
        		if(map.containsKey(uid)) {
        			map.replace(uid, nick);
        		}
        		break;
        	}
        }
        
        String[] result = new String[idList.size()];
        for(int i=0; i< result.length; i++) {
        	result[i] = map.get(idList.get(i)) + text[textList.get(i)];
        }
        
        return result;
	}

}
