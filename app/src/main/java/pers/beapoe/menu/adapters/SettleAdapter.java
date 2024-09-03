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

import pers.beapoe.menu.CustomApplication;
import pers.beapoe.menu.Item;
import pers.beapoe.menu.R;

public class SettleAdapter extends RecyclerView.Adapter<SettleAdapter.SettleViewHolder>{
    Activity activity;
    CustomApplication app;
    ArrayList<Item> ordered;

    public SettleAdapter(Activity activity){
        this.activity = activity;
        app = (CustomApplication)activity.getApplication();
        ordered = app.getOrdered();
    }
    @NonNull
    @Override
    public SettleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SettleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SettleViewHolder holder, int position) {
        holder.Name.setText(ordered.get(position).getName());
        holder.Copies.setText(String.valueOf(ordered.get(position).getCopies()));
        holder.Unit.setText(ordered.get(position).getUnit());
        holder.Price.setText(ordered.get(holder.getBindingAdapterPosition()).getPrice() +"元/"+ordered.get(holder.getBindingAdapterPosition()).getUnit());
        //holder.Image.setImageURI(items.get(position).getImage());
        holder.Plus.setOnClickListener(v -> {
            ordered.get(holder.getBindingAdapterPosition()).setCopies(ordered.get(holder.getBindingAdapterPosition()).getCopies()+1);
            holder.Copies.setText(String.valueOf(ordered.get(holder.getBindingAdapterPosition()).getCopies()));
            app.setOrdered(ordered);
            app.setTotal(app.getTotal()+ordered.get(holder.getBindingAdapterPosition()).getPrice());
            app.getInfo().setText("共计"+app.getTotal()+"元");
        });
        holder.Decrease.setOnClickListener(v -> {
            if (ordered.get(holder.getBindingAdapterPosition()).getCopies() == 0 || app.getTotal() == 0)
                Toast.makeText(activity, "再少，你就要倒贴我几"+ordered.get(holder.getBindingAdapterPosition()).getUnit()+"了", Toast.LENGTH_SHORT).show();
            else {
                ordered.get(holder.getBindingAdapterPosition()).setCopies(ordered.get(holder.getBindingAdapterPosition()).getCopies()-1);
                holder.Copies.setText(String.valueOf(ordered.get(holder.getBindingAdapterPosition()).getCopies()));
                BottomNavigationView navigation = app.getNavigation();
                navigation.getMenu().getItem(1).setEnabled(!app.getOrdered().isEmpty());
                app.setOrdered(ordered);
                app.setTotal(app.getTotal()-ordered.get(holder.getBindingAdapterPosition()).getPrice());
                app.getInfo().setText("共计"+app.getTotal()+"元");
                if(ordered.get(holder.getBindingAdapterPosition()).getCopies()==0) {
                    ordered.remove(ordered.get(ordered.indexOf(ordered.get(holder.getBindingAdapterPosition()))));
                    app.getNavigation().getMenu().getItem(1).setEnabled(!app.getOrdered().isEmpty());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return ordered.size();
    }

    public static class SettleViewHolder extends RecyclerView.ViewHolder{
        public ImageView Image;
        public TextView Name,Copies,Unit,Price;
        public Button Plus,Decrease;
        public SettleViewHolder(@NonNull View itemView) {
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
