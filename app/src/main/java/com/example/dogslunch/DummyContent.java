package com.example.dogslunch;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {
    /** Списочный массив элементов */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    static {

        StringBuilder builder = new StringBuilder();

        ITEMS.add(new DummyItem(String.valueOf(1), "Блюда из курицы" , builder.toString()));

        ITEMS.add(new DummyItem(String.valueOf(2), "Блюда из говядины" , builder.toString()));

        ITEMS.add(new DummyItem(String.valueOf(3), "Блюда из свинины" , builder.toString()));

        ITEMS.add(new DummyItem(String.valueOf(4), "Блюда из рыбы" , builder.toString()));

        ITEMS.add(new DummyItem(String.valueOf(4), "Только овощи" , builder.toString()));
    }

    /** Создание класса элементов для списка. */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }
        @Override
        public String toString() { return content; }
    }
}
