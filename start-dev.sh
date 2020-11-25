#!/bin/bash


function dev-local()
{
    kubectl config get-contexts
    kubectl config use-context docker-desktop
    kubectl create namespace myhome
    kubectl create -f k8/templates/db/db.yaml
    kubectl create -f k8/templates/java/java.yaml
    #docker run --name some-mariadb -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mariadb:tag
}

dev-local