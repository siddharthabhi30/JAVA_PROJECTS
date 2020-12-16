package Streams;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Apple{
    private int weight;
    private String name;

    public String getName() {
        return name;
    }

    public Apple(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }
}

public class Stream1 {

    public static void main(String[] args) {
        List<Apple> inventory=new ArrayList<>();
        inventory.add(new Apple("one"));

        //easy sorting using Streams
        inventory.sort(Comparator.comparing(Apple::getWeight));
        List<Apple> heavyApples =
                inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150)
                        .collect(toList());


        System.out.println(heavyApples);
    }
}



interface ApplePredicate<T>{

    String print(T apple);

}

interface ApplePredicate2<T>{

    T print(T apple);

}
interface ApplePredicate3<T>{

    T print(T apple);

}

class CHeck34 implements  ApplePredicate3<String >{

    @Override
    public String print(String apple) {
        return "hello";
    }

}


class check35 implements ApplePredicate3<String>{

    @Override
    public String print(String apple) {
        return "hello2";
    }
}
class PrintWeight implements ApplePredicate<Apple>{


    @Override
    public String print(Apple apple) {
        return apple.getName();
    }
}

class Runner{
    public static void main(String[] args) {

        List<Apple> app=new ArrayList<>();
        app.add(new Apple("one"));
        app.add(new Apple("two"));
        ApplePredicate<Apple> pre=new PrintWeight();
        app.parallelStream().forEach(apple-> {

            System.out.println(  pre.print(apple));
        });

     ApplePredicate2<Integer> appl=(one)->{
         return one;
        };
            //specifying which iterface this lambda is specifying
        ApplePredicate3<Integer> appl2=(ApplePredicate3<Integer>) (one)->{
            return one;
        };

        System.out.println( appl.print(23));

        ApplePredicate3<String> tytr=(a)->"S";

        final int portNumber = 1337;
        //portNum.. should be final
        Runnable r = () -> System.out.println(portNumber);

        List<String> str = Arrays.asList("a","b","A","B");

        //str.sort(String::compareToIgnoreCase);
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));



    }
}

class checkingGenerics<T extends  Integer>{
      List<T> doe(){
          List<Integer> ll=new ArrayList<>();
        return (List<T>) ll;
    }

}
class checkingGenerics2{
   <T extends  String> List<T> doe(){
        List<String> ll=new ArrayList<>();
        return (List<T>) ll;
    }

}


