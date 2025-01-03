# opentelemetry-spring-boot-example

This project provides an example of integrating OpenTelemetry tracing into a
Spring Boot application in a zero-code manner. This project also shows how to
set up Jaeger, Tempo, and Grafana for visualizing trace data.

## Prerequisites

1. Java 21 or later
2. Apache Maven 3.8.8 or later
3. Vagrant 2.4.3 or later
4. VirtualBox 7.1.4 r165100 or later

## Running the example

### Build the Spring Boot Example Application

```
mvn clean package
```

### Bring up the Virtual Machine

```
vagrant up
```

### Deploy the Container Registry

```
vagrant ssh
sudo su -l
kubectl apply -f /vagrant/vagrant/k8s/registry.yml
```

### Build and Push the Spring Boot Example Container

Perform the following steps as a non-root user:
```
vagrant ssh
source /vagrant/vagrant/build-container.sh
```

### Deploy Jaeger, Tempo, Grafana, and the Spring Boot Example Application into Kubernetes
```
vagrant ssh
sudo su -l
kubectl apply -f /vagrant/vagrant/k8s/stack.yml
```

### Access the Spring Boot Example Application

```
http://192.168.0.100:30000/api/sampleEntities
```

Accessing the Spring Boot Example Application in your browser will trigger the generation
of traces, which can then be visualized using Jaeger and/or Grafana as described below.

### View the Traces in Jaeger
```
http://192.168.0.100:30001/
```

### View the Traces in Grafana (via Tempo)

1. Navigate to:  http://192.168.0.100:30003/
1. Sign in with the following credentials: `admin:admin`
1. Add a Tempo data source, using the following connection URL:  http://tempo:3200
1. Click "Save & test"
1. Click "Explore" in the left menu panel
1. Choose the "Search" Query type
1. You should see traces from the Spring Boot application in the table
1. Control-click on a Trace ID to open the trace details in a new browser tab
