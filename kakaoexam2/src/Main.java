import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		int n;
		int[] stages;
//		int n = 5;
//		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		System.out.println(Arrays.toString(s.solution(n, stages)));
		
		System.out.println("******** T E S T ********");
		for (int i=1; i<= 10; i++) {
			n = 10;
			stages = new int[50];
			for( int j = 0; j< stages.length; j++) {
				stages[j] = (int)(Math.random()*(n+1)+1);
			}
			System.out.println(i+"번째 테스트 ---");
			System.out.println("N: " + n);
			System.out.println("stages: " + Arrays.toString(stages));
			System.out.println("result: " + Arrays.toString(s.solution(n, stages)));
			System.out.println();
			
		}
	}
}
