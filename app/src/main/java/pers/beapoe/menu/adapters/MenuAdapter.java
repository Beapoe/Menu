package pers.beapoe.menu.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import pers.beapoe.menu.CustomApplication;
import pers.beapoe.menu.Item;
import pers.beapoe.menu.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    Activity activity;
    CustomApplication app;
    ArrayList<Item> items;
    ArrayList<Item> ordered;


    public MenuAdapter(Activity activity){
        this.activity = activity;
        app = (CustomApplication) activity.getApplication();
        items = app.getItems();
    }
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.Name.setText(items.get(position).getName());
        holder.Copies.setText(String.valueOf(items.get(position).getCopies()));
        holder.Unit.setText(items.get(position).getUnit());
        holder.Price.setText(items.get(holder.getBindingAdapterPosition()).getPrice() +"元/"+items.get(holder.getBindingAdapterPosition()).getUnit());
        //holder.Image.setImageURI(items.get(position).getImage());
        holder.Plus.setOnClickListener(v -> {
            if(items.get(holder.getBindingAdapterPosition()).getCopies()==0) items.get(holder.getBindingAdapterPosition()).setOrdered(false);
            if(!items.get(holder.getBindingAdapterPosition()).isOrdered()){
                items.get(holder.getBindingAdapterPosition()).setOrdered(true);
                ArrayList<Item> ordered = app.getOrdered();
                ordered.add(items.get(holder.getBindingAdapterPosition()));
                Set<Item> new_ordered = new LinkedHashSet<>(ordered);
                app.setOrdered(new ArrayList<>(new_ordered));
            }
            items.get(holder.getBindingAdapterPosition()).setCopies(items.get(holder.getBindingAdapterPosition()).getCopies()+1);
            holder.Copies.setText(String.valueOf(items.get(holder.getBindingAdapterPosition()).getCopies()));
            app.setItems(items);
            app.getNavigation().getMenu().getItem(1).setEnabled(!app.getOrdered().isEmpty());
            app.setTotal(app.getTotal()+app.getOrdered().get(holder.getBindingAdapterPosition()).getPrice());
        });
        holder.Decrease.setOnClickListener(v -> {
            if (items.get(holder.getBindingAdapterPosition()).getCopies() == 0)
                Toast.makeText(activity, "再少，你就要倒贴我几"+items.get(holder.getBindingAdapterPosition()).getUnit()+"了", Toast.LENGTH_SHORT).show();
            else {
                items.get(holder.getBindingAdapterPosition()).setCopies(items.get(holder.getBindingAdapterPosition()).getCopies()-1);
                holder.Copies.setText(String.valueOf(items.get(holder.getBindingAdapterPosition()).getCopies()));
                BottomNavigationView navigation = app.getNavigation();
                navigation.getMenu().getItem(1).setEnabled(!app.getOrdered().isEmpty());
                app.setItems(items);
                app.setTotal(app.getTotal()-app.getOrdered().get(holder.getBindingAdapterPosition()).getPrice());
                if(items.get(holder.getBindingAdapterPosition()).getCopies()==0) {
                    app.getOrdered().remove(app.getOrdered().get(app.getOrdered().indexOf(items.get(holder.getBindingAdapterPosition()))));
                    app.getNavigation().getMenu().getItem(1).setEnabled(!app.getOrdered().isEmpty());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder{
        public ImageView Image;
        public TextView Name,Copies,Unit,Price;
        public Button Plus,Decrease;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.Image);
            Name = itemView.findViewById(R.id.Name);
            Copies = itemView.findViewById(R.id.Copies);
            Unit = itemView.findViewById(R.id.Unit);
            Price = itemView.findViewById(R.id.Price);
            Plus = itemView.findViewById(R.id.Plus);
            Decrease = itemView.findViewById(R.id.Decrease);
        }
    }
}
