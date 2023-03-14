package com.mao.chatgpt.service;

import com.mao.chatgpt.dto.ChatRequest;
import com.mao.chatgpt.dto.ChatResponse;

public interface ChatgptService {

    String sendMessage(String message);

    ChatResponse sendChatRequest(ChatRequest request);

}
