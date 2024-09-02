package pers.beapoe.menu;

import android.net.Uri;

public class Item {
    Uri Image;
    int Copies = 0;
    int Price = 0;
    String Name,Unit;
    boolean isOrdered = false;

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

    public int getCopies() {
        return Copies;
    }

    public void setCopies(int copies) {
        Copies = copies;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getPrice() {return Price;}

    public void setPrice(int price) {Price = price;}

    public boolean isOrdered() {return isOrdered;}

    public void setOrdered(boolean ordered) {isOrdered = ordered;}
}
