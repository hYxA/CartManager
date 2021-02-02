package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.CartManager;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmpty {
    private CartManager manager = new CartManager();
    private PurchaseItem first = new PurchaseItem(1,1,50,50,"first");
    private PurchaseItem second = new PurchaseItem(1,1,50,50,"second");
    private PurchaseItem third = new PurchaseItem(1,1,50,50,"third");

    @BeforeEach
    void prepareManager() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExist() {
        int idToRemove = 1;

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveIfNotExist() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);
    }
}
