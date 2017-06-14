import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.UnknownConfigurationException
import org.gradle.api.tasks.Exec

class DependencyGraphPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task("generate-dependency-graph-dot") {
            mustRunAfter "clean"
            def graphBuildDir = "build/dependency-graph"
            def dotFile = project.file "$graphBuildDir/dependencies.dot"

            doLast {
                project.delete graphBuildDir
                project.mkdir graphBuildDir
                dotFile << "digraph dependencies {\n"
                project.subprojects.forEach {
                    Project subProject -> try {
                        Configuration compileConfig = subProject.configurations["compile"]
                        compileConfig .dependencies .grep {
                            it.respondsTo("getDependencyProject")
                        } .forEach {
                            dotFile << """ "$subProject.name" -> "$it.dependencyProject.name"\n"""
                        }
                    } catch (UnknownConfigurationException ignored) { }
                }
                dotFile << "}\n"
            }
        }

        project.task("dependencies-graph", type: Exec, dependsOn: "generate-dependency-graph-dot") {
            workingDir "$project.buildDir/dependency-graph"
            commandLine "dot", "-o", "graph.png", "-Tpng", "dependencies.dot"
        }
    }
}