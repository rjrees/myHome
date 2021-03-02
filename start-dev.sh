#!/bin/bash


function dev-local()
{
    kubectl config get-contexts
    kubectl config use-context docker-desktop
    kubectl create namespace myhome
    kubectl create -f k8/templates/db/db.yaml -n myhome
    kubectl create -f k8/templates/java/java.yaml -n myhome
    #docker run --name some-mariadb -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mariadb:tag
}

dev-local