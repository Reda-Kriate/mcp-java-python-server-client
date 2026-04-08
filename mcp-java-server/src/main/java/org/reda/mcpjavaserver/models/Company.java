package org.reda.mcpjavaserver.models;

public record Company(
        String name,
        String activity,
        double turnover,
        int employeeCount,
        String country
) {
}
