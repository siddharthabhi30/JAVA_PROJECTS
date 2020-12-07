import java.util.ArrayList;
import java.util.List;
class A{
    public List<Integer> l1=new ArrayList<>();
    public static  int test=233;
    static {
        test=99999;
    }
    public int no;

}

class C {
    static <T> void processElements(ArrayList<T> a)
    {
        for (Object element : a)
        {
            System.out.println(element);
        }
    }

    public static void main(String[] args)
    {
        //ArrayList Containing Integers

        ArrayList<Integer> a1 = new ArrayList<>();

        a1.add(10);

        a1.add(20);

        a1.add(30);

        processElements(a1);

        //Arraylist containing strings

        ArrayList<String> a2 = new ArrayList<>();

        a2.add("One");

        a2.add("Two");

        a2.add("Three");

        processElements(a2);
    }
}
class B extends  A{

    public  static <T extends  A> void test(T u){
        System.out.println("no errors");
    }


    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>(); // 1
       // String s = ls.get(0);
        B bb=new B();
        System.out.println(bb.no+"  "+A.test);



    }
}

class check{
    public int same;
    public check(){
        this(23);
        done();

    }
   public  check(int n){
        same=n;
    }

    public int done(){
        return 2;
    }
}
