package com.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/async")
@CrossOrigin(origins = "*")
public class Controller {

  private final Logger log = LoggerFactory.getLogger(AsyncTestComp.class);
  private final AsyncTestComp asyncTestComp;

  @Autowired
  public Controller(AsyncTestComp asyncTestComp) {
    this.asyncTestComp = asyncTestComp;
  }


  @PostMapping("/test")
  public ResponseEntity<String> test(@RequestBody String email) throws InterruptedException {
    asyncTestComp.notifyUser("email");
    asyncTestComp.otherLogic();
    return ResponseEntity.status(HttpStatus.OK).body("success");
  }
}
