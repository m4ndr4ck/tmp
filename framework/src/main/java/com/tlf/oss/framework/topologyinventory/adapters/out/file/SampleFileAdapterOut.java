package com.tlf.oss.framework.topologyinventory.adapters.out.file;

import com.tlf.oss.topologyinventory.application.ports.out.SamplePortOut;
import com.tlf.oss.topologyinventory.application.usecases.helpers.qualifiers.File;
import javax.enterprise.context.Dependent;

@Dependent
@File
public class SampleFileAdapterOut implements SamplePortOut {

    @Override
    public String fecthSomething() {
        return "File data";
    }
}
