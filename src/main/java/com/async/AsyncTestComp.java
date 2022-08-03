package com.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTestComp {

  private final Logger log = LoggerFactory.getLogger(AsyncTestComp.class);

  @Async
  public void notifyUser(String email) {
    log.info("Notifying user on thread: {}", Thread.currentThread().getName());
    log.info("Sent email to: {}", email);
  }

  @Async
  public void otherLogic() throws InterruptedException {
    log.info("Processing other logic on thread: {}", Thread.currentThread().getName());
    Thread.sleep(5000);
    log.info("Completed processing other logic");
  }
}
