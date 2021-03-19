Topology Inventory Exporter
===================

## Sumário

- [Microservices Athena](#)
    - [Sumário](#sum%c3%a1rio)
    - [Introdução](#introdu%c3%a7%c3%a3o)
    - [Configurações | Build | Deploy](#configura%c3%a7%c3%b5es--build--deploy)
        - [Pre Requisitos](#pre-requisitos)
        - [Repositórios](#reposit%c3%b3rios)
        - [Desenvolvimento local](#desenvolvimento-local)
        - [Testes](#testes)
        - [Deploy](#deploy)
    - [Ambientes](#Ambientes)
    - [Swagger](#swagger)
    - [Health Check](#swagger)
    - [Arquitetura](#arquitetura)

## Introdução

Este projeto tem como objetivo fornecer uma estrutura de microserviços com arquitetura hexagonal em Java, para o projeto Athena de OSS Digital Plataform.

Esse sistema ilustra a construção de aplicações nativas para nuvem que utilizam arquitetura hexagonal
e são orquestradas como microserviços.

Os recursos nativos do Kubernetes são utilizados para aplicar técnicas de Service Discovery na comunicação
inter-servico, API Gateway com ingress para expor externamente os endpoints do sistema e uso de ConfigMaps e
Secrets para fornecer variáveis de ambiente. Tais recursos se tornam possíveis graças ao Spring Cloud Kubernetes
que se integra com a API do cluster.

Os logs são capturados pelo Fluentd através de um DaemonSet que cria um pod, que atua como agente, em cada nó do cluster. Os logs são então enviados para o Elasticsearch.

Grafana e Prometheus são utilizados para monitoramento da infraestrutura.

## Módulos Java e Arquitetura Hexagonal

Na arquitetura hexagonal temos os seguintes hexágonos:

- <b>Application</b>
  <br> Nesse hexágono existem as portas, casos de uso e queries. Esses componentes são utilizados para traduzir o que vem de fora (operações condutoras/driver) do hexágono como o que parte de dentro e sai do hexágono (operações dirigidas/driven).<br><br>
- <b>Domain</b>
  <br> Classes que representam entidades de negócio e contenham algorítimos críticos para o negócio devem ficar aqui. É muito importante que aqui nenhuma classe dependa de classes existentes em Application e Framework, fazemos isso como meio de praticar o DDD e garantir a inversão de dependência.<br><br>
- <b>Framework</b>
  <br>Aqui devem ficar as classes que representam os adapters (ou controller na terminologia MVC) de entrada e saída da aplicação e demais classes dentro do escopo de framework.

No contexto do JPMS (Java Plataform Module System) cada hexágono se transforma em um módulo Java.

Existe um módulo adicional chamado <b>boostrap</b> que é responsável por agregar os outros módulos durante a compilação e incializar a aplicação pelo Spring Boot.

![Hexagonal](src/main/resources/hexagonal.png?raw=true)


## Configurações | Build | Deploy

### Pre Requisitos
- [Java 11](https://www.oracle.com/java/)
- [Maven 3.6.3](https://maven.apache.org/download.cgi)
- [Quarkus](https://quarkus.io/)


### Repositórios
[GitLab](http://10.129.178.173/odp/microservices/src/src-topology-inventory-exporter)

### Desenvolvimento local
Após clonar o repositório, executar o seguinte comando na pasta raiz do projeto:

```
mvn compile quarkus:dev
````

```
curl -X POST "http://localhost:8080/topology-inventory-exporter/api/v1/export" -H  "accept: text/plain" -H  "Content-Type: application/json" -d "{\"requestParamA\":\"string\",\"requestParamB\":\"string\"}"
```

### Testes
Como testar o microserviço?

- [Wiki](http://wikicorp.vivo.com.br/display/OFL/Microservices)

## CI/CD

Links das ferramentas:
- [Jenkins](http://pipelines-devops.redecorp.br/job/ODP-Microservices/job/topology-inventory-exporter/)
- [kubernetes](http://admin.k8s.oss.vivo.com.br/)

## Objetos Kubernetes

Nomenclatura (deployment, service, configmap, secret):

```
{nome-do-job-raiz-no-jenkins}-{nome-da-aplicação}
```

Exemplo nomenclatura :

```
odp-microservices-topology-inventory-exporter
```

Exemplo service.yaml:

```
apiVersion: v1
kind: Service
metadata:
  name: odp-microservices-topology-inventory-exporter
  labels:
    app: odp-microservices-topology-inventory-exporter
spec:
  ports:
    - port: 8080
      protocol: TCP
  selector:
    app: odp-microservices-topology-inventory-exporter

```

## Ambientes
| Ambiente | Host | Link |
| ------ | ------ |------|
| DEV | dev.oss.vivo.com.br | http://dev.oss.vivo.com.br/topology-inventory-exporter |


## Swagger

Exemplo local:

```
http://localhost:8080/topology-inventory-exporter/q/swagger-ui
```

Exemplo no ambiente de DEV:

```
http://dev.oss.vivo.com.br/topology-inventory-exporter/q/swagger-ui
```

## Health Check

Exemplo no ambiente de DEV:

```
http://dev.oss.vivo.com.br/topology-inventory-exporter/q/health/live
```

## Arquitetura
- [Wiki](http://wikicorp.vivo.com.br/display/OFL/Microservices)

