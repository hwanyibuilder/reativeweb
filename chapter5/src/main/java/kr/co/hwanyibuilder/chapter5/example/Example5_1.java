package kr.co.hwanyibuilder.chapter5.example;

import reactor.core.publisher.Flux;

public class Example5_1 {
    public static void main(String[] args) {
        Flux.just("Hello", "Reactor").map(String::toLowerCase).subscribe(System.out::println);
    }
}
