# Noteworthy Docker Commands

<br>

* Pull image to local machine:
    * `docker pull <IMAGE_NAME>`

<br>

* Run a container:
    * `docker run --name=<OPTIONAL_CONTAINER_NAME> <IMAGE_NAME>`
    * `docker run -d <IMAGE_NAME>` :: runs the container in the background (detached / non-interactive)
    * `docker run -p <CONTAINER_PORT>:<HOST_PORT>` :: maps a container port to a port on your local machine
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




delete an image...





https://springframework.guru/docker-cheat-sheet-for-spring-devlopers/
Go through^ this at the end of the docker sections to glean any last useful bits...

