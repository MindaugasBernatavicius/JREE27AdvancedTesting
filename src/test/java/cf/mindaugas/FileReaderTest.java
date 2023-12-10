package cf.mindaugas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {
    @Test
    public void test_parse_line__when_valid_alphanumeric_passed__parsing_successful(){
        var fileReader = new FileReader();
        var inputString = "8.55";
        var res = fileReader.parseLine(inputString);
        Assertions.assertThat(res).isEqualTo(8.55);
    }

    @Test
    public void test_parse_line__when_invalid_alphanumeric_passed__exception_is_thrown(){
        // given
        var fileReader = new FileReader();
        var inputString = "abc";

        // then
        assertThrows(
            NumberFormatException.class,
            // when
            () -> fileReader.parseLine(inputString),
            "For input string: \"abc\""
        );
    }
}
