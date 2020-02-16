package Sortings;

public class CountingSort {
    void sort(int arr[])
    {
        int n = arr.length;

        // The output intacter array that will have sorted arr 
        int output[] = new int[n];

        // Create a count array to store count of inidividul 
        // integers and initialize count array as 0 
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;

        // store count of each intacter 
        for(int i=0; i<n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual 
        // position of this intacter in output array 
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];

        // Build the output intacter array 
        // To make it stable we are operating in reverse order. 
        for (int i = n-1; i>=0; i--)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now 
        // contains sorted integers 
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }

    // Driver method 
    void printArray(int Arr[]){
        System.out.print("Counting Sort: ");
        int n = Arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(Arr[i] + " ");
        System.out.println();
    }
}
