import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

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

 
}
