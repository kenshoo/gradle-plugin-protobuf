# Protobuf Plugin for Gradle
The Protobuf plugin provides protobuf compilation to your project.

No need to install protobuf it will download from our repo!

## Usage
To use the protobuf plugin, include in your build script:

```groovy
apply plugin: 'protobuf'

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'ws.antonov.gradle.plugins:gradle-plugin-protobuf:0.8'
    }
}

dependencies {
    // If you have your protos archived in a tar file, you can specify that as a dependency
    //   ... alternative archive types supported are: jar, tar, tar.gz, tar.bz2, zip
    protobuf files("lib/protos.tar.gz")
    // Different configuration fileSets are supported
    testProtobuf files("lib/protos.tar")
}
```
