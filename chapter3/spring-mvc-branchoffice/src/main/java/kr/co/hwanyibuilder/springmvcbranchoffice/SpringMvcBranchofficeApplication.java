package kr.co.hwanyibuilder.springmvcbranchoffice;

import kr.co.hwanyibuilder.springmvcbranchoffice.domain.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringMvcBranchofficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcBranchofficeApplication.class, args);
    }


    /**
     * SpringMvcBranchOfficeController 에서 사용할 bookmap을 Bean으로 등록
     * @return
     */
    @Bean
    public Map<Long, Book> bookMap(){
        Map<Long,Book> bookMap = new HashMap<Long,Book>();
        for(long i = 1 ; i <= 2000000; i++){
            bookMap.put(i,new Book(i,"IT Book "+i,2000));
        }
        
        return bookMap;
    }

}
