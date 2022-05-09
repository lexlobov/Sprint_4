import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@DisplayName("Параметризованный тест-сьют на проверку метода checkNameToEmboss")
public class AccountTest {

    private String name;
    private boolean result;

    public AccountTest(String name, boolean result){
        this.name = name;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][] {
                {"John Cena",                   true},
                {" John Cena",                  false},
                {"John Cena ",                  false},
                {" John Cena ",                 false},
                {"JohnCena",                    false},
                {"John C ena",                  false},
                {"JohnCena ",                   false},
                {" JohnCena",                   false},
                {"Benedict superCumberbatch",   false},
                {"Benedict Cumberbatch",        false},
                {"Benedict Cumberbatc",         true},
                {"Benedict Cumberbat",          true},
                {"A B",                         true},
                {"AB",                          false},
                {"A Ba",                        true}
        };
    }
    @Test
    @DisplayName("Проверка метода с различными входными параметрами")
    @Description("Проверяются:" +
            "позитивный сценарий; " +
            "сценарий с пробелом в началае и посередине; " +
            "сценарий с пробелом в конце; " +
            "сценарий с пробелом в начале, посередине и конце; " +
            "сценарий без пробела; " +
            "сценарий с двумя пробелами посередине; " +
            "сценарий с пробелом в конце без пробела посередине; " +
            "сценарий с пробелом в начале без пробела посередине; " +
            "сценарий с более чем 19 символами; " +
            "сценарий с 20 символами; " +
            "сценрарий с 19 символами; " +
            "сценарий с 18 символами; " +
            "сценарий с 3 символами; " +
            "сценарий с 2 символами; " +
            "сценарий с 4 сиволами. ")
    public void testCheckNameToEmboss(){
        Account account = new Account(name);
        assertEquals(result, account.checkNameToEmboss());
    }
}
