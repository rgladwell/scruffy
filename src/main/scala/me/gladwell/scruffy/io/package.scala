package me.gladwell.scruffy

import java.io.File

import scala.language.implicitConversions

package object io {

  implicit def fileToDirectory(file: File) = new Directory(file)

}
