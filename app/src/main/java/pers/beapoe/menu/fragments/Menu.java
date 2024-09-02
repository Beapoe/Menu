package pers.beapoe.menu.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pers.beapoe.menu.R;
import pers.beapoe.menu.adapters.MenuAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {
    @SuppressLint("StaticFieldLeak")
    static Activity activity;
    public Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Menu.
     */
    public static Menu newInstance(Activity activity1) {
        activity = activity1;
        return new Menu();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_menu, container, false);
        RecyclerView list = parent.findViewById(R.id.MenuList);
        list.setLayoutManager(new LinearLayoutManager(activity));
        list.setAdapter(new MenuAdapter(activity));
        return parent;
    }
}