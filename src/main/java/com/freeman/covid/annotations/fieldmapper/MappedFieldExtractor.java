package com.freeman.covid.annotations.fieldmapper;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class MappedFieldExtractor {

    public List<MappedField> getMappedFields(Object object) throws FieldMappingException{
        try {
            List<MappedField> fields = new ArrayList<>();
            for (Field field : ((Class) object).getDeclaredFields()){
                field.setAccessible(true);
                if (field.isAnnotationPresent(FieldMappingByName.class)){
                    fields.add(new MappedField(getAnnotationValue(field), field.getName()));
                }
            }
            return fields;
        }
        catch (Exception e){
            throw new FieldMappingException(e.getMessage());
        }
    }

    private static String getAnnotationValue(Field field) {
        String annotationValue = field.getAnnotation(FieldMappingByName.class).header();

        if (annotationValue.isEmpty()) {
            return field.getName();
        }
        else {
            return annotationValue;
        }
    }
}
