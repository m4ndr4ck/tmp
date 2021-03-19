module com.tlf.oss.topologyinventory.framework {
    requires com.tlf.oss.topologyinventory.application;
    requires com.tlf.oss.topologyinventory.domain;

    requires java.ws.rs;
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;
    requires quarkus.jackson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.jaxrs.json;
    requires microprofile.openapi.api;
    requires org.mockito;
}