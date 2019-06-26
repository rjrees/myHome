#!/bin/bash


function dev-local()
{
    kubectl config get-contexts
    kubectl config use-context docker-for-desktop
    kubectl create -f  k8/templates/db/db.yaml
    #docker run --name some-mariadb -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mariadb:tag
}

dev-local