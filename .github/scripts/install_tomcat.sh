#!/bin/bash
set -euxo pipefail
TOMCAT_VERSION='10.0.6'

curl "https://downloads.apache.org/tomcat/tomcat-10/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz" -o /tmp/apache-tomcat-10.tar.gz
mkdir /opt/tomcat
tar xzf /tmp/apache-tomcat*tar.gz -C /opt/tomcat --strip-components=1