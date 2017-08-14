package com.salonbooking.factories;

import com.salonbooking.domain.Style;

import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class StyleFactory{

        public static Style getStyle(Map<String, String> values, double price, int hairLength)
        {
            Style style = new Style.Builder()
                    .id(values.get("id"))
                    .name(values.get("name"))
                    .price(price)
                    .hairLength(hairLength)
                    .build();

            return style;
        }
}
