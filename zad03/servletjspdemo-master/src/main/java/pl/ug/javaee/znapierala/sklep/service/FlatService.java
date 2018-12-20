package pl.ug.javaee.znapierala.sklep.service;

import pl.ug.javaee.znapierala.sklep.domain.Flat;
import java.util.HashMap;
import java.util.Map;

public class FlatService {
    public int counter = 0;
    private Map<Integer,Flat> map = new HashMap<Integer,Flat>();
    public void addFlat(Flat flat) {
        flat.setId(counter);
        map.put(counter, flat);
        counter++;
    }
    public Flat getFlat(int id) {return map.get(id); }
    public Flat getFlat(String name) {
        int i = 0;
        while(i<map.size()) {
            i++;
            if(map.get(i).getName().equals(name)) {
                return map.get(i);
            }
        }
        return null;
    }
    public void removeFlat(int id) {
        map.remove(id);
    }

    public Map<Integer, Flat> getMap() {
        return map;
    }  
}
