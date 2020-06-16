package Testador;

public class Heapsort {
 
	    public static void Sort(Comparable[] arr){
	        Comparable[] tp = new Comparable[arr.length+1];
	        for(int i = 0; i < arr.length; i ++){
	            tp[i+1] = arr[i];
	        }

	        heapSort(tp);

	        for (int i  = 0; i < arr.length; i ++)
	            arr[i] = tp[i+1];
	    }

	    
	    private static void heapSort(Comparable[] arr){
	        heapify(arr);
	        for (int i = arr.length - 1; i >= 1; i --){
	            exch(arr, 1, i);
	            sink(arr,1, i-1);
	        }
	    }

	    private static void heapify(Comparable[] arr){
	        int size = arr.length - 1;
	        for(int i = size / 2; i >= 1; i --){
	            sink(arr,i, size);
	        }
	    }

	    private static void sink(Comparable[] arr, int k,int size){
	        while (2*k <= size){
	            int j = 2 * k;
	            if (j < size && less(arr[j+1], arr[j])) j = j + 1;
	            if (less(arr[j], arr[k])) exch(arr, j,k);
	            k = j;
	        }
	    }

	    private static boolean less(Comparable m, Comparable n){
	        if (m.compareTo(n) < 0)
	            return true;
	        return false;
	    }

	    private static void exch(Comparable[] arr, int m, int n){
	        Comparable tp = arr[m];
	        arr[m] = arr[n];
	        arr[n] = tp;
	    }
	
	    //teste
	  /*  public static void main(String[] args) {
	        Integer[] arr = {12,45,3,22,8};
	        /*for (int i = 0; i < arr.length; i ++){
	        System.out.print(arr[i]+" ");
	        }
	        System.out.println();
	        Sort(arr);
	        for (int i = 0; i < arr.length; i ++){
	        System.out.print(arr[i]+" ");
	        }*/
	    //}
}
