# Spring Data MongoDB
*Exploring MongoDB for later use in reactive programming*

<br>

## Overview
* [Introduction to MongoDB](./res/IntroductionToMongoDB.pdf)
* MongoDB is a document-oriented database, whose name derives from the word 'Humongous'
* MongoDB is NoSQL:
    * This means that data is stored in documents, rather than tables (as you have with relational databases)
* Mongo use cases:
    * Typically used when you have high insert systems - such as sensor readings, social media and advertising
    * It offers schema flexibility and supports a high number of reads per second
* Mongo downsides:
    * No A.C.I.D compliance
        * A.C.I.D :: Atomicity, Consistency, Isolation, and Durability
    * Industry jokes about lost data
    * No concepts of transactions and not good for concurrent updates
        * This is the trade off for the speed that Mongo offers
* Terminology:
    
    <img src="./res/mongo-terminology.png" width="500">