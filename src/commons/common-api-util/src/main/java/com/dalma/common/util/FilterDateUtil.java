package com.dalma.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class FilterDateUtil {

    private FilterDateUtil() {
        // Avoid initialization
    }

    public static Instant getStartInstant(LocalDate startDate) {
        if (startDate == null) {
            startDate = LocalDate.now(ZoneOffset.UTC).withDayOfMonth(1);
        }

        return startDate.atStartOfDay().toInstant(ZoneOffset.UTC);
    }

    public static Instant getEndInstant(LocalDate endDate) {
        if (endDate == null) {
            endDate = LocalDate.now(ZoneOffset.UTC);
        }

        return endDate.atTime(LocalTime.MAX).minusNanos(999999).toInstant(ZoneOffset.UTC);
    }
}
