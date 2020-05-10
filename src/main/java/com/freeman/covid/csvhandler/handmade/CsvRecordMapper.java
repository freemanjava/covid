package com.freeman.covid.csvhandler.handmade;

import java.util.Map;

public interface CsvRecordMapper <T>{
    public T map(Map<String, String> csvRecord, int lineNumber);
}
