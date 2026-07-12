package org.skypro.skyshop.Interface;

import org.skypro.skyshop.product.Product;

public interface Searchable {
    String searchTerm();

    String getTypeOfContent();

    String getName();

    default String getStringRepresentation() {
        return getName() + " - " + getTypeOfContent();
    }
}
