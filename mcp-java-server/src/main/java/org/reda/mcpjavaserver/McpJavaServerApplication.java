package org.reda.mcpjavaserver;

import org.reda.mcpjavaserver.tool.StockService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpJavaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpJavaServerApplication.class, args);
    }

    @Bean
    public MethodToolCallbackProvider methodToolCallbackProvider(StockService stockService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(stockService)
                .build();
    }

//    @Bean
//    public List<ToolCallback> toolCallback(StockService stockService){
//        return List.of(ToolCallbacks.from(stockService));
//    }

}
