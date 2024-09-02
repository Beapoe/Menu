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
import pers.beapoe.menu.adapters.SettleAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Settle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Settle extends Fragment {
    static Activity activity;

    public Settle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Settle.
     */
    // TODO: Rename and change types and number of parameters
    public static Settle newInstance(Activity activity1) {
        Settle fragment = new Settle();
        activity = activity1;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_settle, container, false);
        RecyclerView list = parent.findViewById(R.id.OrderedList);
        list.setLayoutManager(new LinearLayoutManager(activity));
        list.setAdapter(new SettleAdapter(activity));
        return parent;
    }
}