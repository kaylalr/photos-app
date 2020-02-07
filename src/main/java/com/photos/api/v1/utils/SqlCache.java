package com.photos.api.v1.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

@Slf4j
@Component
public class SqlCache extends BaseSqlCache {
    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate sqlJdbc;
    @PostConstruct
    public void init() throws IOException, XMLStreamException {
        super.init();
        setJdbc(sqlJdbc);
    }
}
