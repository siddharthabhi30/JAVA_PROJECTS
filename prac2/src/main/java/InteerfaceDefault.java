public class InteerfaceDefault {


}
interface check23{
    default int see(){
        return  23;
    }

}

class  Oneee implements  check23{

    public static void main(String[] args) {
        Oneee oneee=new Oneee();
        System.out.println(oneee.see());
    }

}