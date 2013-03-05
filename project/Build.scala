import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

<<<<<<< HEAD
  val appName         = "phm_platform"
  val appVersion      = "0.1.0"
  val appScalaVersion = "2.10.0"
  val appScalaBinaryVersion = "2.10"
  val appScalaCrossVersions = Seq("2.10.0")

  lazy val baseSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := appScalaVersion,
    scalaBinaryVersion := appScalaBinaryVersion,
    crossScalaVersions := appScalaCrossVersions,
    parallelExecution in Test := false
  )

  lazy val root = Project("root", base = file("."))
    .settings(baseSettings: _*)
    .settings(
      publishLocal := {},
      publish := {}
    ).aggregate(plugin, scalaSample, javaSample)

  lazy val plugin = Project(appName, base = file("plugin"))
    .settings(baseSettings: _*)
    .settings(
      resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      resolvers += "Spy Repository" at "http://files.couchbase.com/maven2",
      libraryDependencies += "play" %% "play" % "2.1.0" % "provided",
      organization := "com.phmhealth.platform",
      version := appVersion,
      publishTo <<= version { v: String =>
        val nexus = "https://www.phmhealth.com/"
        if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
        else                             Some("releases" at nexus + "service/local/staging/deploy/maven2")
      },
      publishMavenStyle := true,
      publishArtifact in Test := false,
      pomIncludeRepository := { _ => false },
      pomExtra := (
        <url>https://github.com/clouidio/phm_platform</url>
          <licenses>
            <license>
              <name>BSD-style</name>
              <url>http://www.opensource.org/licenses/bsd-license.php</url>
              <distribution>repo</distribution>
            </license>
          </licenses>
          <scm>
            <url>git@github.com:clouidio/phm_platform.git</url>
            <connection>scm:git:git@github.com:clouidio/phm_platform.git</connection>
          </scm>
          <developers>
            <developer>
              <id>you</id>
              <name>PHmHealth</name>
              <url>https://github.com/clouidio</url>
            </developer>
          </developers>
        )
    )

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
}
