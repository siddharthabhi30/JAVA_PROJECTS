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

        assertNotNull(a);
    }

    @DisplayName("Test method2 with condition")
    @Test
    void testMethod2() {
        //lambda fucntion works only when assertion is true
        assumingThat(4==4,
                () -> {
                    assertEquals(10, 10);
                    System.out.println("perform below assertions only on the test env");
                });
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("**--- Executed before each test method in this class ---**");
    }


}

//all methods will be executed
@Nested
class InnerClass {

    @BeforeEach
    void beforeEach() {
        System.out.println("**--- InnerClass :: beforeEach :: Executed before each test method ---**");
    }

    @AfterEach
    void afterEach() {
        System.out.println("**--- InnerClass :: afterEach :: Executed after each test method ---**");
    }

    @Test
    void testMethod1() {
        System.out.println("**--- InnerClass :: testMethod1 :: Executed test method1 ---**");
    }
}