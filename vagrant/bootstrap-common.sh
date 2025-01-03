#!/bin/bash

apt-get update -q
apt-get -y install curl gpg htop jq net-tools ntp wget

# Random entropy generator ... needed for SecureRandom
apt-get -y install haveged
