package LibraryServer.First.service;

import LibraryServer.First.model.Book;

public interface RedisRepo {
    public void save(final Book book);
    public Book findBookById(final String id);
    
}
