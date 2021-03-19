package com.tlf.oss.topologyinventory.application.usecases;

import com.tlf.oss.topologyinventory.application.ports.command.SampleRequest;
import com.tlf.oss.topologyinventory.application.usecases.helpers.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

public interface SampleUseCase {

    String doSomething(SampleCommand sampleCommand);

    @Getter
    @EqualsAndHashCode(callSuper = false)
    class SampleCommand extends SelfValidating<SampleCommand> {

        @Inject
        Validator validator;

        @NotNull
        String requestParamA;

        @NotNull
        String requestParamB;


        public SampleCommand(SampleRequest sampleRequest) {
            this.requestParamA = sampleRequest.getRequestParamA();
            this.requestParamB = sampleRequest.getRequestParamB();
            this.validateSelf();
        }
    }
}
