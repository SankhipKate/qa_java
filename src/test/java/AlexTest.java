import com.example.Alex;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {
    private Alex alex;
    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(feline); // Инициализация Алекса с моком Feline
    }

    @Test
    public void getKittens_ReturnsZero() {
        assertEquals("Alex should have 0 kittens", 0, alex.getKittens());
    }

    @Test
    public void getFriends_ReturnsListOfFriends() {
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals("Alex's friends list should include Marty, Gloria, and Melman", expectedFriends, alex.getFriends());
    }

    @Test
    public void getPlaceOfLiving_ReturnsNewYorkZoo() {
        assertEquals("Alex should live in the New York Zoo", "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

}
