package binarysearch.peakelementinarray;

public class PeakElement {
    public static int findPeakElement(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right-left) / 2;

            if((arr[mid] > arr[mid-1]) && (arr[mid] > arr[mid+1])){
                return arr[mid];
            }
            else if(arr[mid] > arr[mid-1]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return arr[left];
    }
}
