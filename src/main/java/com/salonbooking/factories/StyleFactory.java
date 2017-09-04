package com.salonbooking.factories;

import com.salonbooking.domain.Style;

import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class StyleFactory{

    public static Style buildStyle(String id, String name, Double price, int hairLength)
    {
        Style style = new Style.Builder()
                .id(id)
                .name(name)
                .price(price)
                .hairLength(hairLength)
                .build();
        return style;
    }
}
