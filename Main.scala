import zio.http._

val app = Http.collectZIO[Request] {
    case req @ Method.GET -> !! / "fruits" / "a"  =>
      UIO(Response.text("URL:" + req.url.path.asString + " Headers: " + req.getHeaders))
    case req @ Method.POST -> !! / "fruits" / "a" =>
      req.bodyAsString.map(Response.text(_))
  }