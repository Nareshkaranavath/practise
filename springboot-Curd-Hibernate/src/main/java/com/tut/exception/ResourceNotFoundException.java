package com.tut.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private  static final long versionVersionUID =1L;
    private String resourceName;
    private String filedName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String filedName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s' ", resourceName, filedName, fieldValue ));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFiledName() {
        return filedName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
