package com.recursion;

/**
 * @author NaveenWodeyar
 * @date 19-Jul-2025
 */

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("Binary serarch");
		int arr[] = {0,2,4,6,8};
		int target = 8;
		System.out.println(search(arr,0,arr.length - 1,target));
	}
	
	static int search(int arr[], int s, int e, int target) {
		
		if (s > e) {
			return -1;
		}
		
		int mid = s + (e-s)/2;
		
		if (arr[mid] == target) {
			return mid;
		}
		
		if (target < arr[mid]) {
			return search(arr, s, mid-1,target);
		}
		
		return search(arr, s+1,e,target);
			}
}
