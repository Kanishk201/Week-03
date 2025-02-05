package stringbuilder.reversestring;

import org.junit.Assert;
import org.junit.Test;


public class ReverseStringTest {

    @Test
     public void reverseStringTest(){
        Assert.assertEquals("sinak", ReverseString.reverse("kanis"));
    }
}
