package pers.beapoe.menu.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pers.beapoe.menu.CustomApplication;
import pers.beapoe.menu.R;

public class ConfirmAdapter extends RecyclerView.Adapter<ConfirmAdapter.ConfirmViewHolder>{
    Activity activity;

    public ConfirmAdapter(Activity activity){this.activity = activity;}
    @NonNull
    @Override
    public ConfirmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConfirmViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.confirm_item,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ConfirmViewHolder holder, int position) {
        CustomApplication app = (CustomApplication)activity.getApplication();
        holder.Copies.setText(app.getOrdered().get(holder.getBindingAdapterPosition()).getCopies()+app.getOrdered().get(holder.getBindingAdapterPosition()).getUnit());
        holder.Name.setText(app.getOrdered().get(holder.getBindingAdapterPosition()).getName());
    }

    @Override
    public int getItemCount() {
        return ((CustomApplication)activity.getApplication()).getOrdered().size();
    }

    public static class ConfirmViewHolder extends RecyclerView.ViewHolder{
        TextView Copies,Name;
        public ConfirmViewHolder(@NonNull View itemView) {
            super(itemView);
            Copies = itemView.findViewById(R.id.ConfirmCopies);
            Name = itemView.findViewById(R.id.ConfirmName);
        }
    }
}
