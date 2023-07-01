package com.ssonee.hotel.json;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private String TransactionStatus;
    private HttpStatus status;
    private ErrorInfo errorInfo;

}

