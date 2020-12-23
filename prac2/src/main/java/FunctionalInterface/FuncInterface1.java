package FunctionalInterface;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class FuncInterface1 {


}


class  Orange{
    
    public int ref;
    public static String currentFile;
        public static  int times=0;
        public static int timesDire=0;
        static  boolean currentOne;
    public static int timesSentFile=0;
    public Orange(int ref) {
        this.ref = ref;
    }




    static int methRef(String a, Orange myOran){
        return 1;
    }

    int methRef2(String a,Orange myOran){
        return this.ref;
    }

    public static void main(String[] args) {

        Function<BufferedReader, String> f =
                (BufferedReader b) -> {
                    try {
                        return b.readLine();
                    }
                    catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                };
    }



}

@FunctionalInterface
 interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}

interface two{
    int test(String a,Orange o);
}
