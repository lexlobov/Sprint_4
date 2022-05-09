import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@DisplayName("Параметризованный тест-сьют на проверку метода checkNameToEmboss")
public class AccountPositiveTest {

    private String name;
    private boolean result;

    public AccountPositiveTest(String name, boolean result){
        this.name = name;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][] {
                {"John Cena",                   true},
                {"Benedict Cumberbatc",         true},
                {"Benedict Cumberbat",          true},
                {"A B",                         true},
                {"A Ba",                        true}
        };
    }
    @Test
    @DisplayName("Проверка метода с различными входными параметрами")
    @Description("Проверяются:" +
            "позитивный сценарий; " +
            "сценрарий с 19 символами; " +
            "сценарий с 18 символами; " +
            "сценарий с 3 символами; " +
            "сценарий с 4 сиволами. ")
    public void testCheckNameToEmboss(){
        Account account = new Account(name);
        assertEquals(result, account.checkNameToEmboss());
    }
}
