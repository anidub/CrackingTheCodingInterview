package ArraysandString;

public class efwd {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int n = 2;
		int[] newarr = new int[arr.length];
		//int bufferlength = arr.length + n;
		shiftspace(arr,n,arr.length);
		

	}
	
	public static void shiftspace(int[] arr, int n,int l){
		//int[] newarr = new int[arr.length + n];
		
		/*for(int i = 0; i < l; i++){
			arr[(i + n) % (l - 1)] = arr[i];
		}*/
		
		/*for(int i = 0; i < l - n - 1; i++){
			arr[i + n] = arr[i];
		}*/
		
		for(int i = (l - n - 1) ; i >= 0 ; i--){
			//arr[(i + n) % (l - 1 + n )] = arr[i];
			arr[i + n] = arr[i];
			
		}
		
		for(int i = 0; i < n;i++){
			System.out.println(n);
			System.out.println(i);
			System.out.println(l - i - 1);
			System.out.println(arr[i]);
			System.out.println(arr[l - i - 1]);
			arr[i] = arr[l - i - 1];
			
		}
		
		for(int i = 0; i < arr.length; i++)
		System.out.print(arr[i]);
		
		
	}

}
