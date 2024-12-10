package kr.co.hwanyibuilder.springreactiveheadoffice;

import kr.co.hwanyibuilder.springreactiveheadoffice.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalTime;

@Slf4j
@SpringBootApplication
public class SpringReactiveHeadofficeApplication {

    private final URI baseUri = UriComponentsBuilder.newInstance().scheme("http")
            .host("localhost")
            .port(6060)
            .path("/v1/books")
            .build()
            .encode()
            .toUri();

    public static void main(String[] args) {
        System.setProperty("reactor.netty.ioWorkerCount", "1");
        SpringApplication.run(SpringReactiveHeadofficeApplication.class, args);
    }

    private Mono<Book> getBook(Long bookId){
        URI getBooksUri = UriComponentsBuilder.fromUri(baseUri)
                .path("/{book-id}")
                .build()
                .expand(bookId)
                .encode()
                .toUri();

        return WebClient.create()
                .get()
                .uri(getBooksUri)
                .retrieve()
                .bodyToMono(Book.class);
    }

    @Bean
    public CommandLineRunner run(){
        return args -> {
            log.info("# 요청 시작 시간: {}", LocalTime.now());

            for(long i=0;i<=5;i++){
                this.getBook(i)
                        .subscribe(
                                book -> {
                                    log.info("{}: book name : {}",LocalTime.now(),book.getName());
                                }
                        );
            }
        };
    }



}
