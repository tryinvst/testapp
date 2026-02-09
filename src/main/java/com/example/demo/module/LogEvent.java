package com.example.demo.module;

import java.time.Instant;
import java.util.UUID;

public class LogEvent {
    private final String id;
    private final Instant timestamp;
    private final String level;
    private final String message;

    public LogEvent(String message ,String level ,Instant timestamp ,String id) {
        this.message = message;
        this.level = level;
        this.timestamp = timestamp;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String toString () {
    return level +
            "\n" +
            message +
            "\n" +
            timestamp;
    }

    public static LogEvent event (String message) {
     return new LogEvent (UUID.randomUUID().toString(),"INFO", Instant.now(),message);
    }
}
