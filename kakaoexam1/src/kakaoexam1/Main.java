package kakaoexam1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		String[] arg = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		System.out.println(Arrays.toString(s.solution(arg)));
	}
}
