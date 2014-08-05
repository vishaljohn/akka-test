package vj.akka.test

import akka.actor.Actor
import org.slf4j.LoggerFactory

class Actor1 extends Actor {
  
  private val logger = LoggerFactory.getLogger("Domain1")
  
  override def receive = {
    case msg: String =>  logger.debug(s"Actor1 recevied message: $msg")
  }

}