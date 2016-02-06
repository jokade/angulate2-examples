//     Project: root
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package angellolite

import angulate2._
import angulate2.http.Http

import scala.scalajs.js

@Injectable
@debug
class StoryService(http: Http) {
  var stories: js.Array[Story] = _
  load()

  def load() = http.get("/06/data/stories").json[js.Array[Story]].subscribe( stories = _ )

  def create(): Story = {
    val s = Story(-1,"","","","","","","")
    stories.push(s)
    s
  }

  def saveStory(s: Story) =
    if(s.id < 1)
      http.postObject("/06/data/stories",s).subscribe(_ => ())
    else
      http.putObject(s"/06/data/stories/${s.id}",s).subscribe(_ => ())
}

