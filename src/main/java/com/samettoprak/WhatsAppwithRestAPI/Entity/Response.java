package com.samettoprak.WhatsAppwithRestAPI.Entity;

import lombok.Data;

@Data
public class Response<E>  {
    Boolean isSuccess;
    String message;
    E body;

    public Response(Boolean isSuccess, String message, E body) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.body = body;
    }

    public static<E> Response Succsess(E body){
        return new Response<E>(true,null,body);

    }
    public static<E> Response Fail(String message){
        return new Response<E>(false,message,null);
    }

}
