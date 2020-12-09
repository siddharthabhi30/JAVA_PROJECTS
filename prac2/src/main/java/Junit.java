import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class Junit {
    @Test
    void testMethod1() {
        System.out.println("**--- Test method1 executed ---**");
        String a;
        a="dd";
        a=null;
        assertNotNull(a);
    }

    @DisplayName("Test method2 with condition")
    @Test
    void testMethod2() {
        //lambda fucntion works only when assertion is true
        assumingThat(4==4,
                () -> {
                    assertEquals(120, 10);
                    System.out.println("perform below assertions only on the test env");
                });
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("**--- Executed before each test method in this class ---**");
    }


}
