import org.example.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = true;
        long expected = 50;  // бонус 5% от 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 1000;  // бонус ограничен лимитом 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    // Добавленные тесты

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = false;
        long expected = 10;  // бонус 1% от 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 1000;  // бонус ограничен лимитом 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}