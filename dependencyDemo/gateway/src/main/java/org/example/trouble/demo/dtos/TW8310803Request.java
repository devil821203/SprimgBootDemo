package org.example.trouble.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TW8310803Request {
    @JsonProperty("CARDNO")
    private String CARDNO;

    @JsonProperty("IDNO-IN")
    private String IDNOIN;

    @JsonProperty("APNO")
    private String APNO;

    @JsonProperty("CD2")
    private String CD2;

    @JsonProperty("CLASS")
    private String CLASS;
}
