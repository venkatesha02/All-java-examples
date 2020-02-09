import java.util.Scanner;

public class Main {

	static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println("Bubble Sort Elements ");
	}

	
	// Merges two subarrays of arr[].
	static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	static void sort1(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort1(arr, l, m);
			sort1(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
			
			for (int i = 0; i < arr.length; ++i) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("Merge Sort Elements ");
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of  the array");
		int a = sc.nextInt();
		int arr[] = new int[a];
		System.out.println("Enter the " + a + " elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

		}
		bubbleSort(arr);
		
		System.out.println("-----------------------------");

		sort1(arr, 0, arr.length - 1);
		System.out.println("-----------------------------");


	}

}
