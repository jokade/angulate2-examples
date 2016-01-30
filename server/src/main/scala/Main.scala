import slogging.{LogLevel, PrintLoggerFactory, LoggerConfig}
import surf.rest.http.SimpleRESTServer
import surf.rest.{ContentType, RESTHandler, RESTService, RESTResolver}

//     Project: angulate2-examples
//      Module: server
// Description: Main class for the HTTP server

// Copyright (c) 2016 Johannes Kastner <jokade@karchedon.de>


object Main extends App {
  import concurrent.ExecutionContext.Implicits.global
  import surf.ServiceRefFactory.Sync
  import surf.rest.dsl._

  LoggerConfig.factory = PrintLoggerFactory()
//  LoggerConfig.level = LogLevel.TRACE

  val resolver = RESTResolver.fromService(new RESTService {
    override def handle: RESTHandler =
      get { _ =>
        respondWithResource("index.html", ContentType.HTML)
      } ~
      prefix("01") {
        get { _ =>
          respondWithResource("01_firstApp/index.html", ContentType.HTML)
        } ~
        serveStatic("01_firstApp/")
      } ~
      prefix("02") {
        get { _ =>
          respondWithResource("02_displayData/index.html", ContentType.HTML)
        } ~
        serveStatic("02_displayData/")
      } ~
      prefix("04") {
        get { _ =>
          respondWithResource("04_heroes/index.html", ContentType.HTML)
        } ~
        serveStatic("04_heroes/")
      } ~
      prefix("05") {
        get { _ =>
          respondWithResource("05_todomvc/index.html", ContentType.HTML)
        } ~
        serveStatic("05_todomvc/")
      }
  })

  SimpleRESTServer(8080,"/",resolver).start().waitForEnter()
}
