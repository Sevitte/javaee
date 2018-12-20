package main.ug.znapierala.javaee.shop.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Flat {
    private long id = 0;
    private String name = "Batalionow Chlopskich 24/6";
    private boolean isAviliable = true;
    private double price = 700000.0;
    private Date date = new Date();

    public Flat(long id, String name, boolean isAviliable, double price, Date date) {
        this.id = id;
        this.name = name;
        this.isAviliable = isAviliable;
        this.price = price;
        this.date = date;
    }

    public Flat() {

    }

    public String showDetails() {
        String Aviliable;
        if(isAviliable) {
            Aviliable = "Mieszkanie nie jest jeszcze dostêpne";
        }
        else {
            Aviliable = "Mieszkanie jest ju¿ dostêpne";
        }
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        return "Nazwa: " + name + "<br>Stan: " + Aviliable + "<br>Cena: " + price + "<br>Data wydania: " + df.format(date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAviliable() {
        return isAviliable;
    }

    public void setIsAviliable(boolean isAviliable) {
        this.isAviliable = isAviliable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
