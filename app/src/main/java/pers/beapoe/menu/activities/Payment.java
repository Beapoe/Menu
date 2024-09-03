package pers.beapoe.menu.activities;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import pers.beapoe.menu.R;

public class Payment extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
    }
}
