//https://www.programiz.com/java-programming/enums

import java.awt.*;

//enum
public class MainEnum {

    public  static String  check(int n){
        return  null;
    }
    public static void main(String[] args) {
        String s="ddddd";

      char c='d';
      if(c==23){
          System.out.println("comnparison wirks");
      }
        System.out.println("ss");
       String tmp = String.valueOf(-2016);
        System.out.println(tmp);

        Integer[]  ss=new Integer[10];
        System.out.println(ss[3]);

        String aa=null;
        Size pizzaSize=Size.SMALL;

            switch (pizzaSize) {
                case SMALL:
                    System.out.println("I ordered a small size pizza.");
                    break;
                case MEDIUM:
                    System.out.println("I ordered a medium size pizza.");
                    break;
                default:
                    System.out.println("I don't know which one to order.");
                    break;
            }




    }
}
// Enum types can have only private constructors.
 enum check{
    ONE("omne"),
    TWO("sss");

    check(String sss) {
    }

     public static void main(String[] args) {
         check cchch=check.ONE;
     }
}
enum Size{
    SMALL, MEDIUM, LARGE, EXTRALARGE;

    public String getSize() {

        // this will refer to the object SMALL
        switch(this) {
            case SMALL:
                return "small";

            case MEDIUM:
                return "medium";

            case LARGE:
                return "large";

            case EXTRALARGE:
                return "extra large";

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        // call getSize()
        // using the object SMALL
        System.out.println(Size.SMALL);
        System.out.println("The size of the pizza is " + Size.SMALL.getSize());
        System.out.println(check.ONE);

    }
}
enum Enums
{
    A("one"), B("two"), C("three");

    private String name;
    private String name2;

    private Enums(String val)
    {
       this.name2=val;
        System.out.println(1);
    }

    public static void main(String[] args) {
        Enums take1=Enums.A;
        System.out.println(take1.name2);
    }
}

class MainClass
{
    private  int test;
    static {
        System.out.println("something in the way");
    }

    {
       this.test=233;
    }
    public static void main(String[] args)
    {
        Enum en = Enums.B;

        MainClass mainClass=new MainClass();
        System.out.println(mainClass.test);
    }
}