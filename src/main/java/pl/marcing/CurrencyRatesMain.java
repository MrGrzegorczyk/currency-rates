package pl.marcing;

import java.io.IOException;
import java.util.Scanner;


public class CurrencyRatesMain {

    public static void main(String[] args) throws InterruptedException, IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Currency: ");
        String currency = sc.nextLine();
        System.out.println("Rate Threshold: ");
        Double rateThreshold = sc.nextDouble();

        CurrencyRates currencyRates = new CurrencyRates(currency, rateThreshold);

        currencyRates.run();


    }
}
