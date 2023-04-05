package mypack;
import java.util.Scanner;

public class magic_square {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = 0;									//입력받을 변수
		System.out.print("n : ");
		n = sc.nextInt();							//정수 입력

		int[][] A = new int[n][n];					//마방진을 나타내는 2차원 배열 생성
			
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = 0;						//2차원 배열 0으로 초기화
			}
		}

		int p, q;									//2차원 배열의 index값 변수
		p = 0; q = n/2;								//처음 index값 지정
		
		int tmp_p=p; int tmp_q=q; 					//index값을 잠시 저장하는 변수
		
		for(int i = 1; i <= n*n ; i++) {
			//값을 넣으려는 마방진의 위치에 값이 아직 존재하지 않는 경우
			if(A[p][q] == 0) {						
				A[p][q] = i;						//해당 위치에 i값 저장
				tmp_p=p;tmp_q=q;					//
				p--; q++;							//다음 위치로의 index값 
				if(p<0) p += n; if(p>=n) p -= n;	//해당 위치가 마방진의 범위 밖일 경우
				if(q<0) q += n; if(q>=n) q -= n;	
			}
			//값을 넣으려는 마방진의 위치에 값이 이미 존재하는 경우 
			else {
				tmp_p++; if(tmp_p>=n) tmp_p -= n;	//값이 존재하는 칸 아래 칸의 index
				A[tmp_p][tmp_q] = i;				//값이 이미 존재하면 그 아래의 칸에 값 저장
				p = tmp_p; q = tmp_q;				//값을 저장한 칸을 다음 칸을 찾기위해 처음 값으로 저장
				p--; q++;							//다음 위치로의 index값 
				if(p<0) p += n; if(p>=n) p -= n;	//해당 위치가 마방진의 범위 밖일 경우
				if(q<0) q += n; if(q>=n) q -= n;
			}
		}

		for(int i = 0; i < n; i++) {				//해당 마방진을 형식에 맞게 출력
			for(int j = 0; j < n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		sc.close();
	}
}
