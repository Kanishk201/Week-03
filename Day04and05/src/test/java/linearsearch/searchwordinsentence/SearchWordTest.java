package linearsearch.searchwordinsentence;

import org.junit.Assert;
import org.junit.Test;

public class SearchWordTest {

    @Test

    public void searchWordInSentence(){
        String[] sentences = {"I am Kanishk Yadav", "I am from Seoni Malwa", "I study in Technocrarts"};
        String word = "Kanishk";
        Assert.assertEquals("I am Kanishk Yadav", LinearSearchSentence.searchWordInSentences(sentences, word));
    }
}
