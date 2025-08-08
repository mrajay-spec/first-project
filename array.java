//Array creation-----------------------------------------------------------------------------------
public class array {
public static void main(String[] args) 
{
    java.util.Scanner sc = new java.util.Scanner(System.in);
    System.out.print("Enter size of array: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter " + n + " elements:");
    for (int i = 0; i < n; i++) 
    {
        arr[i] = sc.nextInt();
    }
    System.out.println("Array elements are:");
    for (int i = 0; i < n; i++) 
    {
        System.out.print(arr[i] + " ");
    }
    //sum of n numbers----------------------------------------------------------
    //System.out.println("sum is:");
    int sum = 0;
    for (int i= 0; i < n; i++)
    {
        sum += arr[i];
    }
    System.out.println("\nsum is: " + sum);
    //finding the largest number------------------------------------------------
    int largest = arr[0];
    for (int i = 1; i < n; i++) 
    {
        if (arr[i] > largest) 
        {
            largest = arr[i];
        }
    }
    System.out.println("Largest number is: " + largest);
    //finding the smallest number------------------------------------------------
    int smallest = arr[0];
    for (int i = 1; i < n; i++) 
    {
        if (arr[i] < smallest) 
        {
            smallest = arr[i];
        }
    }
    System.out.println("Smallest number is: " + smallest);
    sc.close();
}
}

