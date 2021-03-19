package com.tlf.oss.framework.topologyinventory.adapters.out.neo4j;

import com.tlf.oss.topologyinventory.application.ports.out.SamplePortOut;
import com.tlf.oss.topologyinventory.application.usecases.helpers.qualifiers.Neo4j;
import javax.enterprise.context.Dependent;

@Dependent
@Neo4j
public class SampleNeo4jAdapterOut implements SamplePortOut {

    @Override
    public String fecthSomething() {
        return "Neo4j data";
    }
}
