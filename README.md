# Spring Kotlin Demo

A collection of Kotlin Spring patterns taken from real projects.

## Want to see an example of how to do X with Kotlin and Spring?

Please leave a Github issue.

## Examples

* The `components/interesting` directory contains some examples of Kotlin's features
* Example of common dependencies: spring-boot-web-app -> api -> (blog) <- blog-storage : (Container -> Web Component -> Domain <- Storage Details)

## Project Structure

Components are defined in `components` and executables are defined in `containers`. Gradle ties them all together via Multi-Project builds (https://docs.gradle.org/3.3/userguide/multi_project_builds.html).

1. Define a project in settings.gradle

```groovy
include 'components/blog'
```

2. Make a directory matching the above:

```bash
mkdir -p components/blog
```

3. drop a `build.gradle` file into the `components/blog` directory.

```bash
touch components/blog/build.gradle
```

4. Include `components/blog` code into other projects:

```groovy
dependencies {
    compile(project(":components/blog"))
}
```
