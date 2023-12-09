package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    private SomeService someService;
    int[] numList;

    @BeforeEach
    void setUp(){
        someService = new SomeService();
        //numList = new int[]{1,2,3,4,5,6};
    }

    // 3.1.

    @Test
    void multipleThreeNotFiveReturnsFizz() {
        SomeService someservice = new SomeService();
        String check = someservice.fizzBuzz(3);

        assertThat(check).isEqualTo("fizz");

        // assertEquals...
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        SomeService someservice = new SomeService();
        String check = someservice.fizzBuzz(5);

        assertThat(check).isEqualTo("buzz");

        // assertEquals...
    }

    @Test
    void multipleFiveorThreeReturnsfizzBuzz() {
        SomeService someservice = new SomeService();
        String check = someservice.fizzBuzz(15);

        assertThat(check).isEqualTo("fizzBuzz");

        // assertEquals...
    }

    @Test
    void multipleNotFiveorThreeReturnsfizzBuzz() {
        SomeService someservice = new SomeService();
        String check = someservice.fizzBuzz(8);

        assertThat(check).isEqualTo("8");


        // assertEquals...
    }

    //3.2

    @Test
    void testArrayCellValue6(){

        boolean result = someService.firstLast6(new int[]{1,2,3,4,5,6});

        assertEquals(true, result);
    }

    @Test
    void testArrayCellValueNot6(){

        boolean result = someService.firstLast6(new int[]{1,2,3,4,5,7});

        assertEquals(false, result);
    }


    @ParameterizedTest
    @CsvSource({"2000, 50, 1000", "2000, 100, 0", "2000, 0, 2000"})
    void insufficientCoverageTest(double amount, int discount, double result) {


        assertThat(someService.calculatingDiscount(amount, discount))
                .isEqualTo(result); // обычная скидка
    }


    @Test
    void insufficientCoverageTest4() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }
    @Test
    void insufficientCoverageTest5() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

}