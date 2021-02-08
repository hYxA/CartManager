package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.CartManager;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CardRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartManagerTestNonEmpty {
    @Mock
    private CardRepository repository;
    @InjectMocks
    private CartManager manager = new CartManager();

    private PurchaseItem first = new PurchaseItem(1, 1, 50, 50, "first");
    private PurchaseItem second = new PurchaseItem(1, 1, 50, 50, "second");
    private PurchaseItem third = new PurchaseItem(1, 1, 50, 50, "third");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExist() {
        int idToRemove = 1;
        // настройка заглушки
        PurchaseItem[] returned = new PurchaseItem[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка внутренней реализации
        verify(repository).removeById(idToRemove);
    }


    @Test
    public void shouldRemoveIfNotExist() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}
