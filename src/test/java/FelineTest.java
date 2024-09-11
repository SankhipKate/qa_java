import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Animal animal;
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline(animal); // Предполагаем, что Feline может принимать Animal как параметр
    }

    //Тестирование метода eatMeat
    @Test
    public void testEatMeat_ReturnsCorrectFoodList() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(animal.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline.eatMeat();
        verify(animal).getFood("Хищник");
        assertEquals(expected, actual);
    }

    //тестирование обработки исключений
    @Test(expected = Exception.class)
    public void testEatMeat_ThrowsException() throws Exception {
        when(animal.getFood("Хищник")).thenThrow(new Exception("Test exception"));
        feline.eatMeat(); // Этот вызов должен привести к выбросу исключения
    }


    //Тестирование метода getFamily
    @Test
    public void testGetFamily_ReturnsFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    //Тестирование метода getKittens без параметров
    @Test
    public void testGetKittens_NoParameters_ReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    //Тестирование метода getKittens с параметрами
    @Test
    public void testGetKittens_WithParameter_ReturnsCorrectCount() {
        int kittensCount = 5;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }


}

