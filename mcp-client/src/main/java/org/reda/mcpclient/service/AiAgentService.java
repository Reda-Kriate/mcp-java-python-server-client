package org.reda.mcpclient.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallback;
import org.springframework.stereotype.Service;

@Service
public class AiAgentService {

    private ChatClient chatClient;

    public AiAgentService(ChatClient.Builder chatClient, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultSystem("Answer with the provided tools")
                .build();
    }

    public String askChat(String query){
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}
