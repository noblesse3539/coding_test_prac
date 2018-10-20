import java.util.Arrays;

public class Solution {

	public int[] solution(int N, int[] stages) {
		// TODO Auto-generated method stub
		int[] count = new int[N+2];
		int[] arrival = new int[N+1];
		double[] failure = new double[N+1];
		/*****************************************************************
		 * A(n) : n 스테이지에 도달한 모든 플레이어의 수
		 * A(1) = stages.length  // 1스테이지부터 시작하므로 모든 유저는 A(1)에 포함됨.
		 * A(2) = 1스테이지에 도달한 모든 플레이어의 수 - 1스테이지에 머물러있는 사람의 수. 즉,
		 * A(2) = A(1) - count[1]. 따라서,
		 * A(n) = A(n-1) - count[n-1].
		 * 
		 * 실패율 F(n) = count[n]/B(n).
		 *****************************************************************/
		for(int i = 0; i< stages.length; i++) {
			count[stages[i]]++;
		}
		arrival[1] = stages.length;
		failure[1] = 1.0*count[1]/arrival[1];
		for(int i = 2; i< arrival.length; i++) { // 층별 도달 인원과 층별 실패율 계산
			arrival[i] = arrival[i-1] - count[i-1];
			failure[i] = 1.0*count[i]/arrival[i];
		}

		int[] result = new int[N];   // result[n] =  n+1 스테이지.
		for (int i=0; i< result.length; i++) {
			result[i] = i+1;
		}
		System.out.println("count: " + Arrays.toString(count));
		System.out.println("arrival: " + Arrays.toString(arrival));
		System.out.println("failure: " + Arrays.toString(failure));
		quicksort(failure, result, 1, failure.length);
		return result;
	}

	private void quicksort(double[] arr1, int[] arr2, int p, int q) {
		// TODO Auto-generated method stub
		if(q-p < 2) {
			return;
		}
		int pivot = partition(arr1, arr2, p, q);
		quicksort(arr1, arr2, p, pivot);
		quicksort(arr1, arr2, pivot+1, q);
	}

	private int partition(double[] arr1, int[] arr2, int p, int q) {
		// TODO Auto-generated method stub
		int i = p, j = q;
		double pivot1 = arr1[p];
		int pivot2 = arr2[p-1];
		while( i < j) {
			while(i < j) {
				if(pivot1 <= arr1[--j]) {
					if(pivot1 == arr1[j] && pivot2 < arr2[j-1]) {
						continue;
					}
					break;
				}
			}
			if( i< j) {
				arr1[i] = arr1[j];
				arr2[i-1] = arr2[j-1];
			}
			while(i < j) {
				if(pivot1 >= arr1[++i]) {
					if(pivot1 == arr1[i] && pivot2 > arr2[i-1]) {
						continue;
					}
					break;
				}
			}
			if( i< j) {
				arr1[j] = arr1[i];
				arr2[j-1] = arr2[i-1];
			}
			
		}
		arr1[j] = pivot1;
		arr2[j-1] = pivot2;
		return j;
	}
}
