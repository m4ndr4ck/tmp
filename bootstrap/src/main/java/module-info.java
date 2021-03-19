module com.tlf.oss.bootstrap {
    requires quarkus.core;
    requires quarkus.smallrye.openapi;
    requires smallrye.open.api.core;
    requires microprofile.openapi.api;
    requires com.tlf.oss.topologyinventory.domain;
    requires com.tlf.oss.topologyinventory.application;
    requires com.tlf.oss.topologyinventory.framework;
}