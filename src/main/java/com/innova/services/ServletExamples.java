package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Log4j2
@RestController
@RequestMapping("/servlet")
public class ServletExamples {

    @Autowired
    private ServletContext servletContext;



    // http://localhost:8080/servlet/info
    //application.proporties
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<?> gerServletInformation(){
        String secretData=servletContext.getInitParameter("secret information" );
        return ResponseEntity.ok(secretData);
    }

    // http://localhost:8080/servlet/common
    @GetMapping("/common")
    @ResponseBody
    public ResponseEntity<?> gerServletCommon(HttpServletRequest request){
        log.info("info " + request.getPathInfo());
        log.info("method " + request.getMethod());
        log.info("port "+request.getServerPort());
        return ResponseEntity.ok(request.getPathInfo());
    }
}
