package finance.testsEntities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import finance.entities.Financing;

public class FinancingTests {

    @Test
    public void constructorShouldCriateWhenInsertDataIsCorrect() {
        Financing fin = new Financing(100000d, 2000d, 80);

        Assertions.assertEquals(fin.getIncome(), 2000d);
        Assertions.assertEquals(fin.getTotalAmount(), 100000d);
        Assertions.assertEquals(fin.getMonths(), 80);
    }

    @Test
    public void constructorShouldIllegalArgumentWhenInsertDataIsIncorrect() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Financing fin = new Financing(100000d, 2000d, 20);
        });
    }

    @Test
    public void totalAmountShouldUpdateWhenDataIsIncorrect() {
            Financing fin = new Financing(0d, 2000d, 80);
            fin.setTotalAmount(100000d);

            Assertions.assertEquals(100000d, fin.getTotalAmount());
    }

    @Test
    public void totalAmountShouldIllegalArgumentWhenInsertDataIsIncorrect() {
            Financing fin = new Financing(0d, 2000d, 20);

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                fin.setTotalAmount(100000d);
            });
    }

    @Test
    public void totalIncomeShouldUpdateWhenDataIsIncorrect() {
            Financing fin = new Financing(100000d, 2000d, 80);
            fin.setIncome(3000d);

            Assertions.assertEquals(3000d, fin.getIncome());
    }

    @Test
    public void totalIncomeShouldIllegalArgumentWhenInsertDataIsIncorrect() {
            Financing fin = new Financing(100000d, 2000d, 80);

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                fin.setIncome(1500d);
            });
    }

    @Test
    public void monthsShouldUpdateWhenDataIsIncorrect() {
            Financing fin = new Financing(100000d, 2000d, 80);
            fin.setMonths(90);

            Assertions.assertEquals(90, fin.getMonths());
    }

    @Test
    public void monthsShouldIllegalArgumentWhenInsertDataIsIncorrect() {
            Financing fin = new Financing(100000d, 2000d, 80);

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                fin.setMonths(70);
            });
    }

    @Test
    public void entryShouldCalculete20PecentOfEntryValue() {
        Financing fin = new Financing(100000d, 2000d, 80);

        Assertions.assertEquals(20000, fin.entry());
    }

    @Test
    public void quotaShouldCalculateQuotaValue() {
        //(TOTAL - ENTRADA) / MES 96
        Financing fin = new Financing(120000d, 2000d, 96);

        Assertions.assertEquals(1000, fin.quota());
    }
}
