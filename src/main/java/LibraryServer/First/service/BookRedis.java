package LibraryServer.First.service;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import LibraryServer.First.model.Book;

@Service
public class BookRedis implements RedisRepo {
    Logger logger = LoggerFactory.getLogger(BookRedis.class);
    private final String bookList = "keyList";
    private final String bookMap = "mainDataMap";

    @Autowired
    RedisTemplate<String, Object> template;

    private List<Book> books = Arrays.asList(
        new Book("title1", "author1", "url1"),
        new Book("title2", "author2", "url2"),
        new Book("title3", "author3", "url3")
    );

    public void save(final Book book) {
        logger.info("Saving book with id: " + book.getId());
        template.opsForList().leftPush(bookList, book.getId());
        template.opsForHash().put(bookMap, book.getId(), book);
    }

    public Book findBookById(final String id) {
        logger.info("Finding book with id: " + id);
        Book result = (Book)template.opsForHash().get(id, bookMap);
        logger.info("Retrieved Book: " + result);
        logger.info("Retrieved Title: " + result.getTitle());
        return result;
    }

    public List<Book> getAllBooks() {
        return books;
    }    

}
