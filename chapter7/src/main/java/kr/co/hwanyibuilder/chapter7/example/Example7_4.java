package kr.co.hwanyibuilder.chapter7.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
public class Example7_4 {
    public static void main(String[] args) throws InterruptedException {
        URI worldTimeUri = UriComponentsBuilder.newInstance().scheme("http")
                .host("worldtimeapi.org")
                .port(80)
                .path("/api/timezone/Asia/Seoul")
                .build()
                .encode()
                .toUri();

        Mono<String> mono = Example7_3.getWorldTime(worldTimeUri).cache();
        mono.subscribe(datetime -> log.info("# dateTime 1 : {}", datetime));
        Thread.sleep(2000);
        mono.subscribe(datetime -> log.info("# dateTime 2 : {}", datetime));

        Thread.sleep(2000);

    }
}
