package me.gladwell.scruffy.io

import java.io.File
import scala.util.{Try, Failure}
import java.io.IOException

import scala.language.postfixOps

class Directory(file: File) {

  def recursiveListFiles: Try[Traversable[File]] = {
    def recursiveListFilesIn(directory: File): Traversable[File] = {
      val these = directory.listFiles
      these ++ these.filter(_.isDirectory).flatMap(recursiveListFilesIn)
    }

    if (file isDirectory) Try(recursiveListFilesIn(file))
    else Failure(new IOException("%s is not a directory".format(file)))
  }

}
