#!/bin/bash
set -eo pipefail

bash /opt/tomcat/bin/catalina.sh run&

for i in $(seq 0 15)
do
	curl http://localhost:8080 1> /dev/null && break
	
	echo "Waiting 1 seconds for Tomcat to start"

	if [ "$i" -eq "15" ]
	then
		echo "ERROR : Tomcat didn't start in 15 seconds"
		exit 1
	fi

	sleep 1
done
# Check tomcat is running
