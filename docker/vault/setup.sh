#!/bin/bash
function pki()
{
  vault secrets enable pki
  vault write pki/root/generate/internal common_name=pariah.internal ttl=8760h
}

function users()
{
  vault auth enable userpass
  vault write auth/userpass/users/richie password=Pa22w0rd policies=admin
}

function database()
{
  vault secrets enable database
  vault write database applications/bankingApi/db/postgresdb plugin_name="postgres" username={{ username}} connection_url='bankdb:5432' allowed_roles='bank_api_db' password={{ password }}
  vault write database put secrets/applications/bankingApi/db/postgresdb postgres=mysecretkey
}

function ssh()
{
  vault secrets enable ssh
}

function transit()
{
  vault secrets enable transit
}



if [ -z "$VAULT_ADDR" ]; then
  echo 'Set the VAULT_ADDR environment variable'
else
  vault login
  vault secrets enable pki
  vault -autocomplete-install
  vault policy write admin-policy admin-policy.hcl
  vault policy write provisioner-policy provisioner-policy.hcl
  vault policy write myHome myHome-acl.hcl
fi