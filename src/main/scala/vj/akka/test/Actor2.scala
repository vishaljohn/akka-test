package vj.akka.test

import akka.actor.Actor
import org.slf4j.LoggerFactory

class Actor2 extends Actor {
  
  private val logger = LoggerFactory.getLogger("Domain2")
  
  override def receive = {
    case msg: String =>  logger.debug(s"Actor2 recevied message: $msg")
  }

}