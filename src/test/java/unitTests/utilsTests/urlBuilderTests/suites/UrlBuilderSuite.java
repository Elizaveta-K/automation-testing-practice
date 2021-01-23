package unitTests.utilsTests.urlBuilderTests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import unitTests.utilsTests.urlBuilderTests.tests.*;

@Suite.SuiteClasses({
        UrlProtocolTests.class,
        UrlDomainTests.class,
        UrlPortTests.class,
        UrlPathTests.class,
        UrlParamsTests.class
})

@RunWith(Suite.class)
public class UrlBuilderSuite {
}
