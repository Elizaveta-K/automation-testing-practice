package unitTests.utilsTests.urlBuilderTests.tests;

import infrastructure.utils.TestUrl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlPortTests {

    @Test
    public void testUrlWithPort(){
        String url = new TestUrl.Builder()
                .withPort("8080")
                .build();

        assertEquals("https://localhost:8080", url);
    }

    @Test
    public void testUrlWithEmptyPort(){
        String url = new TestUrl.Builder()
                .withPort("")
                .build();

        assertEquals("https://localhost", url);
    }

    @Test
    public void testUrlWithBlankPort(){
        String url = new TestUrl.Builder()
                .build();

        assertEquals("https://localhost", url);
    }
}
