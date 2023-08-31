# JMS Messaging
*The Java-standard API specification for messaging*

<br>

## Exercises
* [sfg-jms](./exercises/sfg-jms) `@SfgClone(branch="~final")` `@Modified`

<br>

## Overview
* The Java Messaging Service (JMS) is the specification which sets out the standard for messaging within Java applications
    * Similar to the relationship between JPA and Hibernate - where JPA is the specification, that Hibernate implements
        * So too, JMS is the specification for which there are various implementations for messaging
* JMS allows you to send messages from one application to another:
    * It is highly-scalable and allows you to loosely-couple applications through asynchronous messaging
* JMS Providers:
    * Apache ActiveMQ
    * RabbitMQ
    * JBoss Messaging
    * Cloud Providers: AWS, IBM, Oracle, etc
* Why use JMS over REST?
    * JMS can be used to simulate the functionality of using RESTful
    * Asynchronous - fire and forget
    * More performant - greater throughput then HTTP protocol
    * Message delivery is flexible - deliver to one or many clients
    * JMS has very robust security and reliability 
* Types of Messaging:
    * Point to Point:
        * Message is queued and delivered to one consumer only
        * Multiple consumers can connect to the queue but the message is only delivered once (to a single consumer only)
    * Publish / Subscribe:
        * Message is delivered to one or more subscribers
        * Subscribers will subscribe to a 'topic' and then receive a copy of all messages sent to that topic
* JMS Messages:
    * Structure:
        * Header: contains message meta-data
        * Properties: contains 3 sections of information about the message:
            * Application: details about the Java application sending the message
            * Provider: JMS implementation-specific details used by the JMS provider
            * Standard Properties: details defined by the JMS API itself (may or may not be supported by the JMS provider)
        * Payload: the message itself
    * Message Properties:
        * There are various properties that can be set on a message, including those of a custom-nature
    * Message Types:
        * Message: just a message, without payload - often properties are used for notification about an event
        * BytesMessage: payload is array of bytes
        * TextMessage: payload is a string (often JSON or XML)
            * This is the current best-practise type for JMS messaging
        * StreamMessage: payload is sequence of Java primitives
        * MapMessage: payload of key-value pairs
        * ObjectMessage: payload is a serialised Java object