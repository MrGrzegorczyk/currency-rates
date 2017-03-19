package pl.marcing;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Marcin on 2017-03-02.
 */
public class CurrencyRatesTest {
    @Test
    @Ignore
    public void getRate() throws Exception {
        CurrencyRates cr = new CurrencyRates("USD", 4.10);
        Double current = cr.getRate();
        System.out.println("Current rate is: "+ current);
    }
}