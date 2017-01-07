//     Project: angulate2-examples
// Description: Data service for Heroes

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2.std._
import angulate2.http.Http
import rxjs.RxPromise

import scala.scalajs.js

@Injectable
class HeroService(http: Http) {
  private val heroesUrl = "app/heroes"

  def getHeroes: RxPromise[js.Array[Hero]] = http.get(heroesUrl).toPromise
    .map(_.jsonData[js.Array[Hero]])
    .onError( handleError _ )

  def getHero(id: Int): RxPromise[Hero] = getHeroes map( _.find(_.id==id).get )

  def update(hero: Hero): RxPromise[Hero] = {
    val url = s"$heroesUrl/${hero.id}"
    http.putJson(url, hero).toPromise
      .map(_ => hero)
      .onError( handleError _ )
  }

  def create(name: String): RxPromise[Hero] = http
    .postJson(heroesUrl,js.Dictionary("name"->name))
    .toPromise
    .map( _.jsonData[Hero] )
    .onError( handleError _ )

  def delete(id: Int): RxPromise[Unit] = http
    .delete(s"$heroesUrl/$id")
    .toPromise
    .map( _ => () )
    .onError( handleError _ )

  private def handleError(error: js.Any) = js.Dynamic.global.console.log(error)

}
