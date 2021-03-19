package com.tlf.oss.topologyinventory.application.ports.in;

import com.tlf.oss.topologyinventory.application.ports.out.SamplePortOut;
import com.tlf.oss.topologyinventory.application.usecases.SampleUseCase;
import com.tlf.oss.topologyinventory.application.usecases.helpers.qualifiers.Neo4j;
import com.tlf.oss.topologyinventory.domain.SampleEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SamplePortIn implements SampleUseCase {

    @Inject
    @Neo4j
    public SamplePortOut samplePortOut;

    @Override
    public String doSomething(SampleCommand sampleCommand) {
        return getData(sampleCommand);
    }

    private String getData(SampleCommand sampleCommand){
        var attrA = sampleCommand.getRequestParamA();
        var attrB = sampleCommand.getRequestParamA();
        return (SampleEntity.doSomeBusinessLogic(attrA,attrB)) ? samplePortOut.fecthSomething()  : "no data";
    }

}
