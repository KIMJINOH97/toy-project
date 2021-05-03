package com.example.toy_project.apiform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ApiForm<T> {
    @JsonProperty("status_code")
    private final int statusCode;
    private final String message;
    private final T data;

    public ApiForm(int code, T data, String message){
        this.statusCode = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiForm<T> succeed(T data, String message){
        return new ApiForm<>(200, data, message);
    }

    public static <T> ApiForm<T> error(String message){
        return new ApiForm<>(400, null, message);
    }
}
