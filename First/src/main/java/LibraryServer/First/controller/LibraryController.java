package LibraryServer.First.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LibraryServer.First.model.Book;
import LibraryServer.First.service.BookRedis;

@RestController
public class LibraryController {

    @Autowired
    private BookRedis bookRedis;

    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookRedis.getAllBooks();
    }

}
