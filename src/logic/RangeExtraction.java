package logic;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        String result = "";
        int lowValue = 0;
        int highValue = 0;

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                lowValue = arr[i];

            }
        }

        return "";
    }
    private String valuesToRange(int low, int high){
        return String.valueOf(low) + "-" + String.valueOf(high);
    }
}
