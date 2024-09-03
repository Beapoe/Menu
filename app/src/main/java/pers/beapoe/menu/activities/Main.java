package pers.beapoe.menu.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Objects;

import pers.beapoe.menu.CustomApplication;
import pers.beapoe.menu.Item;
import pers.beapoe.menu.R;
import pers.beapoe.menu.fragments.Menu;
import pers.beapoe.menu.fragments.Settle;
import pers.beapoe.menu.fragments.Store;

public class Main extends FragmentActivity {
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final String MENU = "Fragment-Menu";

        BottomNavigationView navigation = findViewById(R.id.Navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        ArrayList<Item> items = ((CustomApplication)getApplication()).getItems();
        Item item = new Item("测试");
        item.setUnit("份");
        item.setPrice(25);
        Item item2 = new Item("测试2");
        item2.setUnit("个");
        item2.setPrice(999);
        items.add(item);
        items.add(item2);
        CustomApplication app = (CustomApplication)getApplication();
        app.setItems(items);
        transaction.add(Menu.newInstance(this),MENU);

        transaction.replace(R.id.Fragments,Menu.newInstance(this));
        transaction.commit();

        navigation.getMenu().getItem(1).setEnabled(!app.getOrdered().isEmpty());
        app.setNavigation(navigation);
        navigation.setOnItemSelectedListener(item1 -> {
            String clickedTitle = (String) item1.getTitle();
            switch (Objects.requireNonNull(clickedTitle)){
                case "点餐":
                    FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                    transaction1.replace(R.id.Fragments, Menu.newInstance(Main.this));
                    transaction1.commit();
                    break;
                case "付款":
                    ArrayList<Item> ordered = app.getOrdered();
                    if(!ordered.isEmpty()){
                        for(int index=0;index<ordered.size();index++){
                            if(ordered.get(index).getCopies()==0){
                                ordered.remove(ordered.get(index));
                                index -= 1;
                            }
                        }
                    }
                    FragmentTransaction transaction2 = fragmentManager.beginTransaction();
                    transaction2.replace(R.id.Fragments, Settle.newInstance(Main.this));
                    transaction2.commit();
                    break;
                case "商铺":
                    FragmentTransaction transaction3 = fragmentManager.beginTransaction();
                    transaction3.replace(R.id.Fragments, Store.newInstance());
                    transaction3.commit();
                    break;
                default:
                    FragmentTransaction transaction4 = fragmentManager.beginTransaction();
                    transaction4.replace(R.id.Fragments, Menu.newInstance(Main.this));
                    transaction4.commit();
                    break;
            }
            return true;
        });
    }
}
