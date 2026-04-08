package org.reda.mcpjavaserver.models;

import java.time.LocalDate;

public record Stock(
        String name,
        LocalDate date,
        double stock
) {
}
