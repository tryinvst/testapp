package com.example.demo.controller;

import com.example.demo.module.LogEvent;
import com.example.demo.module.LogRequest;
import com.example.demo.service.ElasticSearchService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.events.Event;

@RestController
public class LogController {
private static final Logger log = LoggerFactory.getLogger ( LogController.class );
ElasticSearchService elasticSearchService;

    public LogController(ElasticSearchService elasticSearchService) {
        this.elasticSearchService = elasticSearchService;
    }
    @PostMapping
    public void logOnly (@RequestBody LogRequest logRequest) {
        log.info ("Пришел запрос" + logRequest.getMessage());
        LogEvent event = LogEvent.event (logRequest.getMessage ());
        log.info (event.toString());
    }
}
