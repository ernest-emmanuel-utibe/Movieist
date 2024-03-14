#!/bin/bash

# Install Docker
echo "Installing Docker..."
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh

# Install Docker Compose
echo "Installing Docker Compose..."
sudo apt-get update
sudo apt-get install -y docker-compose

# Install Keycloak
echo "Downloading Keycloak..."
mkdir keycloak
cd keycloak
curl -O https://downloads.jboss.org/keycloak/14.0.0/keycloak-14.0.0.zip
unzip keycloak-14.0.0.zip
cd keycloak-14.0.0/bin

# Start Keycloak
echo "Starting Keycloak..."
./standalone.sh -Djboss.socket.binding.port-offset=100 &
