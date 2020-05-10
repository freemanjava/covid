package com.freeman.covid.csvhandler.handmade;

public interface CsvObjectCallback <T> {
    public void process(T object);
}
