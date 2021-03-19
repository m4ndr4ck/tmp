package com.tlf.oss.topologyinventory.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SampleEntity {

    public static boolean doSomeBusinessLogic(String attrA, String attrB){
            return true;
    }
}
