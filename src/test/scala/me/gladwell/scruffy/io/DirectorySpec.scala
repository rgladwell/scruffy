package me.gladwell.scruffy.io

import java.io.File
import org.scalatest.{FlatSpec, TryValues, Matchers}

import me.gladwell.scruffy.io._

class DirectorySpec extends FlatSpec with Matchers with TryValues {

  private val thisFile = new File("./src/test/scala/me/gladwell/scruffy/io/DirectorySpec.scala")

  "Directory" should "recursively find all files" in {
    new File("./src/test/").recursiveListFiles.get should contain (thisFile)
  }

  it should "return failure on recursive list for a non-directory" in {
    thisFile.recursiveListFiles.isFailure should be (true)
  }

}
