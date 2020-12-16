import java.io.File;

public class FunctionalINterface {
}
interface MyGeneric<T extends Comparable<T>> {
    T compute(T t);
}
class Check implements Comparable<Check>{
    public Check(){

    }




    @Override
    public int compareTo(Check o) {
        return 0;
    }
}
 class LambdaGenericFuncInterfaceTest {
    public static void main(String args[]) {
        MyGeneric<Check> ss=val->{
            return new Check();
        };
        File oldName =
                new File("C:/Users/siddh/Desktop/code/C++/a.cpp");
        File newName =
                new File("C:/Users/siddh/Desktop/code/C++/c.cpp");

        if (oldName.renameTo(newName))
            System.out.println("Renamed successfully");
        else
            System.out.println("Error");






    }
}