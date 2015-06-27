package com.shop.storage.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Igor on 25.06.2015.
 */
public enum Status {
    DELIVERED("delivered"),

    CANCELED("canceled"),

    EXPECTED_DELIVERY("expectedDelivery");

    private String name;

    private Status(String name){
        this.name = name;
    }

    private static final Map<String, Status> map =
            new HashMap<String, Status>();

    static {
        for (Status type : Status.values()) {
            map.put(type.name, type);
        }
    }

    public String getName() {
        return name;
    }

    public static Status fromString(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        throw new NoSuchElementException(name + "not found");
    }
}
