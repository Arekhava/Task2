package entity;

public class Magazine extends Paper{

        private String title;

        public Magazine(String title) {
                this.title = title;
        }

        public Magazine(String title, String publisher, String website, String subscription, String glossy, int date, int pages, String magazine, String newspaper, String paper, String title1) {
                super(title, publisher, website, subscription, glossy, date, pages, magazine, newspaper, paper);
                this.title = title1;
        }

        public Magazine(){

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
