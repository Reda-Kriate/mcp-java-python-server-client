package org.reda.mcpclient.web;

import org.reda.mcpclient.service.AiAgentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiAgentWeb {
    private AiAgentService aiAgentService;

    public AiAgentWeb(AiAgentService aiAgentService) {
        this.aiAgentService = aiAgentService;
    }

    @GetMapping("/ask")
    public String askAgent(String query){
        return aiAgentService.askChat(query);
    }
}
