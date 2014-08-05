package vj.akka.test

import akka.actor._
import org.slf4j.LoggerFactory

object Main {
  
  val logger = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]): Unit = {
    logger.debug("Starting application")
    val system = ActorSystem("test-system")
    val actor1 = system.actorOf(Props[Actor1])
    val actor2 = system.actorOf(Props[Actor2])
    
    actor1 ! "ABC"
    actor1 ! "DEF"
    actor2 ! "XYZ"
  }

}