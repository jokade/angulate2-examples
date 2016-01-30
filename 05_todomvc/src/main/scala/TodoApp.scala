//     Project: angulate2-examples
//      Module: 05 TodoMVC
// Description: Angulat2 App Component for the TodoMVC example

// Copyright (c) 2016 Johannes Kastner <jokade@karchedon.de>
// Based on the Angular2 TodoMVC example for Angular2 (https://github.com/tastejs/todomvc/tree/master/examples/angular2/)

import angulate2._

@Component(
  selector = "todo-app",
  templateUrl = "src/main/resources/html/app.html",
  providers = @@[TodoStore]
)
class TodoApp(val todoStore: TodoStore) {
  var newTodoText = ""

  def stopEditing(todo: Todo, editedTitle: String): Unit = {
    todo.title = editedTitle
    todo.editing = false
  }

  def cancelEditingTodo(todo: Todo)= todo.editing = false

  def updateEditingTodo(todo: Todo, editedTitle: String): Unit = {
    todo.editing = false
    editedTitle.trim match {
      case "" => todoStore.remove(todo)
      case t => todo.title = t
    }
    todoStore.updateStore()
  }

  def editTodo(todo: Todo) = todo.editing = true

  def removeCompleted() = todoStore.removeCompleted()

  def toggleCompletion(todo: Todo) = todoStore.toggleCompletion(todo)

  def remove(todo: Todo) = todoStore.remove(todo)

  def addTodo() = if(newTodoText.trim!="") {
    todoStore.add(newTodoText)
    newTodoText = ""
  }
}
