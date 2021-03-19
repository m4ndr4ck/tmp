package com.tlf.oss.topologyinventory.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleDomainTests {

    @Test
    void getOccupancyTest1() {
        assertTrue (SampleEntity.doSomeBusinessLogic("a", "b"));
    }
}
