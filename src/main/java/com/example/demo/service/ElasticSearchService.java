package com.example.demo.service;

import com.example.demo.module.LogEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ElasticSearchService {
private static final Logger logger = LoggerFactory.getLogger (ElasticSearchService.class);
private final RestClient client;
private final String indexname;

public ElasticSearchService(RestClient.Builder restclient,@Value ( "${app.elasticsearch.url}" ) String elkConnection,
                            @Value ( "${app.elasticsearch.index}" ) String indexname) {
    this.client = restclient.baseUrl (elkConnection).build();
    this.indexname = indexname;
}

public void LogEvent (String message) {
    LogEvent event = LogEvent.event ( message );
    try {
        this.client.post ().uri ( "/demo-logs/_doc/" + event.getId () )
                   .body ( event ).retrieve ().toBodilessEntity ();
        logger.debug ( "Залогировано" + event );
    } catch (Exception e) {
        logger.debug ( "Ошибка" + e.getMessage());
        e.printStackTrace();
    }
}
}


