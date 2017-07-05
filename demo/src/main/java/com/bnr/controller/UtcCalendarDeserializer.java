package com.bnr.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer;

@JacksonStdImpl
public class UtcCalendarDeserializer extends CalendarDeserializer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TimeZone TZ_UTC = TimeZone.getTimeZone("AEST");

    @Override
    public Calendar deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonToken t = jp.getCurrentToken();
        if (t == JsonToken.VALUE_NUMBER_INT) {
            Calendar cal = Calendar.getInstance(TZ_UTC);
            cal.clear();
            cal.setTimeInMillis(jp.getLongValue());

            return cal;
        }

        return super.deserialize(jp, ctxt);
    }
}
