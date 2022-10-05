package logic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CodeWars {
    public static void main(String[] args) {


    }

    public static void countAs() {
        try {
            System.out.println("This program counts the number of times the vowel 'a' appears.");
            System.out.print("Please type a sentence that ends with '.': ");

            AtomicInteger count = new AtomicInteger();
            Stream<Character> input = (Stream<Character>) System.in;
            input.forEach(character -> {
                if(character == 'a' || character == 'A'){
                    count.addAndGet(1);
                }
                else if(character == '.')
                {
                    System.out.println(count);
                    return;
                }
            });



            System.out.println("There are " + count + " 'a'.");

        } catch (Exception e) {
            System.out.println("Error");

        }
    }
}


