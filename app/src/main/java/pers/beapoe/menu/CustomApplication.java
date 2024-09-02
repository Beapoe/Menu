package pers.beapoe.menu;

import android.app.Application;

import java.util.ArrayList;

public class CustomApplication extends Application {
    ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
