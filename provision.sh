#!/bin/bash
set -eux

function ubuntu(){
    apt update

    # Poached these directions from
    # https://docs.docker.com/install/linux/linux-postinstall/#manage-docker-as-a-non-root-user

    wget -qO- https://deb.nodesource.com/setup_8.x | sudo -E bash -


    apt-get install -y openjdk-8-jdk apt-transport-https ca-certificates curl software-properties-common

    sudo snap install conjure-up --classic
    # re-login may be required at that point if you just installed snap utility
    conjure-up kubernetes
}

function rhel()
{

    cat <<EOF > /etc/yum.repos.d/kubernetes.repo

[kubernetes]

name=Kubernetes

baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64

enabled=1

gpgcheck=1

repo_gpgcheck=1

gpgkey=https://packages.cloud.google.com/yum/doc/yum-key.gpg https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg

EOF
    sudo yum -y install docker curl openjdk-8-jdk vim git kubelet kubeadm kubectl
    sudo usermod -aG dockerroot vagrant
    sudo systemctl enable docker.service
    sudo systemctl start docker
    bindir='/usr/bin/oc'
    sudo chown root:dockerroot /var/run/docker.sock

}

if [ -f /etc/redhat-release ]; then
   rhel
elif [ -f /etc/lsb-release ]; then
   ubuntu
else
   echo "Operating system undetected"
   exit 1
fi

# Append /etc/default/docker file to allow IP range for insecure registry
echo '{ "insecure-registries": ["172.30.0.0/16"] }' > /etc/docker/daemon.json
sudo service docker restart



# # # Pull Repo for testing purposes. Final work will create image and run app with one command.

#kubectl cluster up
#kubectl login -u system:admin
#kubectl adm policy add-cluster-role-to-user cluster-admin system
kubectl create namespace myhome