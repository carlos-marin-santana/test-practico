package com.carlos.examenpractico.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobIdRequest {
    @JsonProperty("job_id")
    private Long jobId;
}
