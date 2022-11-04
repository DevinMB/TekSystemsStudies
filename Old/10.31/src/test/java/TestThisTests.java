import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestThisTests {

    @Test
    public void testGetNameAtIndex() {
      //given
        TestThis tt = new TestThis();

      //when
        int input = 0;
        String expected = "Mike";

      //then
        Assertions.assertEquals(tt.getNameAtIndex(input),expected);

    }


    @Test
    public void testGetNameAtIndex2() {
        //given
        TestThis tt = new TestThis();

        //when
        int input = 2;
        String expected = "Tony";

        //then
        Assertions.assertEquals(tt.getNameAtIndex(input),expected);

    }



}
