package org.reda.mcpjavaserver;

import org.reda.mcpjavaserver.tool.McpToolService;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpJavaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpJavaServerApplication.class, args);
    }

    @Bean
    public MethodToolCallbackProvider methodToolCallbackProvider(){
        return MethodToolCallbackProvider.builder()
                .toolObjects(new McpToolService())
                .build();
    }

}
