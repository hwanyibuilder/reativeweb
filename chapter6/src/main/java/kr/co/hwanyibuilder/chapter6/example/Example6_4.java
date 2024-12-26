package kr.co.hwanyibuilder.chapter6.example;

import reactor.core.publisher.Flux;

public class Example6_4 {
    public static void main(String[] args) {

        Flux.just(3,6,9,13)
                .map(num -> num%2)
                .subscribe(System.out::println);

    }
}
