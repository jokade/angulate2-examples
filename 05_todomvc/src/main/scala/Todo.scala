//     Project: angulate2-examples
//      Module: 05 TodoMVC
// Description: Data class for to-dos

// Copyright (c) 2016 Johannes Kastner <jokade@karchedon.de>
// Based on the Angular2 TodoMVC example for Angular2 (https://github.com/tastejs/todomvc/tree/master/examples/angular2/)
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class Todo(private var _title: String) extends js.Object {
  _title = _title.trim
  def title = _title
  def title_=(t: String) = _title = t.trim

  var completed = false
  var editing = false

}
