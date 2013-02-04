package ws.antonov.gradle.plugins.protobuf

import org.gradle.api.Project

class ProtobufConvention {
    def ProtobufConvention(Project project) {
        protoDirectory = "${project.buildDir.path}/libs"
        if(System.getProperty('os.name').contains('Linux'))
        {
            protocPath =  "$protoDirectory/protoc-2.4.1.bin"
        }
        else
        {
            protocPath =  "$protoDirectory/protoc-2.4.1.exe"
        }

        extractedProtosDir = "${project.buildDir.path}/extracted-protos"
    }
    def String protoDirectory

    def String protocPath = "protoc"
    /**
     * Directory to extract proto files into
     */
    def String extractedProtosDir
}
