package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Interface.Searchable;

import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    TreeMap<String, Searchable> searchArray;

    public SearchEngine(TreeMap<String, Searchable> searchArray) {
        this.searchArray = searchArray;
    }

    public TreeMap search(String string) {
        TreeMap<String,Searchable> resultMap = new TreeMap<>();
        for (Map.Entry<String, Searchable> m : searchArray.entrySet()) {
            if (m.getValue().searchTerm().contains(string)) {
                resultMap.put(m.getKey(), m.getValue());
            }
        }
        return resultMap;
    }

    public void add(Searchable product) {
        searchArray.put(product.getName(), product);
    }



    public Searchable findBestMatch(String search) throws BestResultNotFound {
        int maxOccurrences = 0;
        Searchable bestMatch = null;
        for (Searchable srch : searchArray.values()) {
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
