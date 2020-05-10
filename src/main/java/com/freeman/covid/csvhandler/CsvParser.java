package com.freeman.covid.csvhandler;

import com.freeman.covid.parser.TextToStringFieldValidator;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;

@Slf4j
@Component
public class CsvParser {

    private String textForParsing;
    private Character separator;

    private final TextToStringFieldValidator textToStringFieldValidator;

    @Autowired
    public CsvParser(TextToStringFieldValidator textToStringFieldValidator) {
        this.textToStringFieldValidator = textToStringFieldValidator;
    }

    private Reader initStringReader(String text){
        return new StringReader(Objects.requireNonNull(text));
    }

    private CSVReader getCSVReader(int skipLines){
        if((textForParsing != null && !textForParsing.isEmpty()) && (separator != null)) {
            Reader reader = initStringReader(textForParsing);
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).withIgnoreQuotations(true).build();
            return new CSVReaderBuilder(reader).withSkipLines(skipLines).withCSVParser(parser).build();
        } else {
            log.warn("You should define the text for parsing and separator that using in this text");
            return null;
        }
    }


    public List<String> getHeaders ()
            throws IOException, CsvValidationException {
        CSVReader csvReader = getCSVReader(0);
        String[] headersArray = csvReader.readNext();
        return new ArrayList<>(Arrays.asList(headersArray));
    }

    public List<List<String>> getRowRecords()
            throws IOException, CsvValidationException, CsvDataTypeMismatchException, CsvConstraintViolationException {
        List<List<String>> records = new ArrayList<>();
        CSVReader csvReader = getCSVReader(1);
        String[] line;
        List<String> validLine = new ArrayList<>();
        while ((line = csvReader.readNext()) != null) {
            for (String string : line) {
                String value = textToStringFieldValidator.convertToRead(string);
                validLine.add(value);
            }
            records.add(validLine);
        }
        return records;
    }

    public void setTextForParsing(String textForParsing) {
        this.textForParsing = textForParsing;
    }

    public void setSeparator(Character separator) {
        this.separator = separator;
    }
}
