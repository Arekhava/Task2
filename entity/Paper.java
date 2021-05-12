package entity;

public abstract class Paper {
    private String title;
    private String publisher;
   // private String magazine;
   // private String newspaper;
    private String paper;
    private String website;
    private String subscription;
    private String glossy;
    private int pages;
    private int date;

    public Paper(){
    }
//public String getMagazine() {
//        return magazine;
//    }
//
//    public void setMagazine(String magazine) {
//        this.magazine = magazine;
//    }
//
//    public String getNewspaper() {
//        return newspaper;
//    }
//
//    public void setNewspaper(String newspaper) {
//        this.newspaper = newspaper;
//    }


    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Paper(String title, String publisher, String website, String subscription, String glossy, int date, int pages, String magazine, String newspaper, String paper){
        this.title=title;
        this.publisher=publisher;
        this.website=website;
        this.subscription=subscription;
        this.glossy=glossy;
        this.pages=pages;
        this.date=date;
      //  this.magazine=magazine;
     //  this.newspaper=newspaper;
        this.paper=paper;
    }
    //protected String title;
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

    public String getGlossy() {
        return glossy;
    }

    public void setGlossy(String glossy) {
        this.glossy = glossy;
    }

    public int getPages() {
        return pages;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }



    public void setPages(int pages) {
        this.pages = pages;
    }
    public String toString(){
        final StringBuilder sb=new StringBuilder("\nTitle");
        sb.append(title).append("\nPublisher:").append(publisher);
        sb.append("\nSubscription").append(subscription);
        sb.append("\nWebsite").append(website);
        sb.append("\nGlossy").append(glossy);
        sb.append("\nPages").append(pages);
        sb.append("\nDate").append(date);
        return sb.toString();
    }

    public void setMagazine(String elementTextContent) {
    }

    public abstract void setNewspaper(String elementTextContent);
}
