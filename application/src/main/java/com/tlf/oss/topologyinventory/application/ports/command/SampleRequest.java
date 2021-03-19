package com.tlf.oss.topologyinventory.application.ports.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SampleRequest {
    String requestParamA;
    String requestParamB;
}
