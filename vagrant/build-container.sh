#!/bin/bash

pushd $PWD

cd /vagrant/vagrant/
cp /vagrant/target/*.jar .
buildah bud -t localhost/opentelemetry-spring-boot-example -f Dockerfile .
buildah tag localhost/opentelemetry-spring-boot-example localhost:31050/opentelemetry-spring-boot-example
buildah push --tls-verify=false localhost:31050/opentelemetry-spring-boot-example

popd
