//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2._
import angulate2.http.Http
import rxjs.Observable

import scala.scalajs.js

@Injectable
class HeroSearchService(http: Http) {

  def search(term: String): Observable[js.Array[Hero]] = http
    .get(s"app/heroes/?name=$term")
    .map( (res,index) => res.jsonData[js.Array[Hero]] )

}
