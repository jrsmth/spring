# Introduction to Docker
*A platform for running software in containers*

<br>

## Overview
* What is Docker?
    * Docker is platform that allows you to manage the life cycle of containers
    * Using Docker you can run applications on any operating system, in their own segragated environment (a container)
* What is a Container?
    * A Container is an isolated runtime inside of Linux
        * It incorporates the runtime and resources necessary for the software unit running inside of it
        * The containerised software comes in the form on an image
            * An image is a snapshot of a live container, which is used by the Docker Engine to create the container at runtime
                * In this sense, the image is a blueprint for a container - akin to the relationship between a OOP object (container) and its class (image)

    <br>

    <img src="./res/containers.png" width="500" alt="containers">

    <br>
    <br>

    * Comparison with Virtual Machines (VM):
        * A Virtual Machine, the predessor of Containers, is a segegrated virtual environment that is created on physical hardware and behaves as its own compueter system
            * A software layer, called the Hypervisor, separates the VM's resources from the hardware so that is gets dedicates CPU, memory, network interface and storage
            * Each VM will get its own 'guest' operating-system (OS), abstracted from the OS of the host machine
                * With tools like Virtual Box, we can create VM's to run a Windows OS on a Mac by provising some of our Mac hardware to run as a separate virtual computer
        * Containers differ from VM's in that they do not contain their own OS, and do away with the Hypervisor layer
            * Instead they use the OS of the host machine but abstract the containerised software from this

    <br>

    <img src="./res/containers-vs-vm.png" width="500" alt="containers vs vm">

* What is Kubernetes?
    * Container Orchestration Platform, which is what in a nutshell?
