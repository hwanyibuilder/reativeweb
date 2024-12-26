package kr.co.hwanyibuilder.chatper4.example;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example4_1 {

    public static void main(String[] args) {
        List<CryptoCurrency> cryptoCurrencies = SampleData.cryptoCurrencies;

        Collections.sort(cryptoCurrencies, new Comparator<CryptoCurrency>() {

            @Override
            public int compare(CryptoCurrency c1,CryptoCurrency c2){
                return c1.getUnit().name().compareTo(c2.getUnit().name());
            }
        });

    }
}
