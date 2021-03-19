module com.tlf.oss.topologyinventory.application {
    requires com.tlf.oss.topologyinventory.domain;
    requires static lombok;
    requires java.validation;
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;
    requires jakarta.el.api;

    exports com.tlf.oss.topologyinventory.application.usecases;
    exports com.tlf.oss.topologyinventory.application.usecases.helpers.qualifiers;
    exports com.tlf.oss.topologyinventory.application.ports.out;
    exports com.tlf.oss.topologyinventory.application.ports.command;

}