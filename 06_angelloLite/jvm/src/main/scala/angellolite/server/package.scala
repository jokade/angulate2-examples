//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package angellolite

import angellolite.server.StoryService.{UpdateStory, AddStory, Stories, ListStories}
import surf.rest.IntParam
import surf.rest.RESTResponse.{NotFound, NoContent, OK}
import surf.{ServiceProps, ServiceRefRegistry}
import surf.rest.dsl._
import surf.dsl._
import upickle._

package object server {
  private var _registry: ServiceRefRegistry = _

  lazy val storyService = _registry.serviceAt("/angelloLite/StoryService")

  def register(registry: ServiceRefRegistry) = {
    _registry = registry
    registry.registerServices(
      "/angelloLite/StoryService" -> ServiceProps(new StoryService)
    )
  }

  def handler(implicit rp: RequestProvider) =
    prefix("stories") {
      get { implicit act =>
        rp.request.withInput(ListStories).mapOutput{
          case Stories(list) => OK(write(list))
        } >> storyService
      } ~
      post { implicit act =>
        rp.request.withInput(AddStory( read[Story](act.bodyAsString))).mapOutput{
          case _ => NoContent
        } >> storyService
      } ~
      int("id") {
        put {implicit act =>
          val id = IntParam("id",-1)
          val story = read[Story](act.bodyAsString).copy(id=id)
          rp.request.withInput(UpdateStory(story)).mapOutput{
            case None => NotFound
            case _ => NoContent
          } >> storyService
        }
      }
    }
}
