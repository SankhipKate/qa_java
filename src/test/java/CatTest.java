import com.example.Cat;
import com.example.Feline;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;

    // Тестирование метода getSound
    @Test
    public void testGetSound_ReturnsMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    //Тестирование метода getFood
    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Мясо");
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        verify(feline).eatMeat();  // Проверяем, что был вызван метод eatMeat
        assertEquals(expectedFood, actualFood);
    }

    // Тест для проверки обработки исключений методом getFood
    @Test
    public void testGetFood_ThrowsException() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка при получении пищи"));

        // Проверяем, что исключение выбрасывается
        assertThrows(Exception.class, cat::getFood);
    }
}
