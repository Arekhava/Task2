package entity;

public class Newspaper extends Paper {
    private String title;

    public Newspaper(String title) {
        this.title = title;
    }

    public Newspaper(String title, String publisher, String website, String subscription, String glossy, int date, int pages, String magazine, String newspaper, String paper, String title1) {
        super(title, publisher, website, subscription, glossy, date, pages, magazine, newspaper, paper);
        this.title = title1;
    }

    public Newspaper() {

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setNewspaper(String elementTextContent) {

    }


}
