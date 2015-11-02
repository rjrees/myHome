#!/bin/bash
#
# Creates database (schema and tables structure), populates tables with static and test data. Runs all update scripts
#
# Params:
# [user to execute as] - default root
# [password] - default root
# [host] - default localhost
# [database to create] - default mot (can be overridden by MOT_DATABASE env variable)
# [user to be granted db access] - default housedbuser
# [full sample data set] - default N. Y = Load full sample data set

set -o errexit
MyUSER=${1-"root"}
MyPASS=${2-"password"}
MyHOST=${3-"localhost"}
MyDATABASE=${4-${DATABASE-"myHouse"}}
MyGRANTUSER=${5-"housedbuser"}
ImportFullTestDataSet=${6-"Y"}

echo "$(date) Create database $MyDATABASE with test data"