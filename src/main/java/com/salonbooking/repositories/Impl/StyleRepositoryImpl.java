package com.salonbooking.repositories.Impl;

import com.salonbooking.domain.Style;
import com.salonbooking.repositories.StyleRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ernst on 2017/07/14.
 */
public class StyleRepositoryImpl implements StyleRepository{

    private static StyleRepositoryImpl respository = null;

    private Map<String, Style> styleTable;

    private StyleRepositoryImpl() {

        styleTable = new HashMap<String, Style>();
    }

    public static StyleRepositoryImpl getInstance(){
        if(respository==null)
            respository = new StyleRepositoryImpl();
        return respository;
    }

    public Style create(Style style) {
        styleTable.put(style.getId(),style);
        Style savedStyle = styleTable.get(style.getId());
        return savedStyle;
    }

    public Style read(String id) {
        Style style = styleTable.get(id);
        return style;
    }

    public Style update(Style style) {
        styleTable.put(style.getId(),style);
        Style savedStyle = styleTable.get(style.getId());
        return savedStyle;
    }

    public void delete(String id) {
        styleTable.remove(id);

    }
}
