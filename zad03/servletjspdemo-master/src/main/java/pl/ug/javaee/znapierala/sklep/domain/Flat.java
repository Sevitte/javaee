package pl.ug.javaee.znapierala.sklep.domain;
import java.sql.Date;

public class Flat {
	private int id;
	private String name;
	private Boolean isAviliable;
	private Date date;
	private Double price;

	public Flat()
	{
		super();
	}
	
	public Flat(String name, Boolean isAviliable, Date date, Double price)
	{
		super();
		this.name = name;
		this.isAviliable = isAviliable;
		this.date = date;
		this.price = price;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public String getName()
	{
		return name;
	}
 
	public Boolean getIsAviliable()
	{
		return isAviliable;
	}
 
	public Date getDate()
	{
		return date;
	}
 
	public Double getPrice()
	{
		return price;
	}
 
	public void setName(String name)
	{
		this.name = name;
	}
 
	public void setIsAviliable(boolean isAviliable)
	{
		this.isAviliable = isAviliable;
	}
 
	public void setDate(Date date)
	{
		this.date = date;
	}
 
	public void setPrice(double price)
	{
		this.price = price;
	}
    @Override
    public String toString() {
        return "Flat{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", isAviliable=" + isAviliable +
                '}';
    }
}
