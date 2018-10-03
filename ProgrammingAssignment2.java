import java.util.Random;

public class ProgrammingAssignment2
{
    public static void main(String args[])
    {
        Random randNum = new Random();
        
        for(int randGen = 1; randGen <= 10; randGen++)
        {
            int[] quickArray = new int[100];
        
            for(int i = 0; i < quickArray.length; i++) // Populates the array with the randomly generated numbers
                quickArray[i] = randNum.nextInt(100);
            // Code from comment by Peter Rader on this StackOverflow link (shortened!):
            // https://bit.ly/2jtdSmJ
            
            int bubbleArray[] = new int[quickArray.length]; // Copies contents of quickArray to new array
            // Code from here:
            // https://www.geeksforgeeks.org/array-copy-in-java/
            
            for(int x = 0; x < bubbleArray.length; x++)
                bubbleArray[x] = quickArray[x];
            
            ProgrammingAssignment2.printBubble(bubbleArray); // Prints unsorted array
            ProgrammingAssignment2.bubbleSort(bubbleArray); // Sorts array using bubble sort
            ProgrammingAssignment2.printBubble(bubbleArray); // Prints sorted array
            ProgrammingAssignment2.printQuick(quickArray); // Prints unsorted array
            ProgrammingAssignment2.quickSort(quickArray); // Sorts array using quick sort
            ProgrammingAssignment2.printQuick(quickArray); // Prints sorted array
        }
    }
    
    // Prints array used by bubble sort
    // Print function code from here:
    // https://www.geeksforgeeks.org/bubble-sort/
    public static void printBubble(int[] bubbleArray)
    {
        System.out.println("Bubble Sort");
        int n = bubbleArray.length;
        for(int j = 0; j < n; j++)
            System.out.print(bubbleArray[j] + " ");
        System.out.println();
    }
    
    // Prints array used by quick sort
    public static void printQuick(int[] quickArray)
    {
        System.out.println("Quick Sort");
        int n = quickArray.length;
        for(int j = 0; j < n; j++)
            System.out.print(quickArray[j] + " ");
        System.out.println();
    }
    
    // The code for the quick sort is from the textbook Starting out with Java
    public static void quickSort(int quickArray[])
    {
        doQuickSort(quickArray, 0, quickArray.length - 1);
    }
    
    public static void doQuickSort(int quickArray[], int start, int end)
    {
        int pivotPoint;
        
        if(start < end)
        {
            pivotPoint = partition(quickArray, start, end);
            doQuickSort(quickArray, start, pivotPoint - 1);
            doQuickSort(quickArray, pivotPoint + 1, end);
        }
    }
    
    private static int partition(int quickArray[], int start, int end)
    {
        int pivotValue;
        int endOfLeftList;
        int mid;
        
        mid = (start + end)/2;
        
        swap(quickArray, start, mid);
        
        pivotValue = quickArray[start];
        
        endOfLeftList = start;
        
        for(int scan = start + 1; scan <= end; scan++)
        {
            if(quickArray[scan] < pivotValue)
            {
                endOfLeftList++;
                swap(quickArray, endOfLeftList, scan);
            }
        }
        
        swap(quickArray, start, endOfLeftList);
        
        return endOfLeftList;
    }
    
    private static void swap (int[] quickArray, int a, int b)
    {
        int temp;
        
        temp = quickArray[a];
        quickArray[a] = quickArray[b];
        quickArray[b] = temp;
    }

    // The code for the bubble sort is from the textbook Starting out with Java
    public static void bubbleSort(int[] bubbleArray)
    {
        int lastPos;
        int index;
        int temp;
        int compBubble = 0; // Counts comparisons made by bubble sort
        // Comparison count code from here:
        // http://www.cs.toronto.edu/~hojjat/108w07/lectures/mar26/Sort.java
        
        for(lastPos = bubbleArray.length - 1; lastPos >= 0; lastPos--)
        {
            for(index = 0; index <= lastPos - 1; index++)
            {
                compBubble++;
                
                if(bubbleArray[index] > bubbleArray[index + 1])
                {
                    temp = bubbleArray[index];
                    bubbleArray[index] = bubbleArray[index + 1];
                    bubbleArray[index + 1] = temp;
                }
            }
        }
        
        System.out.println("Comparisons: " + compBubble);
    }
}
