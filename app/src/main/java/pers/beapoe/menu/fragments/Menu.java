package pers.beapoe.menu.fragments;

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
    Activity activity;

    public Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu newInstance(Activity activity) {
        return new Menu();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity.setContentView(R.layout.fragment_menu);
        RecyclerView recyclerView = activity.findViewById(R.id.MenuList);
        MenuAdapter adapter = new MenuAdapter(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
}