#Fundamentally this is a playground

##A simple home webservice for things you need in a house.


This was written some time ago as a learning aid for dropwizard, as this has dropped out of favour in usage, this might be re-developed as a number of spring boot micro services using gradle.

# Quick Installation

Before starting make sure you have the following installed

* MacOS environment
* Docker with K8 running - increase Docker memory allocation to at least 6GiB
* AWS Java 11+ Quick Installation

# Example ENV Settings
BANKING_PORT=8081
BANKING_DB_URL=jdbc:mysql://localhost/banking
BANKING_DB_NAME=Bank
BANKING_DB_USERNAME=BankUser
BANKING_DB_PASSWORD=SomePassword

BLOG_PORT=8081
BLOG_DB_URL=jdbc:mysql://localhost/blog
BLOG_DB_NAME=Blog
BLOG_DB_USERNAME=BlogUser
BLOG_DB_PASSWORD=SomePassword
