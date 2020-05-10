package com.freeman.covid.csvhandler.handmade;

import java.util.ArrayList;
import java.util.List;

public class CollectCsvObjectCallback <T> implements CsvObjectCallback <T> {

    private final List<T> objects = new ArrayList<>();

    public List<T> getObjects() {
        return objects;
    }

    @Override
    public void process(T object) {
        objects.add(object);
    }
}
