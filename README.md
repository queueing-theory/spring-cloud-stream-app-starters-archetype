# Spring Cloud Stream App Starter Archetype (THIS IS NOT AN OFFICIAL Maven Archetype!)
[![Build Status](https://travis-ci.org/queueing-theory/spring-cloud-stream-app-starters-archetype.svg?branch=master)](https://travis-ci.org/queueing-theory/spring-cloud-stream-app-starters-archetype)
[![License](https://img.shields.io/badge/License-Apache%202.0-yellowgreen.svg)](https://opensource.org/licenses/Apache-2.0)  

This is a Maven Archetype for generating a Spring Cloud Stream Starter project scaffold.

### Installation

1. Clone the repo
```sh
https://github.com/queueing-theory/spring-cloud-stream-app-starters-archetype.git
```
2. Install the archetype
```sh
mvn install
```

### Usage

1. run mvn as follows. It will enter its `Interactive mode`
```sh
mvn archetype:generate                                  \
  -DarchetypeGroupId=org.springframework.cloud.stream.app \
  -DarchetypeArtifactId=app-starters-archetype
```

2. provide property values to generate a scaffolding for your new artifact.
```
groupId->org.springframework.cloud.stream.app(default)
artifactId->foo-bar
package->org.springframework.cloud.stream.app(default)
version->2.1.0.BUILD-SNAPSHOT
appType->source
app-starters-build-version->2.1.0.RELEASE
spring-cloud-dependencies-parent-version->2.1.3.RELEASE
```

3. To remove, once your are done with exploring, use the following command.

```sh
rm -rf $HOME/.m2/repository/org/springframework/cloud/stream/app/app-starters-archetype
```


