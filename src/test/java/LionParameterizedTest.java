import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String inputSex;
    private final boolean expectedMane;

    @Mock
    private Feline feline;

    public LionParameterizedTest(String inputSex, boolean expectedMane) {
        this.inputSex = inputSex;
        this.expectedMane = expectedMane;
    }

    @Before
    public void setUp() {
        // Инициализация моков с помощью Mockito
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {
            Lion lion = new Lion(inputSex, feline);
            assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void testInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("Неизвестно" , feline));
    }
}
