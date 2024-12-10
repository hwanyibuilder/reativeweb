package kr.co.hwanyibuilder.springreactiveheadoffice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private long bookId;
    private String name;
    private int price;

}
