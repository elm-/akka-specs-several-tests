import akka.actor._
import akka.testkit._

import org.specs2.mutable._
import org.specs2.time.NoTimeConversions

class ActorSystemRepeatTestKit
    extends Specification
    with NoTimeConversions{
  "actors" should {
    sequential

    "receive and forward message the first time" in new DefaultContext {
      actor ! "hello"

      expectNoMsg

      testProbe.expectMsg("hello")
    }

    "receive and forward message the second time" in new DefaultContext {
      actor ! "hello"

      expectNoMsg

      testProbe.expectMsg("hello")
    }
  }

  abstract class DefaultContext
      extends TestKit(ActorSystem("test-system"))
      with ImplicitSender
      with After {
    val testProbe = TestProbe()

    val actor = system.actorOf(Props(new Actor {
      override def receive = {
        case str: String => testProbe.ref ! str
      }
    }))

    override def after = {
      system.shutdown()
    }
  }
}
