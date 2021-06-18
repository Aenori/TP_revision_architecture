#!/bin/bash
docker build . -t jakartaee
docker run --name jakartaee_test jakartaee bash -c "bash test_as_shell/run_tomcat.sh > /dev/null && bash test_as_shell/test_all.sh"
docker container rm jakartaee_test
