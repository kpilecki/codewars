package logic;

public class SpinWords {

    public String spinWords(String sentence) {
        //TODO: Code stuff here
        String temp = "";
        for(String word : sentence.split(" ")){

            if(word.length() < 5){
                temp = temp.concat(word).concat(" ");
            } else {
                temp = temp.concat(reverseString(word)).concat(" ");
            }

        }
        return temp.trim();
    }

    public String reverseString(String in){
        String temp = "";

        for(char c : in.toCharArray()){
            temp = String.valueOf(c).concat(temp);
        }
        return temp;
    }
}