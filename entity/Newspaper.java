package entity;

public class Newspaper {
    private String title;
    private String publisher;
    private String website;
    private String subscription;
    private int pages;
   // private Publisher publisher=new Publisher();
    public Newspaper(){
    }
    public Newspaper(String title, String publisher, String website, String subscription, int pages){
        this.title=title;
        this.publisher=publisher;
        this.website=website;
        this.subscription=subscription;
        this.pages=pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    public String toString(){
        final StringBuilder sb=new StringBuilder("\nTitle");
        sb.append(title).append("\nPublisher:").append(publisher);
        sb.append("\nSubscription").append(subscription);
        sb.append("\nWebsite").append(website);
        sb.append("\nPages").append(pages);
        return sb.toString();
    }
}
