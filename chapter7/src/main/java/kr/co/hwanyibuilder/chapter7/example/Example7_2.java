package kr.co.hwanyibuilder.chapter7.example;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Example7_2 {
    public static void main(String[] args) throws InterruptedException {

        String[] singers = {"Singer A", "Singer B", "Singer C", "Singer D", "Singer E"};

        log.info("Begin concert");

        Flux<String> concertFlux = Flux.just(singers)
                .delayElements(Duration.ofSeconds(1))
                .share();

        concertFlux.subscribe(singer -> log.info("# Subscriber1 is watching {}", singer));

        Thread.sleep(2500);

        concertFlux.subscribe(singer -> log.info("# Subscriber2 is watching {}", singer));

        Thread.sleep(3000);
    }
}
