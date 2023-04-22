# Working with Containers & Images
*Productive use of Docker*

<br>

## Overview
* Keeping Docker up to date:
    * Docker Engine: `brew upgrade docker`
    * Docker Desktop: "Check for Updates..."
        * Stack Overflow [post](https://stackoverflow.com/questions/37645134/how-can-i-upgrade-docker-on-a-mac)
    * It is a good idea to restart your machine after updates:
        * Else, you might see: 
            * `docker: Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?.`
* Docker Version:
    * `docker version`:
        * Outputs the version numbers of Docker components
    * `docker --version`:
        * Outputs the version number of the Docker CLI you are using
* Running commands in the terminal vs using Docker Desktop:
    * Both have their merits and so it is probably worth using each from time to time

<br>

## Running MongoDB as a docker container
* `docker run -d -p 27017:27017 mongo`