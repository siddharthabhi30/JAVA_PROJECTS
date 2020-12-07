package test2;

import test1.One;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Two extends  One{
    final int ee=23;
    int check(){
        return super.aa;
    }

    public static void main(String[] args) {
        Test5 ttt=new Test5();
        Two tttwt=new Two();

    }


}


 final class  Test5{
    int cc=322;
}

interface  test7{
    public int namee1();

   default int onsse(){
    return 1;
   }
}

interface  test12{

    public int namee();
}
interface  test8 extends  test7{
    int shame=232;

}

class test9 implements  test8,test12{

    @Override
    public int namee() {
        return shame;
    }


    @Override
    public int namee1() {
        return 0;
    }
}
class test10 extends test9{

}

class test19<TT>{
  static   void take( ) throws Exception {
        try{
            int a=0;
            int v=12/a;

        }
        catch (Exception e){
            System.out.println("therer was");
            throw new Exception("ss");
        }

    }

    public static void main(String[] args) throws Exception {
        Map<String, Integer> treasures = new HashMap<>();
        treasures.put("beach", 25);
        Integer result = treasures.putIfAbsent("beach", 75);
        System.out.println(result);
        int cc=23;
        System.out.println("sid"+cc);
        test19.take();




    }

}