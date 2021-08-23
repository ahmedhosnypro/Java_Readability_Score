class Article implements Comparable<Article> {
    private final String title;
    private final int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        if (this.getSize() == otherArticle.getSize()) {
            return this.getTitle().compareTo(otherArticle.getTitle());
        } else {
            return Integer.compare(this.getSize(), otherArticle.getSize());
        }
    }
}