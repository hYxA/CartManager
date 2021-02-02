package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.CartManager;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmpty {
    @Test
    public void shouldRemoveIfExist() {
        CartManager manager = new CartManager();
        int idToRemove = 1;
        PurchaseItem first = new PurchaseItem(1,1,50,50,"first");
        PurchaseItem second = new PurchaseItem(1,1,50,50,"second");
        PurchaseItem third = new PurchaseItem(1,1,50,50,"third");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveIfNotExist() {
        CartManager manager = new CartManager();
        int idToRemove = 4;
        PurchaseItem first = new PurchaseItem(1,1,50,50,"first");
        PurchaseItem second = new PurchaseItem(1,1,50,50,"second");
        PurchaseItem third = new PurchaseItem(1,1,50,50,"third");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);
    }
}
