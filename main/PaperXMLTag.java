package main;

public enum PaperXMLTag {
    TITLE("title"),
    SUBSCRIPTION("subscription"),
    PAPERS("papers"),
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine"),
    PERIODICALS("periodicals"),
    PERIODICITY("periodicity"),
    PUBLISHER("publisher"),
    PAGES("pages"),
    GLOSSY("glossy"),
    DATE("date"),
    SUBJECT("subject"),
    SUBJECT1("subject1"),
    SUBJECT2("subject2"),
    LINER_GIFT("liner-gift"),
    COLORED("colored"),
    WEBSITE("website"),
    COLORED_PAGES("ColoredPages");

    String title;

    PaperXMLTag(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

