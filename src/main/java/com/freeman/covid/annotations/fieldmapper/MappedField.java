package com.freeman.covid.annotations.fieldmapper;

public class MappedField {

    private final String fieldName;
    private final String annotationValue;

    public MappedField(String annotationValue, String fieldName) {
        this.annotationValue = annotationValue;
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getAnnotationValue() {
        return annotationValue;
    }
}
