#!/bin/bash

kubectl config get-contexts
kubectl config use-context docker-for-desktop

kubectl delete persistentvolumeclaims mariadb-pv mariadbslave-pv
kubectl delete persistentvolumes mariadb-pv mariadbslave-pv
kubectl delete services mariadb
kubectl delete pod java mariadb
