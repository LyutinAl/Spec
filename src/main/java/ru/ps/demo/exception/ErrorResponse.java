package ru.ps.demo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDate timestamp;
    private List<String> message;

    public ErrorResponse (List<String> message) {
        this.message = message;
        this.timestamp = LocalDate.now();
    }



}
