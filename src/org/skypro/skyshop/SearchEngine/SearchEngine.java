package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.product.Product;

import org.skypro.skyshop.Interface.Searchable;

public class SearchEngine {

    private final Searchable[] searchArray;

    public SearchEngine(int size) {
        this.searchArray = new Searchable[size];
    }

    public Searchable[] search(String string) {
        int resultCount = 0;
        Searchable[] resultArray = new Searchable[5];
        for (int i = 0; i < searchArray.length; i++) {
            if (searchArray[i] != null && searchArray[i].searchTerm().contains(string)) {
                if (resultCount >= resultArray.length) {
                    break;
                }
                resultArray[resultCount] = searchArray[i];
                resultCount++;
            }
        }
        return resultArray;
    }

    public boolean add(Searchable searchable) {
        for (int i = 0; i < searchArray.length; i++) {
            if (searchArray[i] == null) {
                searchArray[i] = searchable;
                return true;
            }
        }
        return false;
    }
}
