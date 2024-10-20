import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class UITests {

    @BeforeAll
    public static void setUp(){
      Configuration.browser = System.getProperty("browser", "chrome");
     // Configuration.headless = true;
    }

    @Test
    public void test(){
        open("https://mvnrepository.com/");
        Selenide.sleep(6000);
    }
}
