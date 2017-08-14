package com.salonbooking.services;

import com.salonbooking.domain.Style;
import com.salonbooking.factories.StyleFactory;
import com.salonbooking.services.Impl.StyleServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Ernst on 2017/08/14.
 */
public class StyleServiceTest {

    Map<String, String> values;
    StyleService service;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new StyleServiceImpl();
        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("name", "Mohawk");
    }

    @Test
    public void create() throws Exception {
        Style style = StyleFactory.getStyle(values, 40.0, 1);
        service.create(style);
        assertEquals("Mohawk",style.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Style readstyle = service.read("1");
        assertEquals("Mohawk",readstyle.getName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Style style = service.read("1");
        Style newStyle = new Style.Builder()
                .id(values.get("id"))
                .name(values.get("name"))
                .price(80)
                .hairLength(2)
                .build();
        service.update(newStyle);
        Style UpdateStyle = service.read("1");
        assertEquals(80.0,UpdateStyle.getPrice());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("1");
        Style style = service.read("1");
        assertNull(style);
    }

}