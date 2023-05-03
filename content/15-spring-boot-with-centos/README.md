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

<br>

## Dockerfile Example
* To build an image from the [Dockerfile](./res/Dockerfile), run the following command from `./res`:
    * `docker build -t spring-boot-docker .`
        * Note: there is a `spring-boot-web-0.0.1-SNAPSHOT.jar` in the same directory, which hasn't been commited to git
```Dockerfile
    FROM centos

    RUN cd /etc/yum.repos.d/
    RUN sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
    RUN sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*
    # Error: Failed to download metadata for repo 'appstream': Cannot prepare internal mirrorlist: No URLs in mirrorlist
    # Stack Overflow :: https://stackoverflow.com/questions/70963985/error-failed-to-download-metadata-for-repo-appstream-cannot-prepare-internal/70964301#70964301

    RUN yum install -y java
    # -y :: defaults answers to 'yes'

    VOLUME /tmp
    ADD /spring-boot-web-0.0.1-SNAPSHOT.jar myapp.jar
    RUN sh -c 'touch /myapp.jar'
    # touch :: updates the last modified date on the static resources (e.g images), mitigating caching issues
    ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]
    # urandom trick to get tomcat to start faster
```
* Run the newly created image:
    * `docker run -d -p 8080:8080 spring-boot-docker`