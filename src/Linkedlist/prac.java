package Linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Stack;

//import StacksandQueues.animalshelter.Type;

public class prac {
	static int m = 3;
	static int n = 3;

	

	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,0,3},{4,5,6},{7,8,9}};
		
	}
	
	
public static void display(int[][] matrix){
	for(int i = 0; i < matrix.length; i++){
		for(int j = 0; j < matrix[0].length; j++){
			System.out.print(matrix[i][j] + " ");
		}
		System.out.println();
	}
	
	System.out.println();
	System.out.println();
	System.out.println();
}
	

public boolean solvemaze(int[][] maze, int x, int y){
	int[][] solution = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	
	if(solveUtil(maze,x,y) == false) System.out.println("not found");
	else{
		print(solution);
	}
}

public int result(int[]arr, int[] dep, int n){
	Arrays.sort(arr);
	Arrays.sort(dep);
	int i = 1; 
	int j = 0;
	int minplatform = 1;
	int result = 1;
	while(i < n && j < n){
		if(arr[i] < dep[j]){
			minplatform++;
			i++;
			if(minplatform > result)
				result = minplatform;
		}else{
			j++;
			minplatform--;
		}
	}
}

