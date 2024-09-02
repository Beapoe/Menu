package pers.beapoe.menu;

import android.net.Uri;

public class Item {
    Uri Image;
    String Name,Copies,Unit;

    public Item(String Name){this.Name = Name;}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Uri getImage() {
        return Image;
    }

    public void setImage(Uri image) {
        Image = image;
    }

    public String getCopies() {
        return Copies;
    }

    public void setCopies(String copies) {
        Copies = copies;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }
}
