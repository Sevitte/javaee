package ug.znapierala.javaee.shop.service;

import ug.znapierala.javaee.shop.domain.Perfume;

import java.util.HashMap;
import java.util.Map;

public class StorageService {
	private Map<Long, Perfume> db = new HashMap<Long, Perfume>();

	public void add(Perfume perfume) {
		Perfume newPerfume = new Perfume(perfume.getId(), perfume.getName(), perfume.isAviliable(), perfume.getPrice(), perfume.getDate());
		db.put(perfume.getId(), newPerfume);
	}

	public Map<Long, Perfume> getAllPerfumes(){
		return db;
	}
}
