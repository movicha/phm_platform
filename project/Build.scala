import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

<<<<<<< HEAD
<<<<<<< HEAD
  val appName         = "phm_platform"
  val appVersion      = "0.1.0"
=======
   val appName         = "phmpApp"
   val appVersion      = "1.0-SNAPSHOT"
   
>>>>>>> 1a77e72f9ce3e1c2d68b7dd77aff405cb5c87050
  val appScalaVersion = "2.10.0"
  val appScalaBinaryVersion = "2.10"
  val appScalaCrossVersions = Seq("2.10.0")
  

  
val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
      "org.hibernate" % "hibernate-entitymanager" % "4.1.9.Final", "org.hibernate" % "hibernate-validator" % "4.2.0.Final",
       "mysql" % "mysql-connector-java" % "5.1.18"
  )

 
  
  
 val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    ebeanEnabled := false
    )

<<<<<<< HEAD
    lazy val scalaSample = play.Project(
      "scala-sample",
      path = file("samples/scala")
    ).settings(
      scalaVersion := appScalaVersion,
      scalaBinaryVersion := appScalaBinaryVersion,
      crossScalaVersions := appScalaCrossVersions,
      crossVersion := CrossVersion.full,
      parallelExecution in Test := false,
      publishLocal := {},
      publish := {}
    ).dependsOn(plugin)

    lazy val javaSample = play.Project(
      "java-sample",
      path = file("samples/java")
    ).settings(baseSettings: _*).settings(
      publishLocal := {},
      publish := {}
    ).dependsOn(plugin)

=======
   val appName         = "phmpApp"
   val appVersion      = "1.0-SNAPSHOT"
   
  val appScalaVersion = "2.10.0"
  val appScalaBinaryVersion = "2.10"
  val appScalaCrossVersions = Seq("2.10.0")
  

  
val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
      "org.hibernate" % "hibernate-entitymanager" % "4.1.9.Final", "org.hibernate" % "hibernate-validator" % "4.2.0.Final",
       "mysql" % "mysql-connector-java" % "5.1.18"
  )

 
  
  
 val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    ebeanEnabled := false
    )

 
>>>>>>> c835a338e5c253783bd25a0b87ef9bb784bf4d65
=======
 
>>>>>>> 1a77e72f9ce3e1c2d68b7dd77aff405cb5c87050
}
