package logic;

public class FindOdd {
    public static int findIt(int[] a) {
        for(int number : a){
            int count = 0;
            for(int numberToCheck : a){
                if(number == numberToCheck){
                    count++;
                }
            }
            if (count % 2 != 0){
                return number;
            }
        }
        return 0;
    }
}