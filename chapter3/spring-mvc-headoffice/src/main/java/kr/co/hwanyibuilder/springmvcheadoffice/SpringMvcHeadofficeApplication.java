package kr.co.hwanyibuilder.springmvcheadoffice;

import kr.co.hwanyibuilder.springmvcheadoffice.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalTime;

@Slf4j
@SpringBootApplication
public class SpringMvcHeadofficeApplication {

    private final URI baseUri = UriComponentsBuilder.newInstance().scheme("http")
            .host("localhost")
            .port(8080)
            .path("/v1/books")
            .build()
            .encode()
            .toUri();

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcHeadofficeApplication.class, args);
    }

    @Bean
    public RestTemplateBuilder restTemplate() {
        return new RestTemplateBuilder();
    }

    @Bean
    public RestTemplate returnRestTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }

    private Book getBook(long bookId) {
        RestTemplate restTemplate = new RestTemplate();

        URI getBooksUri = UriComponentsBuilder.fromUri(baseUri)
                .path("/{book-id}")
                .build()
                .expand(bookId)
                .encode()
                .toUri();

        ResponseEntity<Book> response =
                restTemplate.getForEntity(getBooksUri, Book.class);

        return response.getBody();
    }

    @Bean
    public CommandLineRunner run() {
        return (String... args) -> {
            log.info("# 요청 시작 시간: {}", LocalTime.now());

            for (int i = 1; i <= 5; i++) {
                Book book = this.getBook(i);
                log.info("{}: book name: {}", LocalTime.now(), book.getName());
            }
        };
    }

}
