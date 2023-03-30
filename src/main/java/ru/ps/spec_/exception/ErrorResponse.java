package ru.ps.spec_.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private LocalDateTime time;

    private List<String> messages;

    public ErrorResponse(List<String> messages) {
        this.time = LocalDateTime.now();
        this.messages = new ArrayList<>(messages);
    }
}
