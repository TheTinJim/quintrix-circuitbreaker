package com.quintrix.jfs.quintrixcircuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  private Service service;

}

