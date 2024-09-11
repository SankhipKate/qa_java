import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    private Lion lion;


    @Test
    public void getKittens_ReturnsCorrectNumber() throws Exception {
        lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens(); // Проверяем, что вызов был произведен
    }

    @Test
    public void getFood_ReturnsCorrectFood() throws Exception {
        lion = new Lion("Самец", feline);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(feline).getFood("Хищник"); // Проверяем, что вызов был произведен с нужным аргументом
    }
}
