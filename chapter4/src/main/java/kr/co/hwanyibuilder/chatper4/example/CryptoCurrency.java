package kr.co.hwanyibuilder.chatper4.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CryptoCurrency {

    private String name;
    private CurrencyUnit unit;
    private int price;

    public enum CurrencyUnit {
        BTC,
        ETH,
        DOT,
        ADA,
        SOL
    }

}
