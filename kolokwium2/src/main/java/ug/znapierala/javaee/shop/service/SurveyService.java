package ug.znapierala.javaee.shop.service;

import ug.znapierala.javaee.shop.domain.Survey;

import java.util.HashMap;
import java.util.Map;

public class SurveyService {
	private Map<String, Survey> db = new HashMap<String, Survey>();

    public Map<String, Survey> getAllSurveys() {
        return db;
    }

    public void add(String id, Survey survey) {
        db.put(id, survey);
    }

    public void delete(String key) {
        db.remove(key);
    }
}
