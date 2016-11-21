//     Project: angulate2-examples
//      Module: 05 TodoMVC
// Description: Todo service.

// Copyright (c) 2016 Johannes Kastner <jokade@karchedon.de>
// Based on the Angular2 TodoMVC example for Angular2 (https://github.com/tastejs/todomvc/tree/master/examples/angular2/)
import angulate2._

import scala.scalajs.js
import scala.scalajs.js.JSON
import org.scalajs.dom.localStorage

@Injectable
class TodoStore {

  var todos =
    JSON.parse( localStorage.getItem("angular2-todos") match {
      case null => "[]"
      case data => data
    }).asInstanceOf[js.Array[Todo]].map( t => new Todo(t._title) )

  def updateStore() = localStorage.setItem("angular2-todos", JSON.stringify(todos))

  private def getWithCompleted(completed: Boolean): js.Array[Todo] = todos.filter( _.completed == completed )

  def allCompleted() : Boolean = todos.forall(_.completed == true)

  def setAllTo(completed: Boolean): Unit = {
    todos.foreach( _.completed = completed )
    updateStore()
  }

  def removeCompleted(): Unit = {
    todos = getWithCompleted(false)
    updateStore()
  }

  def getRemaining() = getWithCompleted(false)

  def getCompleted() = getWithCompleted(true)

  def toggleCompletion(todo: Todo): Unit = {
    todo.completed = !todo.completed
    updateStore()
  }

  def remove(todo: Todo): Unit = {
    todos.splice(todos.indexOf(todo),1)
    updateStore()
  }

  def add(title: String): Unit = {
    todos.push(new Todo(title))
    updateStore()
  }
}
