package pers.beapoe.menu.view_models;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pers.beapoe.menu.R;

public class ItemModel {
    private ImageView Image;
    private TextView Name,Copies,Unit;
    private Button Plus,Decrease;
    @SuppressLint("StaticFieldLeak")
    private static ItemModel model;

    private ItemModel(Activity activity){
        activity.setContentView(R.layout.item);
        Image = activity.findViewById(R.id.Image);
        Name = activity.findViewById(R.id.Name);
        Copies = activity.findViewById(R.id.Copies);
        Plus = activity.findViewById(R.id.Plus);
        Decrease = activity.findViewById(R.id.Decrease);
    }

    public static ItemModel getModel(Activity activity){
        if(model == null) model = new ItemModel(activity);
        return model;
    }

    public ImageView getImage() {
        return Image;
    }

    public void setImage(ImageView image) {
        Image = image;
    }

    public TextView getName() {
        return Name;
    }

    public void setName(TextView name) {
        Name = name;
    }

    public TextView getCopies() {
        return Copies;
    }

    public void setCopies(TextView copies) {
        Copies = copies;
    }

    public Button getPlus() {
        return Plus;
    }

    public void setPlus(Button plus) {
        Plus = plus;
    }

    public Button getDecrease() {
        return Decrease;
    }

    public void setDecrease(Button decrease) {
        Decrease = decrease;
    }

    public TextView getUnit() {
        return Unit;
    }

    public void setUnit(TextView unit) {
        Unit = unit;
    }
}
