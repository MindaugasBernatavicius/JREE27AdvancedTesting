package cf.mindaugas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeCalculatorTest {
    @Test
    public void test_getSalaryAverage__when_employees_present__then_average_calculated_successfully(){
        // given
        var mockEmployeeFileManager = mock(EmployeeFileManager.class);
        when(mockEmployeeFileManager.getEmployees()).thenReturn(new ArrayList<>(){{
            add(new Employee("Mindaugas", 100.0));
            add(new Employee("John", 220.0));
        }});
        var employeeCalculator = new EmployeeCalculator(mockEmployeeFileManager);

        // when
        var res = employeeCalculator.getSalaryAverage();

        // then
        Assertions.assertEquals(160.0, res);
        verify(mockEmployeeFileManager, times(1)).getEmployees();
    }

    @Test
    public void test_getSalaryAverage__when_no_employees__then_nan_returned(){
        var mockEmployeeFileManager = mock(EmployeeFileManager.class);
        when(mockEmployeeFileManager.getEmployees()).thenReturn(new ArrayList<>());
        var employeeCalculator = new EmployeeCalculator(mockEmployeeFileManager);
        var filePathCaptor = ArgumentCaptor.forClass(String.class);

        var res = employeeCalculator.getSalaryAverage();

        verify(mockEmployeeFileManager, times(1)).getEmployees();
        verify(mockEmployeeFileManager, times(1)).readFile(filePathCaptor.capture());
        verifyNoMoreInteractions(mockEmployeeFileManager);

        Assertions.assertEquals(Double.NaN, res);
        Assertions.assertEquals("../likethis", filePathCaptor.getValue());
    }
}
