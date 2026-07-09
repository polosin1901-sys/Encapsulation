package org.skypro.skyshop.Interface;

import org.skypro.skyshop.product.Product;

public interface Searchable {
    String searchTerm();

    String getTypeOfContent();

    default String getStringRepresentation() {
        return searchTerm() + " - " + getStringRepresentation();
    }


}
