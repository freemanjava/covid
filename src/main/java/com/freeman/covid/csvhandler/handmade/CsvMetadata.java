package com.freeman.covid.csvhandler.handmade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvMetadata {
    private final String rowSplitter;
    private final List<String> columns;

    public CsvMetadata(List<String> columns, String rowSplitter) {
        this.columns = columns;
        this.rowSplitter = rowSplitter;
    }

    public Map<String, String> parseLine(String line) {
        // simple implementation
        String[] values = line.split(rowSplitter);

        Map<String, String> record = new HashMap<>();

        for (int i = 0; i < columns.size(); i++) {
            String column = columns.get(i);
            String value = null;

            if (i < values.length) {
                value = values[i];
            }
            record.put(column, value);
        }
        return record;
    }

}
