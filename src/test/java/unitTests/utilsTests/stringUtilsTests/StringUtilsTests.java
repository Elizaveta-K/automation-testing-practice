package unitTests.utilsTests.stringUtilsTests;

import infrastructure.utils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringUtilsTests extends StringUtils {

    private final int stringLength = 10;

    @Test
    public void testAlphaMode(){
        String alpaString = StringUtils.randomString(Mode.ALPHA, stringLength);

        assertTrue(alpaString.matches("[a-z]{"+stringLength+"}"));
    }

    @Test
    public void testNumericMode(){
        String numericString = StringUtils.randomString(Mode.NUMERIC, stringLength);

        assertTrue(numericString.matches("[0-9]{"+stringLength+"}"));
    }

    @Test
    public void testAlphaNumeric(){
        String alphaNumericString = StringUtils.randomString(Mode.ALPHANUMERIC, stringLength);

        assertTrue(alphaNumericString.matches("[a-z0-9]{"+stringLength+"}"));
    }
}
