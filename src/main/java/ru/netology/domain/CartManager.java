package ru.netology.domain;


public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        // копируем поэлементно
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        // кладём последний наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getAll() {
        //создаём массив для хранения результатов
        PurchaseItem[] result = new PurchaseItem[items.length];
        // перебираем массив в прямом порядке
        // но кладём результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
