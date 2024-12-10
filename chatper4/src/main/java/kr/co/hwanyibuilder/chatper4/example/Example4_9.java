package kr.co.hwanyibuilder.chatper4.example;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.Optional;

public class Example4_9 {
    public static void main(String[] args) {

        List<CryptoCurrency> cryptoCurrencies = SampleData.cryptoCurrencies;

        int amount = 2;

        Optional<PaymentCalculator> optional = cryptoCurrencies.stream()
                .filter(cc -> cc.getUnit() == CryptoCurrency.CurrencyUnit.BTC)
                .map(cc -> new ImmutablePair(cc.getPrice(),amount))
                .map(PaymentCalculator::new)
                .findFirst();

        System.out.println(optional.get().getTotalPayment());

    }
}
