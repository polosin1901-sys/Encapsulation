package org.skypro.skyshop.product;

import org.skypro.skyshop.Interface.Searchable;

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
        return nameOfArticle + "\n" + textOfArticle;
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }

    @Override
    public String searchTerm() {
        return getNameOfArticle() + getTextOfArticle();


    }
}
