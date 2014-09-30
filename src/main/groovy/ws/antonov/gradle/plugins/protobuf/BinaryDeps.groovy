package ws.antonov.gradle.plugins.protobuf

import org.gradle.api.tasks.Sync

class BinaryDeps {

    def isLinux = (System.getProperty('os.name').contains('Windows')) == false

    def isFedora = (System.getProperty('os.version').contains('fc19')) == true

    def executable = {project ->
        def dep = project.configurations.binary.allDependencies.toArray()[0]
        "${dep.name}-${dep.version}".toString()
    }

    def applyBinary(project){
        applyDeps(project)
        project.task([type:Sync],'setupBinary') {
            from project.configurations.binary
            into "${project.buildDir}/libs"
            doLast{
                if(isLinux){
                    project.exec {
                        commandLine 'chmod', '+x' , "${project.buildDir}/libs/${this.executable(project)}.bin"
                    }
                }
            }
        }
    }

    def applyDeps(project){
        project.configurations {
            binary
        }

        project.dependencies {
            if(isLinux){
                if(!isFedora){
                    binary group:'com.google', name:'protoc', version:'2.5.0', ext:'bin'
                }else{
                    binary group:'com.google', name:'protoc', version:'2.5.0-fc', ext:'bin'
                }
            }else{
                binary group:'com.google', name:'protoc', version:'2.5.0', ext:'exe'
            }
        }
    }
}
