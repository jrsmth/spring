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

## Running containerised MongoDB
* `docker run -d -p 27017:27017 mongo`
    * Verifying that the container is running:
        1. Check the status in Docker Desktop
        2. Run `docker ps | grep <CONTAINER_NAME>`
        3. Hit `localhost:27017` in the browser

<br>

## Docker Images
* An image is assembled from a 'Dockerfile' and once built is considered immutable
    * The image is built in layers:
        * These layers are used to determine the SHA-256 hash ID that is given to the image at build-time
        * If the layers changes, so does the SHA-256 hash ID
        * The 'IMAGE ID' returned by `docker images` gives us the first 12 characters of this hash ID
            * `docker images -q --no-trunc` will reveal the full ID
* Image Naming Convention:
    * Fully qualified name:
        * `<REGISTRY_HOME>/<USERNAME>/<IMAGE_NAME>:<TAG>`
            * e.g: registry.hub.docker.com/jrsmiffy/jara3:latest
        * Inference if omitted:
            * `<REGISTRY_HOME>`: defaults to 'registry.hub.docker.com'
            * `<TAG>`: defaults to 'latest'
        * Therefore, we conventionally refer to the image as: `<USERNAME>/<IMAGE_NAME>`
            * e.g: jrsmiffy/jara3