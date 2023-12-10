package cf.mindaugas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.when;

// @RunWith(PowerMockRunner.class)
// @PrepareForTest(Calculator.class)
class CalculatorTest {
    // @Disabled
    @Test
    public void test_add__when_two_positive_ints_passed__then_sum_is_correct() {
        // given / arrange
        int i = 2;
        int j = 6;

        // when / act
        int res = Calculator.add(i, j);

        // then / assert
        // Assertions.assertEquals(8, res);
        Assertions.assertThat(res).isEqualTo(8);

        // teardown
    }

    @Test
    public void test_add__when_two_negative_ints_passed__then_sum_is_negative_and_correct() {
        // given / arrange
        int i = -2;
        int j = -6;

        // when / act
        int res = Calculator.add(i, j);

        // then / assert
        Assertions.assertThat(res).isEqualTo(-8);

        // teardown
    }

    @Disabled
    @Test
    public void test_mocking_static_methods_with_mockito(){
        // mockito does not support mocking of static methods
        when(Calculator.add(1, 2)).thenReturn(66);
    }

    // @Test
    // public void test_mocking_static_methods_with_powermock(){
    //     mockStatic(Calculator.class);
    //     when(Calculator.add(55, 66)).thenReturn(999);
    //
    //     int res = Calculator.add(55, 66);
    //     org.junit.jupiter.api.Assertions.assertEquals(999, res);
    // }

    @ParameterizedTest(name = "test_add_{index}: {0} + {1} = {2}")
    @CsvSource({
        "2,2,4",
        "0,0,0",
        "-1,55,54",
    })
    public void test_add(
            @ConvertWith(Str2Int.class) int i,
            @ConvertWith(Str2Int.class) int j,
            @ConvertWith(Str2Int.class) int expected){
        // given, when
        int res = Calculator.add(i, j);
        // then
        Assertions.assertThat(res).isEqualTo(expected);
    }
}

class Str2Int extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
        return Integer.parseInt((String) o);
    }
}