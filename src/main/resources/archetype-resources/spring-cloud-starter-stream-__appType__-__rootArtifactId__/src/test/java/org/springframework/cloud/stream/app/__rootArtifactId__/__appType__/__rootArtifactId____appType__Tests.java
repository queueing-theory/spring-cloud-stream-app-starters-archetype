package ${groupId}.${packagePath};

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
public abstract class ${ccAppName}${ccAppType}Tests {

    public static class Default${ccAppName}${ccAppType}Tests extends ${ccAppName}${ccAppType}Tests {

        @Test
        public void test() throws Exception {

        }

    }

    @SpringBootApplication
    public static class Default${ccAppName}${ccAppType}Application {

    }
}
