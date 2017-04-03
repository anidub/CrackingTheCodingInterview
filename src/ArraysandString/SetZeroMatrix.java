package ArraysandString;

public class SetZeroMatrix {
/*
	static int M = 3;
	static int N = 3;
	public static void main(String[] args) {
		int[][] matrix={{1,2,3},{0,3,40},{2,7,8}};
		SetZeroMatrix M=new SetZeroMatrix();
		System.out.println("Before set");
		M.display_matrix(matrix);
		M.set_matrix(matrix);
		System.out.println("After set");
		M.display_matrix(matrix);
}
	
	void display_matrix(int[][] matrix){
		for(int i = 0; i< matrix.length;i++){
			for(int j = 0; j < matrix[0].length;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	void set_matrix(int[][] matrix){
		boolean[] row = new boolean[M];
		boolean[] col = new boolean[N];
		int i,j,p;
		
		for(i = 0; i < M; i++){
			for(j = 0;j< M; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		
		for(i = 0; i < M; i++){
			for(j = 0; j < N; j++){
				if(row[i] == true & col[j] == true){
					for(p = 0; p < N; p++){
						matrix[i][p] = 0;
					}
				}
			}
		}
	}
*/
	//set M*N matrix
	static int M=4;
	static int N=5;
	
	/*
	 * display the matrix
	 */
	void display_matrix(int[][] matrix) {
		int i,j;
		for(i=0;i<M;i++) {
			for(j=0;j<N;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	/*
	 * set the matrix. when an element in an MxN matrix is 0, its entire row and column are set to 0
	 */
	void set_matrix(int[][] matrix) {
		boolean[] row = new boolean[M];
		boolean[] col = new boolean[N];
		int i,j,p;
		
		//set row[i] and col[j]
		for(i=0;i<M;i++) {
			for(j=0;j<N;j++) {
				if(matrix[i][j]==0) {
					row[i]=true;
					col[j]=true;
				}
			}
		}
		//set the column items to 0
		for(i=0;i<M;i++) {
			for(j=0;j<N;j++) {
				if(row[i]==true || col[j]==true) {
					for(p=0;p<N;p++) {
						matrix[i][p]=0;
					}
				}
			}
		}
		
		//set the row items to 0
		for(i=0;i<M;i++) {
			for(j=0;j<N;j++) {
				if(row[i]==true || col[j]==true) {
					for(p=0;p<M;p++) {
						matrix[p][j]=0;
					}
				}
			}
		}
	}
	
	static public void main(String[] args) {
		int[][] matrix={{1,2,3,4,7},{0,3,4,5,10},{2,7,8,9,12},{2,3,0,7,13}};
		SetZeroMatrix M=new SetZeroMatrix();
		System.out.println("Before set");
		M.display_matrix(matrix);
		M.set_matrix(matrix);
		System.out.println("After set");
		M.display_matrix(matrix);
	}
}
