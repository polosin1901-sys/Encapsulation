package org.skypro.skyshop.product;

import org.skypro.skyshop.Interface.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String nameOfArticle;
    private final String textOfArticle;

    public Article(String nameOfArticle, String textOfArticle) {
        this.nameOfArticle = nameOfArticle;
        this.textOfArticle = textOfArticle;
    }

    public String getNameOfArticle() {
        return nameOfArticle;
    }

    public String getTextOfArticle() {
        return textOfArticle;
    }

    @Override
    public String toString() {
        return getName() + "\n" + textOfArticle;
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return getNameOfArticle();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameOfArticle, article.nameOfArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameOfArticle);
    }

    @Override
    public String searchTerm() {
        return getNameOfArticle() + getTextOfArticle();


    }
}
