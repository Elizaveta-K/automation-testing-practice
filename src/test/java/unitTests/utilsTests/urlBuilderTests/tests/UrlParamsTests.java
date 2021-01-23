package unitTests.utilsTests.urlBuilderTests.tests;

import infrastructure.utils.TestUrl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class UrlParamsTests {

    private HashMap<String, String> params;

    @Before
    public void before(){
        params  = new HashMap<>();
    }

    @Test
    public void testParamWithKeyValue(){
        params.put("debug", "true");

        String url = new TestUrl.Builder()
                .withParams(params)
                .build();

        assertEquals("https://localhost?debug=true&", url);
    }

    @Test
    public void testParamWithoutValue(){
        params.put("debug", "");

        String url = new TestUrl.Builder()
                .withParams(params)
                .build();

        assertEquals("https://localhost?debug&", url);
    }

    @Test
    public void testStringParam(){

        String url = new TestUrl.Builder()
                .withParams("StringParams=test")
                .build();

        assertEquals("https://localhost?StringParams=test&", url);

    }
}
