listener "tcp" {
  address       = "0.0.0.0:8200"
  tls_cert_file = "/path/to/fullchain.pem"
  tls_key_file  = "/path/to/privkey.pem"
}

storage "consul" {
  address = "[consul address]"
  path = "vault/"
  token = "<TOKEN from Step 4 - #10>"
}