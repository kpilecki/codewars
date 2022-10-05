package logic;

public class DRoot {
    public static int digital_root(int n) {
        if(n > 0){
            int temp = n - ((n / 10) * 10) + digital_root(n / 10);
            if(temp > 9){
                return temp - ((temp / 10) * 10) + digital_root(temp / 10);
            } else {
                return temp;
            }
        }
        return 0;
        // ...
    }
}