package org.example.trouble.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TW8310803Response {
    @JsonProperty("TRXDT")
    private String TRXDT;

    @JsonProperty("TRXTIME")
    private String TRXTIME;

    @JsonProperty("CARDNO")
    private String CARDNO;

    @JsonProperty("IDNO-IN")
    private String IDNOIN;

    @JsonProperty("CD2")
    private String CD2;

    @JsonProperty("APNO")
    private String APNO;

    @JsonProperty("CLASS")
    private String CLASS;
}
