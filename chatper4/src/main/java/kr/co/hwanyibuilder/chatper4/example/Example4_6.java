package kr.co.hwanyibuilder.chatper4.example;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Example4_6 {
    public static void main(String[] args) {
        List<CryptoCurrency> cryptoCurrencies = SampleData.cryptoCurrencies;

        cryptoCurrencies.stream()
                .filter(c->c.getUnit() == CryptoCurrency.CurrencyUnit.BTC)
                .map(CryptoCurrency::getName)
//                .map(StringUtils::upperCase)
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
