import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
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
                {"John Cena",   true},
                {" John Cena",  false},
                {"John Cena ",  false},
                {" John Cena ", false},
                {"JohnCena",    false},
                {"John C ena",  false},
                {"JohnCena ",   false},
                {" JohnCena",   false},
                {"JohnCena ",   false},
                {"Benedict superCumberbatch", false},
                {"Benedict Cumberbatch", false},
                {"Benedict Cumberbatc", true},
                {"Benedict Cumberbat", true},
                {"A B", true},
                {"AB", false},
                {"A Ba", true}
        };
    }
    @Test
    public void testCheckNameToEmboss(){
        Account account = new Account(name);
        System.out.println(name);
        assertEquals(result, account.checkNameToEmboss());
    }
}
