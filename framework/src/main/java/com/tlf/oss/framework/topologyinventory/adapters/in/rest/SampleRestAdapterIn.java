package com.tlf.oss.framework.topologyinventory.adapters.in.rest;

import com.tlf.oss.topologyinventory.application.ports.command.SampleRequest;
import com.tlf.oss.topologyinventory.application.usecases.SampleUseCase;
import com.tlf.oss.topologyinventory.application.usecases.SampleUseCase.SampleCommand;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/export")
public class SampleRestAdapterIn {

    @Inject
    public SampleUseCase sampleUseCase;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(operationId = "sampleOperation", description = "Do something with this operation")
    @Tag(name = "Sample Operation")
    public String doSomething(SampleRequest sampleRequest) {
        SampleCommand sampleCommand = new SampleCommand(sampleRequest);
        return sampleUseCase.doSomething(sampleCommand);
    }
}
