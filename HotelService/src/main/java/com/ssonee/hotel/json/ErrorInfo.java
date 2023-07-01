package com.ssonee.hotel.json;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorInfo {

    private String errorCd;
    private String errorMsg;
}
