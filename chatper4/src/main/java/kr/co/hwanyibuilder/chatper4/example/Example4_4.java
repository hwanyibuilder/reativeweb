package kr.co.hwanyibuilder.chatper4.example;

import java.util.Collections;
import java.util.List;

public class Example4_4 {
    public static void main(String[] args) {
        List<CryptoCurrency> cryptoCurrencies = SampleData.cryptoCurrencies;

        Collections.sort(cryptoCurrencies,(c1,c2) ->
            c1.getUnit().name().compareTo( c2.getUnit().name() )
        );
    }
}
