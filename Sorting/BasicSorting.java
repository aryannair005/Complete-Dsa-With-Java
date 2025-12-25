public class BasicSorting{
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    //Bubble sort := Time complexity :- O(n^2) 
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        printArr(arr);
    }
    //Selection sort := Time complexity :- O(n^2)
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minPos]){
                    minPos=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minPos];
            arr[minPos]=temp;
        }
        printArr(arr);
    }
    //Insertion sort := Time complexity :- O(n^2)
    public static void insertionSort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev >=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
        printArr(arr);
    }
    //Counting sort := Time complexity :- O(n^2) && Space complexity :- O(n)
    public static void countingSort(int[] arr){
        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int[] countArr=new int[max+1];
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<countArr.length;i++){
            while(countArr[i]>0){
                arr[j]=i;
                j++;
                countArr[i]--;
            }
        }
        printArr(arr);
    }

    public static void main(String[] args){
        int[] arr={5,4,1,3,2};
        countingSort(arr);
    }
}