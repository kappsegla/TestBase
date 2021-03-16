package roman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {
    @ParameterizedTest
    @CsvSource({"I,1","V,5","X,10","L,50","C,100","D,500",
            "M,1000","IV,4","VI,6","'',0"})
    void concertedNumberTest(String str, int expected) {
        RomanNumeral romanNumeral = new RomanNumeral();
        var actual = romanNumeral.convert(str);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/tasks.csv")
    void concertedNumberTest2(String str, int expected) {
        RomanNumeral romanNumeral = new RomanNumeral();
        var actual = romanNumeral.convert(str);
        assertEquals(expected, actual);
    }
}