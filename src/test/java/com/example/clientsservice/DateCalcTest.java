package com.example.clientsservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class DateCalcTest {
    @Test
    void test(){
        LocalDate birth = LocalDate.of(1990,12,23);
        LocalDate now = LocalDate.now();
        LocalDate years = now.minus(birth.getYear(), ChronoUnit.YEARS);
        System.out.println(years.getYear());
        Period period = Period.between(birth, now);
        System.out.println(period.getYears());
    }
    @Test
    void clientDateSave() {

    }
}
