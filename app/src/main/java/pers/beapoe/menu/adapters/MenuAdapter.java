package pers.beapoe.menu.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pers.beapoe.menu.CustomApplication;
import pers.beapoe.menu.Item;
import pers.beapoe.menu.R;
import pers.beapoe.menu.view_models.ItemModel;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    CustomApplication app = (CustomApplication) new Activity().getApplication();
    ArrayList<Item> items = app.getItems();
    @SuppressLint("StaticFieldLeak")
    static Activity activity;

    public MenuAdapter(Activity activity){MenuAdapter.activity = activity;}
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.itemModel.getName().setText(items.get(position).getName());
        holder.itemModel.getCopies().setText(items.get(position).getCopies());
        holder.itemModel.getUnit().setText(items.get(position).getUnit());
        holder.itemModel.getImage().setImageURI(items.get(position).getImage());
        holder.itemModel.getPlus().setOnClickListener(v -> {
            items.get(holder.getBindingAdapterPosition()).setCopies(String.valueOf(Integer.parseInt(items.get(holder.getBindingAdapterPosition()).getCopies())+1));
            holder.itemModel.getCopies().setText(items.get(holder.getBindingAdapterPosition()).getCopies());
        });
        holder.itemModel.getDecrease().setOnClickListener(v -> {
            if (Integer.parseInt(items.get(holder.getBindingAdapterPosition()).getCopies()) == 0)
                Toast.makeText(new Activity(), "再少，你就要倒贴我几份了", Toast.LENGTH_SHORT).show();
            else {
                items.get(holder.getBindingAdapterPosition()).setCopies(String.valueOf(Integer.parseInt(items.get(holder.getBindingAdapterPosition()).getCopies()) - 1));
                holder.itemModel.getCopies().setText(items.get(holder.getBindingAdapterPosition()).getCopies());
            }
        });
        app.setItems(items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder{
        ItemModel itemModel;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            itemModel = ItemModel.getModel(activity);
        }
    }
}
