#!/bin/bash
vault login
vault secrets enable pki
vault secrets enable transit
vault secrets enable database
vault secrets enable ssh
vault policy write admin-policy admin-policy.hcl
vault policy write provisioner-policy provisioner-policy.hcl
