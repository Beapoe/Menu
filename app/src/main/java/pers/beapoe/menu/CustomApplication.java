package pers.beapoe.menu;

import android.app.Application;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CustomApplication extends Application {
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Item> ordered = new ArrayList<>();
    BottomNavigationView navigation;
    int total = 0;
    TextView Info;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getOrdered() {return ordered;}

    public void setOrdered(ArrayList<Item> ordered) {this.ordered = ordered;}

    public BottomNavigationView getNavigation() {return navigation;}

    public void setNavigation(BottomNavigationView navigation) {this.navigation = navigation;}

    public int getTotal(){return total;}

    public void setTotal(int total){this.total = total;}

    public TextView getInfo() {return Info;}

    public void setInfo(TextView info) {Info = info;}
}
