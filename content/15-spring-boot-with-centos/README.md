# Running Spring Boot In A Centos Image
*Creating a docker image that runs a Spring Boot Jar*

<br>

## Overview
* CentOS vs RHEL:
    * Red Hat Enterprise Linux (RHEL) is the commerical version of CentOS, offered by RedHat on a subscription basis
    * CentOS (Community ENTerprise Operating System) is a popular open-source Linux distribution
    * CentOS and RHEL are virtually identical once you're in the terminal, as they share the same source code
* Preparation for Java Development:
    * `docker run -d -n centos-jrs centos` will start and stop immediately because it does not have a infinite command that executes
        * `docker run -d centos tail -f /dev/null` is a hack to get the container to keep running
            * `docker exec -it centos-jrs bash` gives us terminal access to the live container
            * `yum install java` will install java on the container