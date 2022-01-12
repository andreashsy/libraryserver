package LibraryServer.First.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import LibraryServer.First.model.Book;
import LibraryServer.First.service.BookRedis;

@Controller
public class LibraryController {
    Logger logger = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    private BookRedis bookRedis;

    @GetMapping("/")
    public String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("bookObj", book);
        return "addBook";
    }

    @PostMapping("/addbook")
    public String saveBook(@ModelAttribute Book book, Model model) {
        logger.info("Received from form: " + book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getThumbnailUrl());
        bookRedis.save(book);
        return "success";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable String id, Model model) {
        Book redisBook = bookRedis.findBookById(id);
        logger.info("Retrieved book info: " + redisBook.getTitle());
        Book returnedBook = new Book(redisBook.getTitle(), redisBook.getAuthor(), redisBook.getThumbnailUrl());
        model.addAttribute("bookObjByID", returnedBook);
        return "IdResult";
    }
    
    @GetMapping("/books")
    public String getAllBooks() {
        return "";
    }

}
