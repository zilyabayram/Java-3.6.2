package ru.netology.bonus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'registered user, bonus under limit',1000,true,30",
                    "'registered user, bonus over limit',100000060,true,500"
            }
    )
    void shouldCalculateForRegistered(String text, long amount, boolean registered, long expected) {
        BonusService service = new BonusService();

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvFileSource (files = "src/test/resources/data.csv")

    void shouldCalculateForNotRegistered(long amount, boolean registered, long expected) {
        BonusService service = new BonusService();

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}
