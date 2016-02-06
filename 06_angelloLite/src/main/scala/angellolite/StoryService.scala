//     Project: root
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package angellolite

import angulate2._
import angulate2.http.{Response, Http}

import scala.scalajs.js

@Injectable
@debug()
class StoryService(http: Http) {
  val stories = js.Array(
      Story(
      title = "First story",
      description = "Our first story.",
      criteria = "Criteria pending.",
      status = "To Do",
      storyType = "Feature",
      reporter = "Lukas Ruebbelke",
      assignee = "Brian Ford"
    ),
    Story(
      title = "Second story",
      description = "Do something.",
      criteria = "Criteria pending.",
      status = "Back Log",
      storyType = "Feature",
      reporter = "Lukas Ruebbelke",
      assignee = "Brian Ford"
    )
  )

  http.get("/05").subscribe((res:Response)=> println(res.status))

  def create(): Unit = stories.push(Story("","","","","","",""))
}
