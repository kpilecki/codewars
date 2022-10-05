package logic;

public class Snail {
    public static void main(String[] args) {
        int[][] arr =  {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};

        for(int a : snail(arr)){
            System.out.print(a + " ,");
        }
        System.out.println();
        for(int a : r){
            System.out.print(a + " ,");
        }

    }
    public static int[] snail(int[][] array) {
        int[] rez = new int[ array.length * array[0].length];
        int count = 0;
        int i = 0;
        int borderRigth = 0;
        int borderLeft = 0;
        int j = 0;
        int borderTop = 0;
        int borderBottom = 0;
        boolean isHorizontal = true;

        while(count < rez.length) {
            if (isHorizontal) {
                if (i < array[j].length - borderRigth) {
                    i = borderLeft;
                    while (i < array[j].length - borderRigth) {
                        rez[count] = array[j][i];
                        i++;
                        count++;
                    }
                    borderTop++;
                    isHorizontal = false;
                    i--;
                } else {
                    i = array[j].length - 1 - borderRigth;
                    while (i >= borderLeft) {
                        rez[count] = array[j][i];
                        i--;
                        count++;
                    }
                    borderBottom++;
                    isHorizontal = false;
                    i++;
                }
            } else {
                if (j < array.length - borderBottom) {
                    j = borderTop;
                    while (j < array.length - borderBottom) {
                        rez[count] = array[j][i];
                        j++;
                        count++;
                    }
                    borderRigth++;
                    isHorizontal = true;
                    j--;
                } else {
                    j = array.length - borderTop -1;
                    while (j > borderTop - 1) {
                        rez[count] = array[j][i];
                        j--;
                        count++;
                    }
                    borderLeft++;
                    isHorizontal = true;
                    j++;
                }
            }
        }
        return rez;
    }
}