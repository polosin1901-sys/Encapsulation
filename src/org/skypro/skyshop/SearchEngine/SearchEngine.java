package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Interface.Searchable;

import java.util.*;

public class SearchEngine {

    Set<Searchable> searchArray = new HashSet<>();

    public SearchEngine(Set<Searchable> searchArray) {
        this.searchArray = searchArray;
    }

    public TreeSet search(String string) {
        TreeSet<Searchable> resultSet = new TreeSet<>((s1, s2) -> {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            } else {
                return s1.getName().compareTo(s2.getName());
            }
        });
        for (Searchable searchable : searchArray) {
            if (searchable.getName().contains(string)) {
                resultSet.add(searchable);
            }
        }
        return resultSet;
    }

    public void add(Searchable product) {
        searchArray.add(product);
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
