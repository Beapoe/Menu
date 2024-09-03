package pers.beapoe.menu.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import pers.beapoe.menu.CustomApplication;
import pers.beapoe.menu.Item;
import pers.beapoe.menu.R;
import pers.beapoe.menu.adapters.ConfirmAdapter;

public class Payment extends Activity {
    int CheckedWayID = R.id.WeChat;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        TextView info = findViewById(R.id.ConfirmInfo);
        CustomApplication app = (CustomApplication) getApplication();
        info.setText("共计" + app.getTotal() + "元");
        RecyclerView ConfirmOrdered = findViewById(R.id.ConfirmOrdered);
        ConfirmOrdered.setLayoutManager(new LinearLayoutManager(this));
        ConfirmOrdered.setAdapter(new ConfirmAdapter(this));
        RadioGroup ways = findViewById(R.id.PayWays);
        ways.setOnCheckedChangeListener((group, checkedId) -> CheckedWayID = checkedId);
    }

    public void PayClick(View v) {
        RadioButton way = findViewById(CheckedWayID);
        CustomApplication app = (CustomApplication) getApplication();
        Toast.makeText(this, "你使用" + way.getText().toString() + "支付了" + app.getTotal() + "元", Toast.LENGTH_SHORT).show();
        app.setTotal(0);
        app.setOrdered(new ArrayList<>());
        BottomNavigationView navigation = app.getNavigation();
        navigation.getMenu().getItem(1).setEnabled(false);
        ArrayList<Item> items = app.getItems();
        for(Item item:items) item.setCopies(0);
        app.setItems(items);
        finish();
    }
}