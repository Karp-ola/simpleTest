import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class SimpleTest {

    @ParameterizedTest(name = "Проверяем, что {0} меньше 5")
    public void test1(int number){
        Assertions.assertTrue(number < 5);
    }

    @ValueSource(strings = {"one", "two" ,"five", "four"})
    @ParameterizedTest(name = "Проверяем, что количество символов в слове {0} меньше 5")
    public void test2(String number){
        Integer numberOfLetters = number.length();
        step("Проверяем, что количество символов в слове", () ->{
            Assertions.assertTrue(numberOfLetters < 5);
        });
    }
}
