package LibraryServer.First.model;

import java.io.Serializable;
import java.util.UUID;

public class Book implements Serializable{
    private static final long serialVersionUID = 1L;
    private String thumbnailUrl;
    private String title;
    private String author;
    private String id;

    public Book() {
        this.id = this.generateId();
    }

    public Book(String title, String author, String thumbnailUrl) {
        this.title = title;
        this.author = author;
        this.thumbnailUrl = thumbnailUrl;
        this.id = this.generateId();
    }

    public String generateId() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        return id;
    }    

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String getId() {
        return this.id;
    }
}
