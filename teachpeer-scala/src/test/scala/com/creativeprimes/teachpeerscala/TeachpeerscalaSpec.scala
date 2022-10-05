package com.creativeprimes.teachpeerscala

import zio.test._
import zio.test.Assertion._
import zhttp.http._

object TeachpeerscalaSpec extends DefaultRunnableSpec {
  override def spec: ZSpec[Environment, Failure] = suite("""TeachpeerscalaSpec""")(
    testM("200 ok") {
      checkAllM(Gen.fromIterable(List("text", "json"))) { uri =>
        val request = Request(Method.GET, URL(!! / uri))
        assertM(Teachpeerscala.app(request).map(_.status))(equalTo(Status.OK))
      }
    },
  )
}
