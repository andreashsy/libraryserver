package LibraryServer.First.service;

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
    @Autowired
    RedisTemplate<String, Object> template;

    public void save(final Book book) {
        logger.info("Saving book with id: " + book.getId());
        template.opsForValue().set(book.getId(), book);
    }

    public List<Book> getAllBooks() {

        return null;
    }    

}
