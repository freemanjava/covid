package com.freeman.covid.csvhandler.handmade;

import com.freeman.covid.annotations.fieldmapper.MappedFieldExtractor;
import com.freeman.covid.csvhandler.CsvParser;
import com.freeman.covid.csvhandler.handmade.CsvRecordMapper;
import com.freeman.covid.models.dto.CoronaStateDTO;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class CoronaStateDTORecordMapper implements CsvRecordMapper<CoronaStateDTO> {

    private final MappedFieldExtractor mappedFieldExtractor;
    private final CsvParser csvParser;

    @Autowired
    public CoronaStateDTORecordMapper(MappedFieldExtractor mappedFieldExtractor, CsvParser csvParser) {
        this.mappedFieldExtractor = mappedFieldExtractor;
        this.csvParser = csvParser;
    }

    @Override
    public CoronaStateDTO map(Map<String, String> csvRecord, int lineNumber) {
        String firstname = csvRecord.get("FIRST NAME");
        String lastname = csvRecord.get("LAST NAME");
        String username = csvRecord.get("USERNAME");
        String email = csvRecord.get("EMAIL ADDRESS");

        return new CoronaStateDTO();
    }

    private List<String> extractHeaders () throws IOException, CsvValidationException {
        return csvParser.getHeaders();
    }
}
