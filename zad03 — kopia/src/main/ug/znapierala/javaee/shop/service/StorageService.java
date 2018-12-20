package ug.znapierala.javaee.shop.service;

import ug.znapierala.javaee.shop.domain.Flat;

import java.util.HashMap;
import java.util.Map;

public class StorageService {
	private Map<Long, Flat> db = new HashMap<Long, Flat>();

	public void add(Flat flat) {
		Flat newFlat = new Flat(flat.getId(), flat.getName(), flat.isAviliable(), flat.getPrice(), flat.getDate());
		db.put(flat.getId(), newFlat);
	}

	public Map<Long, Flat> getAllFlats(){
		return db;
	}
}
