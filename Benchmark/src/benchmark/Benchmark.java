package benchmark;

import java.util.Random;

public class Benchmark
{
    
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        long endTime;
        int arr[] = new int[10000];
        int arr2[] = new int[10000];
        int arr3[] = new int[10000];
        Random rand = new Random();
        
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(50)+1;
            arr2[i] = rand.nextInt(50)+1;
            arr3[i] = arr2[i] / arr[i];
            arr3[i] = arr2[i] + arr[i];
            arr3[i] = arr2[i] - arr[i];
            arr3[i] = arr2[i] * arr[i];
        }
        
        printArray(arr3);
        System.out.println("------------------------------------------------"
                         + "\nSorting Array..."
                         + "\n------------------------------------------------");
        sort(arr3, 0, 9999);
        printArray(arr3);
        
        endTime = System.currentTimeMillis();
        
        System.out.println("\nBenchmark Runtime: " + (endTime - startTime) + " Milliseconds.");
    }
    
    public static void printArray(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(i==0)
            {
                if(arr[i] >= 0 && arr[i] <= 9)
                    System.out.print(arr[i] + "    ");
                else if(arr[i] >= 10 && arr[i] <= 99)
                    System.out.print(arr[i] + "   ");
                else if(arr[i] >= 100 && arr[i] <= 999)
                    System.out.print(arr[i] + "  ");
            }
            else if(i==0 || (i+1)%10 == 0)
            {
                if(arr[i] >= 0 && arr[i] <= 9)
                    System.out.println(arr[i] + "    ");
                else if(arr[i] >= 10 && arr[i] <= 99)
                    System.out.println(arr[i] + "   ");
                else if(arr[i] >= 100 && arr[i] <= 999)
                    System.out.println(arr[i] + "  ");
            }
            else if(arr[i] >= 0 && arr[i] <= 9)
                System.out.print(arr[i] + "    ");
            else if(arr[i] >= 10 && arr[i] <= 99)
                System.out.print(arr[i] + "   ");
            else if(arr[i] >= 100 && arr[i] <= 999)
                System.out.print(arr[i] + "  ");
        }
    }
    
    public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high]; 
	int i = (low-1);
	for (int j=low; j<high; j++) 
	{ 
            if (arr[j] <= pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
	} 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        
        return i+1; 
    } 
    
    public static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high); 
        } 
    }

}
