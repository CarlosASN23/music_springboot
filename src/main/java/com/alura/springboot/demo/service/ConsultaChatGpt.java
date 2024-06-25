package com.alura.springboot.demo.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGpt {

    public static String obterInformacao(String texto){

        OpenAiService service = new OpenAiService(System.getenv("API_KEY_GPT"));
        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);
        return response.getChoices().get(0).getText();
    }
}
