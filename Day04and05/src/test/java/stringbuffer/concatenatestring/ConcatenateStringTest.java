package stringbuffer.concatenatestring;

import org.junit.Assert;
import org.junit.Test;

public class ConcatenateStringTest {

    @Test

    public void concatenateString(){
        String[] input = {"Hello", " ", "World"};
        String result = ConcatenateStrings.concatenateStrings(input);
        Assert.assertEquals("Hello World", result);
    }
}
