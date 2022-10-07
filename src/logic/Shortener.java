package logic;

import java.util.HashMap;
import java.util.TreeMap;

public class Shortener {
    HashMap<String, String> database = new HashMap<>();
    public String urlShortener( String longURL ) {
        StringBuilder shortURL = new StringBuilder("short.ly/");
        String sumStr = String.valueOf(hashFunction(longURL));

        for(int i = 0; i < sumStr.length() - 1; i += 2){
            int temp = Integer.parseInt(sumStr.substring(i, i + 2));
            while(temp < 97 || temp > 122){
                if(temp < 2){
                    continue;
                } else if( temp < 97 ){
                    temp = (int) (temp / 0.6);
                }else {
                    temp = (int) (temp * 0.8);
                }
            }
            shortURL.append( (char)temp);
        }


        // check if the value already exists
        if( !database.containsKey(shortURL.toString()) ) {
            database.put(shortURL.toString(), longURL);
        }

        return shortURL.toString();
    }
    public String urlRedirector(String shortURL) {

       // return longURL;
        return database.get(shortURL);
    }
    private long hashFunction(String longURL){
        long rez = Math.abs(longURL.hashCode());
        rez = Long.parseLong(String.valueOf(rez).substring(0,8));

        return rez;
    }
    private String incrementKey(String in){

    }
}
