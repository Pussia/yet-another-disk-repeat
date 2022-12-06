package ru.pasha.yetAnotherDiskRepeat.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private int code;
    private String message;
}
