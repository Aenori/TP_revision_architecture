#!/bin/bash
set -euxo pipefail

# Must be run after maven install on the same directory of the pom.xml file
cp target/TP_real_project.war /opt/tomcat/webapps/TP_real_project.war
