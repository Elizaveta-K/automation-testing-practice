package unitTests.utilsTests.urlBuilderTests.tests;

import infrastructure.utils.TestUrl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlProtocolTests {

    @Test
    public void testUrlWithProtocol(){
        String url = new TestUrl.Builder()
                .withProtocol("https")
                .build();

        assertEquals("https://localhost", url);
    }

    @Test
    public void testUrlWithBlankProtocol(){
        String url = new TestUrl.Builder()
                .build();

        assertEquals("https://localhost", url);
    }

    @Test
    public void testUrlWithProtocolWithSlashes(){
        String url = new TestUrl.Builder()
                .withProtocol("https://")
                .build();

        assertEquals("https://localhost", url);
    }
}
