# Spring Kotlin Demo

A collection of Kotlin Spring patterns taken from real projects.

## Want to see an example of how to do X with Kotlin and Spring?

Please leave a Github issue.

## Examples

* The `components/interesting` directory contains some examples of Kotlin's features
* Example of common dependencies: spring-boot-web-app -> api -> (blog) <- blog-storage : (Container -> Web Component -> Domain <- Storage Details)

## Project Structure

Components are defined in `components` and executables are defined in `containers`. Gradle ties them all together via Multi-Project builds (https://docs.gradle.org/3.3/userguide/multi_project_builds.html).

1. Make a `settings.gradle` file:

```bash
touch settings.gradle
```

2. Define a new project in the root `settings.gradle` file:

```groovy
include 'components/blog'
```

3. Make a directory matching the above:

```bash
mkdir -p components/blog
```

4. drop a `build.gradle` file into the `components/blog` directory.

```bash
touch components/blog/build.gradle
```

5. Include `components/blog` code into other projects:

```groovy
dependencies {
    compile(project(":components/blog"))
}
```
