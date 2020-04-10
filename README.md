# kafka &middot; spark streaming example

[![Build Status](https://travis-ci.org/trK54Ylmz/kafka-spark-streaming-example.svg?branch=master)](https://travis-ci.org/trK54Ylmz/kafka-spark-streaming-example)

I am using this sample project for Kafka Producer & Entities.

### Prerequisites

Java 1.8 or newer version required because lambda expression used for few cases

1. Java >= 1.8 (Oracle JDK has been tested)
2. Maven >= 3
3. Apache Spark >= 2.4.3
4. Kafka >= 0.10.1.0

### Installation

First of all, clone the git repository,

```bash
$ git clone git@github.com:thiyagarajan-g/kafka-spark-streaming-example
```

after you need to use Maven for creating uber jar files,

```bash
$ mvn clean package install -DskipTests
```

until that moment we had created jar files and now we'll install Kafka and MySQL,

```bash
$ wget http://www-us.apache.org/dist/kafka/0.10.1.0/kafka_2.11-0.10.1.0.tgz
$ # or wget http://www-eu.apache.org/dist/kafka/0.10.1.0/kafka_2.11-0.10.1.0.tgz
$ tar -xf kafka_2.11-0.10.1.0.tgz
$ cd kafka_2.11-0.10.1.0
$ nohup ./bin/zookeeper-server-start.sh ./config/zookeeper.properties > /tmp/kafka-zookeeper.out 2>&1 &
$ nohup ./bin/kafka-server-start.sh ./config/server.properties > /tmp/kafka-server.out 2>&1 &
```

### Usage

1 - Start the Kafka producer and it'll write events to Kafka topic,

```bash
$ java -Dconfig=./config/common.conf -jar producer/target/kafka-producer-0.1.jar
```
