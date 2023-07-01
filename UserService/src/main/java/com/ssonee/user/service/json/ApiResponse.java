package com.ssonee.user.service.json;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.security.SecureRandom;

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

