package com.freeman.covid.csvhandler.handmade;

import java.util.Arrays;

public class RowBasedCsvMetadataSource implements CsvMetadataSource {

    private final String rowSplitter;
    private final String row;

    public RowBasedCsvMetadataSource(String row, String rowSplitter) {
        this.row = row;
        this.rowSplitter = rowSplitter;
    }

    @Override
    public CsvMetadata getCsvMetadata() {
        String[] columns = row.split(rowSplitter);
        return new CsvMetadata(Arrays.asList(columns), rowSplitter);
    }
}
