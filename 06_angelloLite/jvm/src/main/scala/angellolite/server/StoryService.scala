//     Project: angulate2-examples
//      Module: 06 AngelloLite / jvm
// Description: Server-side data service for StoryS

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package angellolite.server

import angellolite.Story
import angellolite.server.StoryService.{UpdateStory, AddStory, Stories, ListStories}
import surf.Service.Processor
import surf._

class StoryService extends Service {
  private var _stories = StoryService.stories

  override val process: Processor = {
    case ListStories if isRequest => request ! Stories(_stories.values)
    case AddStory(s) if isRequest => request ! addStory(s)
    case UpdateStory(s) if isRequest => request ! updateStory(s)
  }

  private def addStory(story: Story) = {
    val id = _stories.size+1
    _stories += (id -> story.copy(id=id))
  }

  private def updateStory(story: Story) =
    if(_stories.contains(story.id))
      _stories += (story.id -> story)
    else
      None
}

object StoryService {

  case class Stories(list: Iterable[Story])

  case class AddStory(story: Story)

  case class UpdateStory(story: Story)

  case object ListStories

  val stories = Seq(
    Story(1,
      title = "First story",
      description = "Our first story.",
      criteria = "Criteria pending.",
      status = "To Do",
      storyType = "Feature",
      reporter = "Lukas Ruebbelke",
      assignee = "Brian Ford"
    ),
    Story(2,
      title = "Second story",
      description = "Do something.",
      criteria = "Criteria pending.",
      status = "Back Log",
      storyType = "Feature",
      reporter = "Lukas Ruebbelke",
      assignee = "Brian Ford"
    )
  ).map( s => (s.id,s)).toMap

}
