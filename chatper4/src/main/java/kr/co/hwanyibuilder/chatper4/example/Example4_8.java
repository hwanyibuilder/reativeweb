package kr.co.hwanyibuilder.chatper4.example;

import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.management.ImmutableDescriptor;
import java.util.List;

public class Example4_8 {
    public static void main(String[] args) {
        List<CryptoCurrency> cryptoCurrencies = SampleData.cryptoCurrencies;

        cryptoCurrencies.stream()
                .filter(c -> c.getUnit() == CryptoCurrency.CurrencyUnit.BTC)
                .findFirst()
                .get()
                .getPrice();

        int amount = 2;

        PaymentCalculator paymentCalculator = new PaymentCalculator();
        cryptoCurrencies.stream()
                .filter(c -> c.getUnit() == CryptoCurrency.CurrencyUnit.BTC)
                .map(c -> new ImmutablePair(c.getPrice(),amount))
                .map(paymentCalculator::getTotalPayment)
                .forEach(System.out::println);
    }
}
