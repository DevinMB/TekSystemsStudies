import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;

public class MyTests {

    private final MyClass calculator = new MyClass();

    @BeforeAll
    public void beforeAll() {
        System.out.println("beforeAll/beforeClass Finished ");
    }





        @Test
        void additionTest() {
            System.out.println("Test started");
            assertEquals(57, calculator.add(1, 1));
            System.out.println("Test Finished");
        }

}