package unitTests.utilsTests.urlBuilderTests.tests;

import infrastructure.utils.TestUrl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlPathTests {

    @Test
    public void testUrlWithPath(){
        String url = new TestUrl.Builder()
                .withPath("/users")
                .build();

        assertEquals("https://localhost/users", url);
    }

    @Test
    public void testUrlWithPathWithoutSlash(){
        String url = new TestUrl.Builder()
                .withPath("users")
                .build();

        assertEquals("https://localhost/users", url);
    }
}
