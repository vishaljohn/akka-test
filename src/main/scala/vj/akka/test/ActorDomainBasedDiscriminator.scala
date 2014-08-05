package vj.akka.test

import ch.qos.logback.classic.spi.LoggingEvent
import ch.qos.logback.core.sift.Discriminator
import ch.qos.logback.core.spi.ContextAwareBase

class ActorDomainBasedDiscriminator extends ContextAwareBase with Discriminator[LoggingEvent] {
  private val Key = "actorDomain";

  @volatile
  private var _isStarted = false;

  def getDiscriminatingValue(event: LoggingEvent) = {
    val loggerName = event.getLoggerName
    if(loggerName.startsWith("Domain"))
      loggerName
    else event.getLevel.toString
  }
  
 def getKey: String = Key

  def isStarted: Boolean = _isStarted

  def start(): Unit = _isStarted = true

  def stop(): Unit = _isStarted = false
  
}