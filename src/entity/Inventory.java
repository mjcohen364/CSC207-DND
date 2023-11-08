package entity;

import entity.Item;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> Items;

    public void add(Item newItem) {
        Items.add(newItem);
    }
}
