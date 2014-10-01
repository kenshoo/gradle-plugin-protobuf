package protobuf

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
import ws.antonov.gradle.plugins.protobuf.BinaryDeps
import static org.junit.Assert.assertEquals

class ProntobufPluginTest {

  def binary = new BinaryDeps()

  @Test
  void binaryDepsSanity(){
    Project project = ProjectBuilder.builder().withName("test-project").build()
    binary.applyBinary(project)
    def deps = project.configurations.binary.allDependencies
    if(binary.isLinux){
      deps.toArray()[0].with{
        assertEquals('protoc-2.4.1',"${binary.executable(project)}".toString())
      }
    } else {
        assertEquals('protoc',project.configurations.binary.allDependencies.name[0])
    }
  }
}

