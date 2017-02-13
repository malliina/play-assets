import com.malliina.sbt.filetree.FileTreeKeys._
import com.malliina.sbt.filetree.FileTreePlugin
import com.malliina.sbtplay.PlayProject
import com.typesafe.sbt.web.Import.Assets
import sbt.Keys._
import sbt._

object PlayBuild {
  lazy val playAssets = PlayProject.default("play-assets")
    .enablePlugins(FileTreePlugin)
    .settings(commonSettings: _*)

  val utilPlayDep = "com.malliina" %% "util-play" % "3.5.3"

  lazy val commonSettings = listPlaySettings ++ Seq(
    organization := "com.malliina",
    version := "0.0.1",
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq(
      utilPlayDep,
      utilPlayDep % Test classifier "tests"
    )
  )

  def listPlaySettings = Seq(
    fileTreeSource := (resourceDirectory in Assets).value,
    fileTreeMapper := "controllers.routes.Assets.at",
    fileTreePackageName := "com.malliina.assets"
  )
}
