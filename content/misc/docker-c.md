# Noteworthy Docker Commands

<br>

### Docs
* Official [Docs](https://docs.docker.com/)
* Spring Guru Docker [Cheatsheet](
https://springframework.guru/docker-cheat-sheet-for-spring-devlopers/)

<br>

### Commands
* Pull image to local machine:
    * `docker pull <IMAGE_NAME>`

<br>

* Run a container:
    * `docker run --name=<OPTIONAL_CONTAINER_NAME> <IMAGE_NAME>`
    * `docker run -d <IMAGE_NAME>` :: runs the container in the background (detached / non-interactive)
    * `docker run -p <HOST_PORT>:<CONTAINER_PORT>` :: maps a port on your local machine to a container port
    * note: if the image doesn't exist locally, `docker pull` will be executed first

<br>

* Stop a container:
    * `docker stop <CONTAINER_NAME_OR_ID>`

<br>

* List all currently running containers:
    * `docker ps`
    * `docker ps -a` :: lists all containers (inc stopped)

<br>

* List all local images:
    * `docker images`
    * `docker images -q --no-trunc` :: view the full SHA-256 image ID's

<br>

* View container logs printed to standard out (STDOUT):
    * `docker logs`
    * `docker logs -f` :: follows (tails) the logs

<br>

* Delete docker images:
    * `docker image rm <IMAGE_NAME>:<TAG_NAME>`
        * `docker rmi <IMAGE_NAME>:<TAG_NAME>` :: shorthand
    * `docker rmi $(docker images -q -f dangling=true)` :: delete untagged (dangling) images
    * `docker rmi $(docker images -q)` :: delete all images

<br>

* Stop all running docker containers:
    * `docker kill $(docker ps -q)` :: `-q` for 'quiet'

<br>

* Delete all non-running docker containers:
    * `docker rm $(docker ps -a -q)`

<br>

* Delete all dangling volumes:
    * `docker volume rm $(docker volume ls -f dangling=true -q)`

<br>

* Open a terminal shell for live docker container:
    * `docker exec -it <CONTAINER_NAME> bash`