import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class UITests {

    @BeforeAll
    public static void setUp(){
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "120.0");
    }

    @Test
    public void test(){
        open("https://mvnrepository.com/");
    }
}
