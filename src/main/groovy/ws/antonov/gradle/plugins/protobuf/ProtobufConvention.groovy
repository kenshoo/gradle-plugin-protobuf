package ws.antonov.gradle.plugins.protobuf

import org.gradle.api.Project

class ProtobufConvention {
    def ProtobufConvention(Project project) {
        protoDirectory = "${project.buildDir.path}/libs"
        if(System.getProperty('os.name').contains('Linux'))
        {
            if(System.getProperty('os.version').contains('fc19')){
                protocPath =  "$protoDirectory/protoc-2.4.1-fc.bin"
            }else{
                protocPath =  "$protoDirectory/protoc-2.4.1.bin"
            }
        }
        else
        {
            protocPath =  "$protoDirectory/protoc-2.5.0.exe"
        }

        extractedProtosDir = "${project.buildDir.path}/extracted-protos"
    }
    def String protoDirectory

    def String protocPath = "protoc"
    /**
     * Directory to extract proto files into
     */
    def String extractedProtosDir

    /**
     *  List of code generation plugin names
     *  -- Each name will be transformed into '--plugin=protoc-gen-<name>' and '--<name>_out=<generatedFileDir>'
     *  -- Names have to be unique
     */
    def Set protobufCodeGenPlugins = Collections.emptySet()
}
