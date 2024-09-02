package pers.beapoe.menu;

import android.app.Application;

import java.util.ArrayList;

public class CustomApplication extends Application {
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Item> ordered = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getOrdered() {return ordered;}

    public void setOrdered(ArrayList<Item> ordered) {this.ordered = ordered;}
}
