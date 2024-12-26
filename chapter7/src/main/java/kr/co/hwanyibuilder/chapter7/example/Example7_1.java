package kr.co.hwanyibuilder.chapter7.example;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Slf4j
public class Example7_1 {
    public static void main(String[] args) throws InterruptedException {
        Flux<String> coldFlux = Flux.fromIterable(
                Arrays.asList("KOREA","JAPAN","CHINESE")
        ).map(String::toLowerCase);

        coldFlux.subscribe(country -> log.info("# Subscriber1: {}", country));
        log.info("-----------------------------");

        Thread.sleep(2000L);
        coldFlux.subscribe(country -> log.info("# Subscriber2: {}", country));
    }
}
