package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.product.Product;

import org.skypro.skyshop.Interface.Searchable;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    List<Searchable> searchArray;

    public SearchEngine(List<Searchable> searchArray) {
        this.searchArray = searchArray;
    }

    public LinkedList search(String string) {
        LinkedList<Searchable> resultList = new LinkedList<>();
        for (Searchable searchable : searchArray) {
            if (searchable != null && searchable.searchTerm().contains(string)) {
                resultList.add(searchable);
            }
        }
        return resultList;
    }

    public void add(Searchable searchable) {
        searchArray.add(searchable);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        int maxOccurrences = 0;
        Searchable bestMatch = null;
        for (Searchable srch : searchArray) {
            String term = srch.searchTerm();
            int count = 0;
            int index = term.indexOf(search);
            while (index != -1) {
                count++;
                index = term.indexOf(search, index + search.length());
            }
            if (count > maxOccurrences) {
                maxOccurrences = count;
                bestMatch = srch;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдена строка - " + search);
        }
        return bestMatch;
    }

}
