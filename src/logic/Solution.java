package logic;

class Solution {
    public static void main(String[] args) {
        System.out.println( incrementString("foobar000") +  " Correct answer = foobar001");
        System.out.println( incrementString("foo") +  " Correct answer = foo1");
        System.out.println( incrementString("foobar001") +  " Correct answer = foobar002");
        System.out.println( incrementString("foobar99") +  " Correct answer = foobar100");
        System.out.println( incrementString("foobar099") +  " Correct answer = foobar100");
        System.out.println( incrementString("") +  " Correct answer = 1");
        System.out.println( incrementString("foobar000") +  " Correct answer = foobar001");




    }

    //Who likes it
    public static String whoLikesIt(String... names) {
        //Do your magic here
        switch (names.length){
            case 0:
                return "no one likes this";
            case 1:
                return names[0] +" likes this";
            case 2:
                return names[0] + " and " + names[1] + " like this";
            case 3:
                return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default:
                return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        }
    }

    //Valid Parentheses
    public static boolean validParentheses(String parens) {
        if( parens.contains("(") || parens.contains(")") ){
            int open = parens.indexOf("(");
            int close =  parens.indexOf(")");

            if( open > close || open < 0 || close < 0){
                return false;
            } else {

                String temp = parens.replaceFirst("\\)","").replaceFirst("\\(", "");

                if(validParentheses(temp)){
                    return true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static String incrementString(String str) {
        String temp = "";
        String leadingZeroes = "";


       for(int i = str.length() -1; i > -1; i--){
           try{
               int tempInt = Integer.parseInt(String.valueOf(str.charAt(i)));
               temp = String.valueOf(str.charAt(i)).concat(temp);
           } catch (NumberFormatException e){
               break;
           }
       }
        if(temp.length() == 0){
            return str + "1";
        }


       for(char c : temp.toCharArray()){
           if(c == '0'){
               leadingZeroes += "0";
           } else {
               break;
           }
       }
        int numberToIncrement = 0;
       try {
           numberToIncrement = Integer.parseInt(temp.substring(leadingZeroes.length()));
       } catch (NumberFormatException e){
           numberToIncrement = 0;
       }
       String incrementedNumber = String.valueOf(++numberToIncrement);

        String letters = str.substring(0, str.length() - temp.length());

        if(leadingZeroes.length() + incrementedNumber.length() == temp.length()){
           return letters.concat(leadingZeroes).concat(incrementedNumber);
       }else {
           return leadingZeroes.length() > 0
                   ? letters.concat(leadingZeroes.substring(1)).concat(incrementedNumber)
                   : letters.concat(incrementedNumber);
       }
    }
}