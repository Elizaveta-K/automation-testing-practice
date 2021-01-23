package unitTests.utilsTests.urlBuilderTests.tests;

import infrastructure.utils.TestUrl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlDomainTests {

    @Test
    public void testUrlWithDomain(){
        String url = new TestUrl.Builder()
                .withDomain("mysite.com")
                .build();

        assertEquals("https://mysite.com", url);
    }

    @Test
    public void testUrlWithBlankDomain(){
        String url = new TestUrl.Builder()
                .withDomain("")
                .build();

        assertEquals("https://localhost", url);
    }

    @Test
    public void testUrlWithoutDomain(){
        String url = new TestUrl.Builder()
                .build();

        assertEquals("https://localhost", url);
    }
}
