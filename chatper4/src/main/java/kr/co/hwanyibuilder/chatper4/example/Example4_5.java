package kr.co.hwanyibuilder.chatper4.example;

import java.util.List;

public class Example4_5 {
    public static void main(String[] args) {
        List<CryptoCurrency> cryptoCurrencies = SampleData.cryptoCurrencies;

        String korBTC = "비트코인";

        cryptoCurrencies.stream()
                .filter(c -> c.getUnit() == CryptoCurrency.CurrencyUnit.BTC)
                .map(c -> c.getName() + "(" + korBTC + ")" )
                .forEach(c-> System.out.println(c));
    }
}
