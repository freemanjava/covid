package com.freeman.covid.parser;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.CsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import org.springframework.stereotype.Component;

@Component
public class TextToStringFieldValidator extends AbstractCsvConverter {

    public TextToStringFieldValidator(){

    }
    @Override
    public String convertToRead(String inputString) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        String returnString = "empty field";
        if ((!inputString.equalsIgnoreCase(null)) || (inputString != "")){
            returnString = inputString;
        }
        return returnString;
    }
}
