package ug.znapierala.javaee.shop.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Perfume {
	private long id = 0;
    private String name = "Super Zapach";
    private boolean isAviliable = true;
    private double price = 700.0;
    private Date date = new Date();

    public Perfume(long id, String name, boolean isAviliable, double price, Date date) {
        this.id = id;
        this.name = name;
        this.isAviliable = isAviliable;
        this.price = price;
        this.date = date;
    }

    public Perfume() {

    }

    public String showDetails() {
        String Aviliable;
        if(isAviliable) {
            Aviliable = "Perfumu aktualnie nie ma na stanie";
        }
        else {
            Aviliable = "Perfum jest dostepny";
        }
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        return "Nazwa: " + name + "<br>Stan: " + Aviliable + "<br>Cena: " + price + "<br>Data premiery: " + df.format(date);
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
