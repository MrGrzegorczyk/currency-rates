package pl.marcing;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class CurrencyRates {

    private static final long TEN_MINUTES = 10 * 60 * 1000;

    private double rateThreshold;
    private String currency;

    public CurrencyRates(String currency, double rateThreshold) {
        this.rateThreshold = rateThreshold;
        this.currency = currency;
    }

    public void run() throws InterruptedException, IOException {
        double currentRate = rateThreshold - 1; // less than the rateThreshold
        long start;
        long end;

        while (currentRate < rateThreshold) {
            start = System.currentTimeMillis();
            currentRate = getRate();
            if (currentRate >= rateThreshold) {
                alert(currentRate);
            } else {
                end = System.currentTimeMillis();
                Thread.sleep(TEN_MINUTES - (end - start));
            }
        }
    }

    private void alert(double rate) {
        System.out.println("Alarm " + rate);
    }

    public double getRate() throws IOException {
        String url= "http://quote.yahoo.com/d/quotes.csv?s="+currency+ "PLN=X&f=l1&e=.csv";

        InputStream in = new URL( url ).openStream();
        try {
            String io =IOUtils.toString( in );
            return Float.parseFloat(io);
        } finally {
            IOUtils.closeQuietly(in);
        }

    }
}
