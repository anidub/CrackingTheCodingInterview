package ArraysandString;

public class rotatematrix90 {

	public static void main(String[] args){
		
		int matrix[][] = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		for(int i = 0; i < matrix.length;i++){
			for(int j = 0 ; j < matrix[0].length;j++){
				
		System.out.print(matrix[i][j]+ " ");
		
			}
			System.out.println();
		}
		
		System.out.println();
		rotate(matrix);
		for(int i = 0; i < matrix.length;i++){
			for(int j = 0 ; j < matrix[0].length;j++){
				
		System.out.print(matrix[i][j]+ " ");
		
			}
			System.out.println();
		}
		
		
		
	}
	/*Array of Arrays
	public static void main(String[] args) {
	    int[][] aMatrix = new int[4][];

	    // populate matrix
	    for (int i = 0; i < aMatrix.length; i++) {
	      aMatrix[i] = new int[5]; // create sub-array
	      for (int j = 0; j < aMatrix[i].length; j++) {
	        aMatrix[i][j] = i + j;
	      }
	    }
	*/
	public static void rotate(int matrix[][]){  // n * n
		int l = matrix.length;
		System.out.println(l);
		for(int i = 0; i < l/2; i++){   
			for(int j = i; j < l-i-1; j++){   // l -i -1 = last
				//for -90 
				/*
				int t = matrix[i][j];
				
				matrix[i][j] = matrix[j][l-i-1];
				
				matrix[j][l-i-1] = matrix[l-i-1][l-j-1];
				
				matrix[l-i-1][l-j-1]=matrix[l-j-1][i];
				
				matrix[l-j-1][i]=t;
				*/
				//for +90
				int t = matrix[i][j];
				
				matrix[i][j] = matrix[l-j-1][i]; // if +90 j will come with L
				
				matrix[l-j-1][i] = matrix[l-i-1][l-j-1];
				
				matrix[l-i-1][l-j-1] = matrix[j][l-i-1];
				
				matrix[j][l-i-1] = t;
			}
		}
			
	}
	//for m * n  /https://www.careercup.com/question?id=5667482614366208
/*	int [][] rotate(int [][] input){

		int n =input.length();
		int m = input[0].length();
		int [][] output = new int [m][n];

		for (int i=0; i<n; i++)
			for (int j=0;j<m; j++)
				output [j][n-1-i] = input[i][j];
		return output;
		}*/
}
