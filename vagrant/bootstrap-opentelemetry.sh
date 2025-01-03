#!/bin/bash

OTEL_VERSION='v2.10.0'

if [ ! -e /vagrant/vagrant/opentelemetry-javaagent.jar ]; then
    echo "Downloading opentelemetry-javaagent.jar"
    curl -s -L -o /vagrant/vagrant/opentelemetry-javaagent.jar "https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/$OTEL_VERSION/opentelemetry-javaagent.jar"
fi
