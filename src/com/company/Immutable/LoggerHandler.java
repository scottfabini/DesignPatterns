package com.company.Immutable;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * Publish log messages to the console.
 * Extends logging.Handler from java.util
 */
public class LoggerHandler extends Handler {
    @Override
    public void publish(LogRecord logRecord) {
        System.out.println(logRecord.getMessage() + " (log level: " + logRecord.getLevel() + ")");
    }

    @Override
    public void close() throws SecurityException {

    }

    @Override
    public void flush() {

    }
}
