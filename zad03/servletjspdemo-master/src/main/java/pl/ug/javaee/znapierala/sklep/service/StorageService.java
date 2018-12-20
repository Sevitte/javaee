package pl.ug.javaee.znapierala.sklep.service;
import pl.ug.javaee.znapierala.sklep.domain.Flat;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class StorageService
{
	private static ArrayList<Flat> cart = new ArrayList<Flat>();
	static public void addToCart(Flat flat, HttpServletRequest request, ServletContext context) {
		ArrayList<Flat> list = (ArrayList<Flat>) request.getSession().getAttribute("cart");
		cart.add(flat);
        request.getSession().setAttribute("cart",list);
        FlatService flatService = (FlatService) context.getAttribute("flat_service");
        flatService.removeFlat(flat.getId());
        context.setAttribute("flat_service",flatService);
    }
    static public void addToCart(int id, HttpServletRequest request,ServletContext context) {
        ArrayList<Flat> list = (ArrayList<Flat>) request.getSession().getAttribute("cart");
        FlatService flatService = (FlatService) context.getAttribute("flat_service");
        list.add(flatService.getFlat(id));
        request.getSession().setAttribute("cart",list);
        flatService.removeFlat(id);
        context.setAttribute("flat_service",flatService);
    }
    static public void removeFromCart(int id, HttpServletRequest request, ServletContext context) {
        ArrayList<Flat> list = (ArrayList<Flat>) request.getSession().getAttribute("cart");
        for(Flat flat: list) {
            if(flat.getId()==id) {
                list.remove(id);
                break;
            }
        }
        request.getSession().setAttribute("flat",list);
    }
    
    static public ArrayList<Flat> getCart(HttpServletRequest request) {
        return (ArrayList<Flat>) request.getSession().getAttribute("cart");
    }
}
