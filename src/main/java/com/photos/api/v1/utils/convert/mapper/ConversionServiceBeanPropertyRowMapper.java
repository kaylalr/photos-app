package com.photos.api.v1.utils.convert.mapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class ConversionServiceBeanPropertyRowMapper<T> extends BeanPropertyRowMapper<T> {
    private final ConversionService conversionService;
    public ConversionServiceBeanPropertyRowMapper(Class<T> mappedClass, ConversionService conversionService) {
        super(mappedClass);
        this.conversionService = conversionService;
    }
    @Override
    protected void initBeanWrapper(BeanWrapper bw) {
        super.initBeanWrapper(bw);
        bw.setConversionService(conversionService);
    }
}