package com.mao.chatgpt.exception;

public class ChatgptException extends RuntimeException{

    public ChatgptException(){
        super();
    }

    public ChatgptException(String message){
        super(message);
    }

}
