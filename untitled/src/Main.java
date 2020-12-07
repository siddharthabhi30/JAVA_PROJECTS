public class Main {
    enum Size {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    static <T extends String> void genericDisplay (T element)
    {
        System.out.println(element.getClass().getName() +
                " = " + element);
    }

    public static void main(String[] args) {
        // instance of Integer type
        Test <Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        Test <String> sObj =
                new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());


        // Calling generic method with String argument
        genericDisplay("GeeksForGeeks");

        // Calling generic method with double argument
        var cc=Size.LARGE;


    }
}
class Test<T>
{
    // An object of type T is declared
    T obj;
    Test(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }
}