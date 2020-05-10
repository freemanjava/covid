package com.freeman.covid.csvhandler.handmade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class CsvReader {

    private CsvMetadataSource csvMetadataSource;
    private String rowSplitter;

    public CsvReader() {
    }

    public CsvReader(CsvMetadataSource csvMetadataSource, String rowSplitter) {
        this.csvMetadataSource = csvMetadataSource;
        this.rowSplitter = rowSplitter;
    }

    public <T> List<T> readAll(Reader csvInputReader, CsvRecordMapper<T> csvLineMapper) throws IOException {
        CollectCsvObjectCallback<T> collectCsvObjectCallback = new CollectCsvObjectCallback<>();
        read(csvInputReader, csvLineMapper, collectCsvObjectCallback);
        return collectCsvObjectCallback.getObjects();
    }

    public <T> void read(Reader csvInputReader, CsvRecordMapper<T> csvLineMapper,
                         CsvObjectCallback<T> csvObjectCallback) throws IOException {
        try (BufferedReader lineReader = new BufferedReader(csvInputReader);) {
            CsvMetadataSource effectiveCsvMetadataSource = getCsvMetadataSource(lineReader);

            read(csvLineMapper, csvObjectCallback, lineReader, effectiveCsvMetadataSource);
        }
    }

    private CsvMetadataSource getCsvMetadataSource(BufferedReader lineReader) throws IOException {
        CsvMetadataSource effectiveCsvMetadataSource = csvMetadataSource;
        if (effectiveCsvMetadataSource == null) {
            String headerLine = lineReader.readLine();
            effectiveCsvMetadataSource = new RowBasedCsvMetadataSource(headerLine, rowSplitter);
        }
        return effectiveCsvMetadataSource;
    }

    private <T> void read(CsvRecordMapper<T> csvLineMapper, CsvObjectCallback<T> csvObjectCallback,
                          BufferedReader lineReader, CsvMetadataSource effectiveCsvMetadataSource) throws IOException {
        CsvMetadata effectiveCsvMetadata = effectiveCsvMetadataSource.getCsvMetadata();
        if (effectiveCsvMetadata != null) {
            String line;
            int csvRecordNumber = 0;

            while ((line = lineReader.readLine()) != null) {
                Map<String, String> csvRecordValues = effectiveCsvMetadata.parseLine(line);
                T object = csvLineMapper.map(csvRecordValues, csvRecordNumber++);
                csvObjectCallback.process(object);
            }
        }
    }

    private void setRowSplitter(String rowSplitter) {
        this.rowSplitter = rowSplitter;
    }

    public void addRowSplitter (String rowSplitter){
        setRowSplitter(rowSplitter);
    }


}
