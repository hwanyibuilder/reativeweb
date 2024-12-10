package kr.co.hwanyibuilder.springmvcbranchoffice.controller;

import kr.co.hwanyibuilder.springmvcbranchoffice.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 본사 서버에서 들어오는 요청을 처리하능 Spring MVC 기반 지점 API Server
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class SpringMvcBranchOfficeController {

    private final Map<Long, Book> bookMap;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{book-id}")
    public ResponseEntity<Book> getBook(@PathVariable("book-id") long bookId) throws InterruptedException {
        Thread.sleep(5000);

        Book book = bookMap.get(bookId);

        return ResponseEntity.ok(book);
    }

}
